package com.iup.tp.twitup.ihm.menubar.view;
import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInViewImplFX;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpViewImplFX;
import com.iup.tp.twitup.ihm.event.TwitupWatchable;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainView;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitViewImplFX;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;
import com.iup.tp.twitup.ihm.user.TwitupUserView;
import com.iup.tp.twitup.ihm.user.TwitupUserViewImplFX;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TwitupMenuBarMainViewImplFX extends Application implements TwitupMenuBarView, TwitupAccountActionView, TwitupMainView {


    MenuBar menuBar = new MenuBar();
    
    Menu menuFile = new Menu("Fichier");
    MenuItem repItem = new MenuItem("R�pertoire d'�change");
    MenuItem quitItem = new MenuItem("Quitter");
	GridPane mainPane = new GridPane();
	GridPane twitPane = new GridPane();
	
    Menu menuCompte = new Menu("Compte");
    MenuItem creerItem = new MenuItem("Cr�er un compte");
    MenuItem connexItem = new MenuItem("Connexion");
    MenuItem decoItem = new MenuItem("D�connexion");
    
    Menu menuAbout = new Menu("?");
    MenuItem aproposItem = new MenuItem("A Propos");
    
	TwitupLogInViewImplFX connexionPane = new TwitupLogInViewImplFX();
	TwitupSignUpViewImplFX creationComptePane = new TwitupSignUpViewImplFX();
	
	TwitupUserViewImplFX gauche; 
	TwitupTwitViewImplFX droit; 
	
	Scene scene = new Scene(mainPane, 850, 500, Color.LIGHTBLUE);
	
	// Watchers
	TwitupWatchable closeWatcher = new TwitupWatchable();
	TwitupWatchable aboutWatcher = new TwitupWatchable();
	TwitupWatchable modifyExchangeFolderWatcher = new TwitupWatchable();
	TwitupWatchable signUpWatcher = new TwitupWatchable();
	TwitupWatchable signInWatcher = new TwitupWatchable();
	TwitupWatchable signOutWatcher = new TwitupWatchable();

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setMinWidth(855);
		primaryStage.setMinHeight(500);
        
        // --- Menu File
        repItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("r�pertoire d'�change");
				modifyExchangeFolderWatcher.sendEvent();
			}
        });

        quitItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Quitter");
				//primaryStage.close();
				closeWatcher.sendEvent();
			}
        });
 
        // --- Menu Edit
        creerItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				signUpWatcher.sendEvent();
				//chargementCreationCompte();
				System.out.println("cr�er un compte");
			}
        });

        connexItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Connexion");
				signInWatcher.sendEvent();
				//chargementConnexion();
			}
        });

        decoItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("D�connexion");
				signOutWatcher.sendEvent();
			}
        });
 
        // --- Menu View
        aproposItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("A Propos");
				aboutWatcher.sendEvent();
			}
        });
        
        menuFile.getItems().addAll(repItem, quitItem);
        menuCompte.getItems().addAll(creerItem, connexItem, decoItem);
        menuAbout.getItems().addAll(aproposItem);
        
		menuBar.setPrefWidth(scene.getWidth());
        
        menuBar.getMenus().addAll(menuFile, menuCompte, menuAbout);

        
		
		primaryStage.setTitle("Twitup");

		//ajout d'un event sur le redimensionnement de la fenetre pour que la barre de menu ai une taille similaire � la taille de l'�cran 
		scene.widthProperty().addListener(new ChangeListener<Number>() {
		    @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
		    	menuBar.setPrefWidth(newSceneWidth.doubleValue());
		    }
		});
		scene.heightProperty().addListener(new ChangeListener<Number>() {
		    @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
		    }
		});
		
		mainPane.setHgap(10);
		
		chargementTwitup();
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public void chargementConnexion(){
		mainPane.getChildren().clear();
		mainPane.add(menuBar,  0, 0, 1, 1);
		mainPane.add(connexionPane, 0, 1, 1, 1);
		GridPane.setVgrow(connexionPane, Priority.ALWAYS);
		scene.setRoot(mainPane);
	}
	
	public void chargementCreationCompte(){
		mainPane.getChildren().clear();
		mainPane.add(menuBar,  0, 0, 1, 1);
		mainPane.add(creationComptePane, 0, 1, 1, 1);
		GridPane.setVgrow(creationComptePane, Priority.ALWAYS);
		scene.setRoot(mainPane);
	}
	
	public void chargementTwitup(){
		mainPane.getChildren().clear();
		mainPane.add(menuBar,  0, 0, 2, 1);
		mainPane.add(gauche,  0, 1);
		mainPane.add(droit, 1, 1);
		GridPane.setVgrow(droit, Priority.ALWAYS);
		GridPane.setVgrow(gauche, Priority.ALWAYS);
		scene.setRoot(mainPane);
	}
	
    public static void main(String[] args) {
        Application.launch(TwitupMenuBarMainViewImplFX.class, args);
    }
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addActionSignUp(TwitupWatcher tw) {
		signUpWatcher.addWatcher(tw);
	}
	@Override
	public void delActionSignUp(TwitupWatcher tw) {
		signUpWatcher.delWatcher(tw);
	}
	@Override
	public void addActionLogIn(TwitupWatcher tw) {
		signInWatcher.addWatcher(tw);
	}
	@Override
	public void delActionLogIn(TwitupWatcher tw) {
		signInWatcher.delWatcher(tw);
	}
	@Override
	public void addActionLogOut(TwitupWatcher tw) {
		signOutWatcher.addWatcher(tw);
	}
	@Override
	public void delActionLogOut(TwitupWatcher tw) {
		signOutWatcher.delWatcher(tw);
	}
	@Override
	public void showSignIn(boolean bool) {
		connexItem.setVisible(true);
	}
	@Override
	public void showSignOut(boolean bool) {
		decoItem.setVisible(true);
	}
	@Override
	public void addActionClose(TwitupWatcher tw) {
		closeWatcher.addWatcher(tw);
	}
	@Override
	public void delActionClose(TwitupWatcher tw) {
		closeWatcher.delWatcher(tw);
	}
	@Override
	public void addActionAbout(TwitupWatcher tw) {
		aboutWatcher.addWatcher(tw);
	}
	@Override
	public void delActionAbout(TwitupWatcher tw) {
		aboutWatcher.delWatcher(tw);
	}
	@Override
	public void addActionModifyExchangeFolder(TwitupWatcher tw) {
		modifyExchangeFolderWatcher.addWatcher(tw);		
	}
	@Override
	public void delActionModifyExchangeFolder(TwitupWatcher tw) {
		modifyExchangeFolderWatcher.delWatcher(tw);
	}
	@Override
	public void init(TwitupUserView userView, TwitupTwitView twitView) {
		gauche = (TwitupUserViewImplFX)userView;
		droit = (TwitupTwitViewImplFX)userView;
		
	}
	@Override
	public void initView() {
		// TODO Auto-generated method stub
		
	}

}

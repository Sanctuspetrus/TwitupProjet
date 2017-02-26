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

public class TwitupMenuBarViewImplFX extends Application implements TwitupMenuBarView, TwitupAccountActionView, TwitupMainView {


    MenuBar menuBar = new MenuBar();
    
    Menu menuFile = new Menu("Fichier");
    MenuItem repItem = new MenuItem("Répertoire d'échange");
    MenuItem quitItem = new MenuItem("Quitter");
	GridPane mainPane = new GridPane();
	GridPane twitPane = new GridPane();
	
    Menu menuCompte = new Menu("Compte");
    MenuItem creerItem = new MenuItem("Créer un compte");
    MenuItem connexItem = new MenuItem("Connexion");
    MenuItem decoItem = new MenuItem("Déconnexion");
    
    Menu menuAbout = new Menu("?");
    MenuItem aproposItem = new MenuItem("A Propos");
    
	TwitupLogInViewImplFX connexionPane = new TwitupLogInViewImplFX();
	TwitupSignUpViewImplFX creationComptePane = new TwitupSignUpViewImplFX();
	
	TwitupUserViewImplFX gauche = new TwitupUserViewImplFX();
	TwitupTwitViewImplFX droit = new TwitupTwitViewImplFX();
	
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
				System.out.println("répertoire d'échange");
			}
        });

        quitItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Quitter");
				primaryStage.close();
			}
        });
 
        // --- Menu Edit
        creerItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				chargementCreationCompte();
				System.out.println("créer un compte");
			}
        });

        connexItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Connexion");
				chargementConnexion();
			}
        });

        decoItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Déconnexion");
			}
        });
 
        // --- Menu View
        aproposItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("A Propos");
			}
        });
        
        menuFile.getItems().addAll(repItem, quitItem);
        menuCompte.getItems().addAll(creerItem, connexItem, decoItem);
        menuAbout.getItems().addAll(aproposItem);
        
		menuBar.setPrefWidth(scene.getWidth());
        
        menuBar.getMenus().addAll(menuFile, menuCompte, menuAbout);

        
		
		primaryStage.setTitle("Twitup");

		//ajout d'un event sur le redimensionnement de la fenetre pour que la barre de menu ai une taille similaire à la taille de l'écran 
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
	private void chargementConnexion(){
		mainPane.getChildren().clear();
		mainPane.add(menuBar,  0, 0, 1, 1);
		mainPane.add(connexionPane, 0, 1, 1, 1);
		GridPane.setVgrow(connexionPane, Priority.ALWAYS);
		scene.setRoot(mainPane);
	}
	
	private void chargementCreationCompte(){
		mainPane.getChildren().clear();
		mainPane.add(menuBar,  0, 0, 1, 1);
		mainPane.add(creationComptePane, 0, 1, 1, 1);
		GridPane.setVgrow(creationComptePane, Priority.ALWAYS);
		scene.setRoot(mainPane);
	}
	
	private void chargementTwitup(){
		mainPane.getChildren().clear();
		mainPane.add(menuBar,  0, 0, 2, 1);
		mainPane.add(gauche,  0, 1);
		mainPane.add(droit, 1, 1);
		GridPane.setVgrow(droit, Priority.ALWAYS);
		GridPane.setVgrow(gauche, Priority.ALWAYS);
		scene.setRoot(mainPane);
	}
	
    public static void main(String[] args) {
        Application.launch(TwitupMenuBarViewImplFX.class, args);
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void initView() {
		// TODO Auto-generated method stub
		
	}

}

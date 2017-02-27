package com.iup.tp.twitup.ihm.menubar.view;
import java.util.ArrayList;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.account.AccountActionViewObserver;
import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInViewImplFX;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpViewImplFX;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainView;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitViewImplFX;
import com.iup.tp.twitup.ihm.user.view.TwitupUserView;
import com.iup.tp.twitup.ihm.user.view.TwitupUserViewImplFX;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;

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

public class TwitupMenuBarMainViewImplFX extends GridPane implements TwitupMenuBarView, TwitupAccountActionView, TwitupMainView {

	MenuBar menuBar;

	Menu menuFile;
	MenuItem repItem;
	MenuItem quitItem;
	GridPane mainPane;
	GridPane twitPane;

	Menu menuCompte;
	MenuItem creerItem;
	MenuItem connexItem;
	MenuItem decoItem;

	Menu menuAbout;
	MenuItem aproposItem;

	TwitupLogInViewImplFX connexionPane;
	TwitupSignUpViewImplFX creationComptePane;

	TwitupUserViewImplFX gauche; 
	TwitupTwitViewImplFX droit; 

	protected ArrayList<AccountActionViewObserver> obs = new ArrayList<AccountActionViewObserver>();
	protected ArrayList<MenuBarViewObserver> obsMenuBar = new ArrayList<MenuBarViewObserver>();
	
	public TwitupMenuBarMainViewImplFX(){
		menuBar = new MenuBar();
		menuFile = new Menu("Fichier");
		repItem = new MenuItem("R�pertoire d'�change");
		quitItem = new MenuItem("Quitter");
		mainPane = new GridPane();
		twitPane = new GridPane();

		menuCompte = new Menu("Compte");
		creerItem = new MenuItem("Cr�er un compte");
		connexItem = new MenuItem("Connexion");
		decoItem = new MenuItem("D�connexion");

		menuAbout = new Menu("?");
		aproposItem = new MenuItem("A Propos");

		connexionPane = new TwitupLogInViewImplFX();
		creationComptePane = new TwitupSignUpViewImplFX();

		// --- Menu File
		repItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("r�pertoire d'�change");
				notifyModifyExchangeFolderButton();
			}
		});

		quitItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Quitter");
				//primaryStage.close();
				notifyCloseButton();
			}
		});

		// --- Menu Edit
		creerItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				sendSignUpButton();
				//chargementCreationCompte();
				System.out.println("cr�er un compte");
			}
		});

		connexItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Connexion");
				sendLogInButton();
				//chargementConnexion();
			}
		});

		decoItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("D�connexion");
				sendSignUpButton();
			}
		});

		// --- Menu View
		aproposItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("A Propos");
				notifyAboutButton();
			}
		});

		menuFile.getItems().addAll(repItem, quitItem);
		menuCompte.getItems().addAll(creerItem, connexItem, decoItem);
		menuAbout.getItems().addAll(aproposItem);

		menuBar.setPrefWidth(this.getWidth());

		menuBar.getMenus().addAll(menuFile, menuCompte, menuAbout);





		//ajout d'un event sur le redimensionnement de la fenetre pour que la barre de menu ai une taille similaire � la taille de l'�cran 
		this.widthProperty().addListener(new ChangeListener<Number>() {
			@Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
				menuBar.setPrefWidth(newSceneWidth.doubleValue());
			}
		});
		this.heightProperty().addListener(new ChangeListener<Number>() {
			@Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) {
			}
		});

		mainPane.setHgap(10);

		//chargementTwitup();
		
		
		
	}

	public void chargementConnexion(){
		mainPane.getChildren().clear();
		mainPane.add(menuBar,  0, 0, 1, 1);
		mainPane.add(connexionPane, 0, 1, 1, 1);
		GridPane.setVgrow(connexionPane, Priority.ALWAYS);
	//	scene.setRoot(mainPane);
	}

	public void chargementCreationCompte(){
		mainPane.getChildren().clear();
		mainPane.add(menuBar,  0, 0, 1, 1);
		mainPane.add(creationComptePane, 0, 1, 1, 1);
		GridPane.setVgrow(creationComptePane, Priority.ALWAYS);
	//	scene.setRoot(mainPane);
	}

	public void chargementTwitup(){
		mainPane.getChildren().clear();
		mainPane.add(menuBar,  0, 0, 2, 1);
		mainPane.add(gauche,  0, 1);
		mainPane.add(droit, 1, 1);
		GridPane.setVgrow(droit, Priority.ALWAYS);
		GridPane.setVgrow(gauche, Priority.ALWAYS);
		//scene.setRoot(mainPane);
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
	public void init(TwitupUserView userView, TwitupTwitView twitView) {
		Application.launch();

	}
	@Override
	public void initView() {
		// TODO Auto-generated method stub

	}
	@Override
	public void addAccountActionViewObserver(AccountActionViewObserver aavo) {
		obs.add(aavo);
	}

	@Override
	public void delAccountActionViewObserver(AccountActionViewObserver aavo) {
		obs.remove(aavo);
	}

	@Override
	public void addMenuBarViewObserver(MenuBarViewObserver aavo) {
		obsMenuBar.add(aavo);
	}

	@Override
	public void delMenuBarViewObserver(MenuBarViewObserver aavo) {
		obsMenuBar.remove(aavo);
	}
	@Override
	public void notifyCloseButton() {
		for (MenuBarViewObserver menuObserver : obsMenuBar) {
			menuObserver.actionCloseButton();
		}
	}

	@Override
	public void notifyAboutButton() {
		for (MenuBarViewObserver menuObserver : obsMenuBar) {
			menuObserver.actionAboutButton();
		}
	}

	@Override
	public void notifyModifyExchangeFolderButton() {
		for (MenuBarViewObserver menuObserver : obsMenuBar) {
			menuObserver.actionModifyExchangeFolderButton();
		}
	}
	@Override
	public void sendLogInButton() {
		for (AccountActionViewObserver accountActionViewObserver : obs) {
			accountActionViewObserver.actionLogInButton();
		}
	}

	@Override
	public void sendLogOutButton() {
		for (AccountActionViewObserver accountActionViewObserver : obs) {
			accountActionViewObserver.actionLogOutButton();
		}
	}
	@Override
	public void sendSignUpButton() {
		for (AccountActionViewObserver accountActionViewObserver : obs) {
			accountActionViewObserver.actionSignUpButton();
		}
	}
	@Override
	public void actionLogIn(User u) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionLogOut(User u) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionSignUp(User u) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionShowLogIn() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionShowLogOut() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionShowSignUp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionCloseLogIn() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionCloseLogOut() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionCloseSignUp() {
		// TODO Auto-generated method stub
		
	}
	
	public void setGaucheEtDroit(TwitupUserViewImplFX userView, TwitupTwitViewImplFX twitView){
		gauche = userView;
		droit = twitView;
		chargementTwitup();
	}


}

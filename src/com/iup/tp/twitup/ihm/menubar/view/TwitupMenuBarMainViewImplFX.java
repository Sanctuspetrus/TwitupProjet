package com.iup.tp.twitup.ihm.menubar.view;
import java.util.ArrayList;

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

public class TwitupMenuBarMainViewImplFX extends Application implements TwitupMenuBarView, TwitupAccountActionView, TwitupMainView {

	MenuBar menuBar;

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

	TwitupLogInViewImplFX connexionPane;
	TwitupSignUpViewImplFX creationComptePane;

	TwitupUserViewImplFX gauche; 
	TwitupTwitViewImplFX droit; 

	Scene scene;

	protected ArrayList<AccountActionViewObserver> obs = new ArrayList<AccountActionViewObserver>();
	protected ArrayList<MenuBarViewObserver> obsMenuBar = new ArrayList<MenuBarViewObserver>();



	@Override
	public void start(Stage primaryStage) throws Exception {
		
		menuBar = new MenuBar();
		connexionPane = new TwitupLogInViewImplFX();
		creationComptePane = new TwitupSignUpViewImplFX();
		scene = new Scene(mainPane, 850, 500, Color.LIGHTBLUE);

		primaryStage.setMinWidth(1100);
		primaryStage.setMinHeight(650);

		// --- Menu File
		repItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("répertoire d'échange");
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
				System.out.println("créer un compte");
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
				System.out.println("Déconnexion");
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
		gauche = (TwitupUserViewImplFX)userView;
		droit = (TwitupTwitViewImplFX)userView;

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


}

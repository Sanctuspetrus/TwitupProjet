package com.iup.tp.twitup.ihm.menubar.view;
import com.iup.tp.twitup.ihm.account.view.ConnexionPane;
import com.iup.tp.twitup.ihm.account.view.CreationComptePane;
import com.iup.tp.twitup.ihm.twit.view.TwitPane;
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

public class TwitupMenuBarViewImplFX extends Application{


    MenuBar menuBar = new MenuBar();
	GridPane mainPane = new GridPane();
	GridPane twitPane = new GridPane();
	ConnexionPane connexionPane = new ConnexionPane();
	CreationComptePane creationComptePane = new CreationComptePane();
	
	TwitupUserViewImplFX gauche = new TwitupUserViewImplFX();
	TwitPane droit = new TwitPane();
	
	Scene scene = new Scene(mainPane, 850, 500, Color.LIGHTBLUE);

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setMinWidth(855);
		primaryStage.setMinHeight(500);
        
        // --- Menu File
        Menu menuFile = new Menu("Fichier");
        MenuItem repItem = new MenuItem("Répertoire d'échange");
        repItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("répertoire d'échange");
			}
        });
        MenuItem quitItem = new MenuItem("Quitter");
        quitItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Quitter");
				primaryStage.close();
			}
        });
 
        // --- Menu Edit
        Menu menuCompte = new Menu("Compte");
        MenuItem creerItem = new MenuItem("Créer un compte");
        creerItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				chargementCreationCompte();
				System.out.println("créer un compte");
			}
        });
        MenuItem connexItem = new MenuItem("Connexion");
        connexItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Connexion");
				chargementConnexion();
			}
        });
        MenuItem decoItem = new MenuItem("Déconnexion");
        decoItem.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Déconnexion");
			}
        });
 
        // --- Menu View
        Menu menuAbout = new Menu("?");
        MenuItem aproposItem = new MenuItem("A Propos");
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
		    	//menuBar.setPrefHeight(newSceneHeight.doubleValue());
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

}

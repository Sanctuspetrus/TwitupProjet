package com.iup.tp.twitup;

import com.iup.tp.twitup.core.Twitup;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Classe de lancement de l'application.
 * 
 * @author S.Lucas
 */
public class TwitupLauncher2 extends Application{

	/**
	 * Launcher.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		

		Twitup twitup = new Twitup();
		twitup.show();
	
		// TODO Auto-generated method stub
		
	}

}

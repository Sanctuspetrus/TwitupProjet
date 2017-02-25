package com.iup.tp.twitup.ihm.twit.view;
import com.iup.tp.twitup.ihm.ConstanteJavaFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class TwitPane extends GridPane {
	
	Button rechercher = new Button("RECHERCHER");
	Button twit = new Button("TWIT !!!");
	
	TextField textField = new TextField("rechercher");
	TextArea textArea = new TextArea();
	
	ScrollPane scroll = new ScrollPane();
	
	public TwitPane(){
		this.setAlignment(Pos.TOP_CENTER);
		this.setPadding(new Insets(25, 25, 25, 25));
		this.setHgap(10);
		this.setVgap(10);

		twit.setMaxWidth(Double.MAX_VALUE);

		textArea.setMaxHeight(50);
			
		scroll.setFitToHeight(true);
		GridPane.setVgrow(scroll, Priority.ALWAYS);
		
		this.add(textField, 0, 0);
		this.add(rechercher, 1, 0);
		this.add(scroll, 0, 1, 2,1);
		this.add(textArea, 0, 2, 2, 1);
		this.add(twit, 0, 3, 2, 1);
		this.setStyle(ConstanteJavaFX.COULEURPRINCIPALE);
	}

}

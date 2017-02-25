package com.iup.tp.twitup.ihm.user;
import java.util.ArrayList;
import java.util.List;

import com.iup.tp.twitup.ihm.ConstanteJavaFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class TwitupUserViewImplFX extends GridPane{
	
	Button rechercher = new Button("RECHERCHER");

	TextField textField = new TextField("rechercher");
	
	ScrollPane scroll = new ScrollPane();
	GridPane scrollPane = new GridPane();
	
	List<VignetteAbonnesFX> listVignettes = new ArrayList<VignetteAbonnesFX>();;

	public TwitupUserViewImplFX(){

		this.setAlignment(Pos.TOP_CENTER);
		this.setPadding(new Insets(25, 25, 25, 25));
		this.setHgap(10);
		this.setVgap(10);
		
		scroll.setFitToHeight(true);
		scroll.setContent(scrollPane);
		GridPane.setVgrow(scroll, Priority.ALWAYS);
		
		this.add(textField, 0, 0);
		this.add(rechercher, 1, 0);
		this.add(scroll, 0, 1, 2, 1);
		this.setStyle(ConstanteJavaFX.COULEURPRINCIPALE);
		
		setScrollPane();

	}
	
	private void setScrollPane(){
		
		scrollPane.getChildren().clear();
		listVignettes.clear();
		VignetteAbonnesFX vi1 = new VignetteAbonnesFX("José", "TEMMIE.jpg");
		VignetteAbonnesFX vi2 = new VignetteAbonnesFX("Henry", "TEMMIE.jpg");
		VignetteAbonnesFX vi3 = new VignetteAbonnesFX("José", "TEMMIE.jpg");
		VignetteAbonnesFX vi4 = new VignetteAbonnesFX("Henry", "TEMMIE.jpg");
		VignetteAbonnesFX vi5 = new VignetteAbonnesFX("José", "TEMMIE.jpg");
		VignetteAbonnesFX vi6 = new VignetteAbonnesFX("Henry", "TEMMIE.jpg");
		VignetteAbonnesFX vi7 = new VignetteAbonnesFX("José", "TEMMIE.jpg");
		VignetteAbonnesFX vi8 = new VignetteAbonnesFX("Henry", "TEMMIE.jpg");
		
		listVignettes.add(vi1);
		listVignettes.add(vi2);
		listVignettes.add(vi3);
		listVignettes.add(vi4);
		listVignettes.add(vi5);
		listVignettes.add(vi6);
		listVignettes.add(vi7);
		listVignettes.add(vi8);
		
		for (int i = 0; i < listVignettes.size(); i++){
			
			scrollPane.add(listVignettes.get(i), 0, i);
			scrollPane.setVgap(10);
			scrollPane.setPadding(new Insets(5, 5, 5, 5));
			GridPane.setHgrow(listVignettes.get(i), Priority.ALWAYS);

		}
	}


}

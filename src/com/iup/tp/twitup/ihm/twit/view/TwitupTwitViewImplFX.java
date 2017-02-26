package com.iup.tp.twitup.ihm.twit.view;
import java.util.ArrayList;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.ConstanteJavaFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class TwitupTwitViewImplFX extends GridPane implements TwitupTwitView, IDatabaseObserver {
	
	Button rechercher = new Button("RECHERCHER");
	Button twit = new Button("TWIT !!!");
	
	TextField textField = new TextField("rechercher");
	TextArea textArea = new TextArea();
	
	ScrollPane scroll = new ScrollPane();
	
	protected ArrayList<TwitViewObserver> listObserver; 
	
	public TwitupTwitViewImplFX(){

	}

	@Override
	public void initView() {
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
		
		listObserver = new ArrayList<TwitViewObserver>();
		
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
	public void setDatabase(IDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addObserver(TwitViewObserver tvo) {
		listObserver.add(tvo);
	}

	@Override
	public void delObserver(TwitViewObserver tvo) {
		listObserver.remove(tvo);
	}

	@Override
	public void sendNewTwit(String t) {
		for (TwitViewObserver twitViewObserver : listObserver) {
			twitViewObserver.notifyNewTwit(t);
		}
	}

	@Override
	public void sendRecherche(String str) {
		for (TwitViewObserver twitViewObserver : listObserver) {
			twitViewObserver.notifyRecherche(str);
		}
	}

	@Override
	public String getTwitSent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void notifyTwitAdded(Twit addedTwit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyTwitDeleted(Twit deletedTwit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyTwitModified(Twit modifiedTwit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyUserAdded(User addedUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyUserDeleted(User deletedUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyUserModified(User modifiedUser) {
		// TODO Auto-generated method stub
		
	}

}

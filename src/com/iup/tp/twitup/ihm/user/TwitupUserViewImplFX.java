package com.iup.tp.twitup.ihm.user;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.ConstanteJavaFX;
import com.iup.tp.twitup.ihm.event.TwitupWatchable;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class TwitupUserViewImplFX extends GridPane implements TwitupUserView {
	
	Button rechercher = new Button("RECHERCHER");

	TextField textField = new TextField("rechercher");
	
	ScrollPane scroll = new ScrollPane();
	GridPane scrollPane = new GridPane();
	
	Set<User> listUserAbo;
	Set<User> listUserResearch;
	
	List<VignetteAbonnesFX> listVignettes = new ArrayList<VignetteAbonnesFX>();
	
	TwitupWatchable supprWatchable = new TwitupWatchable();
	TwitupWatchable researchWatchable = new TwitupWatchable();
	TwitupWatchable aboWatchable = new TwitupWatchable();

	public TwitupUserViewImplFX(){}
	
	private void setScrollPane(){

	}

	@Override
	public void initView() {
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

	@Override
	public void show() {
		this.show();
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
	public void addActionResearch(TwitupWatcher tw) {
		researchWatchable.addWatcher(tw);
	}

	@Override
	public void delActionResearch(TwitupWatcher tw) {
		researchWatchable.delWatcher(tw);
	}

	@Override
	public void addActionSuppr(TwitupWatcher tw) {
		supprWatchable.addWatcher(tw);
	}

	@Override
	public void delActionSuppr(TwitupWatcher tw) {
		supprWatchable.delWatcher(tw);
	}

	@Override
	public void addActionAddAbo(TwitupWatcher tw) {
		aboWatchable.addWatcher(tw);
		
	}

	@Override
	public void delActionAddAbo(TwitupWatcher tw) {
		aboWatchable.delWatcher(tw);
	}

	@Override
	public void setListUserAbonnes(Set<User> listUser) {
		listUserAbo = listUser;
		scrollPane.getChildren().clear();
		listUserAbo.clear();
		
		int i = 0;
		for (User user : listUserAbo) {
			VignetteAbonnesFX vignetteTemp = new VignetteAbonnesFX(user.getName(), user.getAvatarPath());
			listVignettes.add(vignetteTemp);
			
			scrollPane.add(listVignettes.get(i), 0, i);
			scrollPane.setVgap(10);
			scrollPane.setPadding(new Insets(5, 5, 5, 5));
			GridPane.setHgrow(listVignettes.get(i), Priority.ALWAYS);
			i++;
		}
	}

	@Override
	public void setListResearched(Set<User> listUser) {
		listUserResearch = listUser;
		scrollPane.getChildren().clear();
		listUserResearch.clear();
		
		int i = 0;
		for (User user : listUserResearch) {
			VignetteAbonnesFX vignetteTemp = new VignetteAbonnesFX(user.getName(), user.getAvatarPath());
			listVignettes.add(vignetteTemp);
			
			scrollPane.add(listVignettes.get(i), 0, i);
			scrollPane.setVgap(10);
			scrollPane.setPadding(new Insets(5, 5, 5, 5));
			GridPane.setHgrow(listVignettes.get(i), Priority.ALWAYS);
			i++;
		}
	}

}
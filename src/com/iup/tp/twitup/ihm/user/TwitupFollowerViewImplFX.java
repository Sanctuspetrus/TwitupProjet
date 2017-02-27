package com.iup.tp.twitup.ihm.user;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.ConstanteJavaFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class TwitupFollowerViewImplFX extends GridPane implements TwitupFollowerView {
	
	Button rechercher;

	TextField textField;
	
	ScrollPane scroll;
	GridPane scrollPane;
	
	Set<User> listUserAbo;
	Set<User> listUserResearch;
	
	List<VignetteAbonnesFX> listVignettes = new ArrayList<VignetteAbonnesFX>();
	
	ArrayList<ListUserViewObserver> obs = new ArrayList<ListUserViewObserver>();

	public TwitupFollowerViewImplFX(){}
	
	private void setScrollPane(){

	}

	@Override
	public void initView() {
		
		rechercher = new Button("RECHERCHER");
		textField = new TextField("rechercher");
		scrollPane = new GridPane();
		
		scroll = new ScrollPane();
		
		rechercher.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				notifySearchUser(rechercher.getText());
			}
		});
		
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
	public void setListUserAbonnes(Set<User> listUser) {
		listUserAbo = listUser;
		scrollPane.getChildren().clear();
		listUserAbo.clear();
		
		int i = 0;
		for (User user : listUserAbo) {
			Button b = new Button();
			b.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event) {
					System.out.println("répertoire d'échange");
					notifyFollowUser(user);
				}
			});
			VignetteAbonnesFX vignetteTemp = new VignetteAbonnesFX(user.getName(), user.getAvatarPath(), b);
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

	@Override
	public void addListUserViewObserver(ListUserViewObserver luvo) {
		obs.add(luvo);
	}

	@Override
	public void delListUserViewObserver(ListUserViewObserver luvo) {
		obs.remove(luvo);
	}

	@Override
	public void notifySearchUser(String str) {
		for (ListUserViewObserver userObser : obs) {
			userObser.actionSearchUser(str);
		}
	}

	@Override
	public void notifySelectUser(User u) {
		for (ListUserViewObserver userObser : obs) {
			userObser.actionSelectUser(u);
		}
	}

	@Override
	public void actionUserChange(User u) {}

	@Override
	public void actionNewFollower(User f) {}

	@Override
	public void actionLostFollower(User f) {}

	@Override
	public void actionFollowUser(User f) {}

	@Override
	public void actionUnfollowUser(User f) {}

	@Override
	public void actionSearchUser(Set<User> searchResult) {}

	@Override
	public void actionProfilChange(User u) {}

}

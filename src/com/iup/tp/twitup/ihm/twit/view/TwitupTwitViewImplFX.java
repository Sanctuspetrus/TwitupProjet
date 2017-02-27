package com.iup.tp.twitup.ihm.twit.view;
import java.util.ArrayList;
import java.util.Set;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.ihm.ConstanteJavaFX;
import com.iup.tp.twitup.ihm.user.VignetteTwitFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

public class TwitupTwitViewImplFX extends GridPane implements TwitupTwitView {

	Button rechercher;
	Button twit;

	TextField textField;
	TextArea textArea;

	ScrollPane scroll;
	GridPane zoneTwit;
	int compteurValue = 150;
	Text compteur;

	Set<Twit> listTwit;
	Set<Twit> listTwitResearch;

	protected ArrayList<TwitViewObserver> listObserver; 

	public TwitupTwitViewImplFX(){}

	@Override
	public void initView() {

		rechercher = new Button("RECHERCHER");
		twit = new Button("TWIT !!!");
		textField = new TextField("rechercher");
		textArea = new TextArea();
		scroll = new ScrollPane();
		zoneTwit = new GridPane();
		compteur = new Text(String.valueOf(150));


		this.setAlignment(Pos.TOP_CENTER);
		this.setPadding(new Insets(25, 25, 25, 25));
		this.setHgap(10);
		this.setVgap(10);

		twit.setMaxWidth(Double.MAX_VALUE);
		twit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(textArea.getText().length() > 0){
					// ENVOIE DU TWIT
					textArea.setText("");
					compteur.setText(String.valueOf(150));
				}
			}
		});

		textArea.setMaxHeight(50);
		textArea.setWrapText(true);

		compteur.minHeight(50);
		compteur.minWidth(200);
		compteur.maxWidth(200);

		textArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {

				if (event.getCode().equals(KeyCode.ENTER))
				{
					event.consume();
					//ENVOI DU TWIT
					textArea.setText("");
				}
			}
		});

		textArea.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (textArea.getText().length() >= 150) {
					event.consume();
				}else{
					compteurValue = 150 - textArea.getText().length();
					compteur.setText(String.valueOf(compteurValue));
				}
			}
		});

		//scroll.setFitToHeight(true);
		scroll.setContent(zoneTwit);


		this.add(textField, 0, 0);
		this.add(rechercher, 1, 0);
		this.add(scroll, 0, 1, 3, 1);
		this.add(textArea, 0, 2, 2, 1);
		this.add(compteur, 2, 2);
		this.add(twit, 0, 3, 3, 1);
		this.setStyle(ConstanteJavaFX.COULEURPRINCIPALE);
		GridPane.setVgrow(scroll, Priority.ALWAYS);
		//setScrollPane();

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
			twitViewObserver.actionNewTwit(t);
		}
	}

	@Override
	public void sendRecherche(String str) {
		for (TwitViewObserver twitViewObserver : listObserver) {
			twitViewObserver.actionRecherche(str);
		}
	}

	@Override
	public String getTwitSent() {
		// TODO Auto-generated method stub
		return null;
	}

	private void reafficherTwit(){
		zoneTwit.getChildren().clear();
		int i = 0;
		for (Twit twit : listTwit) {
			VignetteTwitFX temp = new VignetteTwitFX(twit.getTwiter().getName(), twit.getTwiter().getAvatarPath(), twit.getText());
			zoneTwit.add(temp, 0, i);
			zoneTwit.setVgap(10);
			zoneTwit.setPadding(new Insets(5, 5, 5, 5));
			GridPane.setHgrow(temp, Priority.ALWAYS);
			i++;
		}
	}

	@Override
	public void actionTwitAdded(Set<Twit> twits, Twit twit) {
		listTwit.clear();
		listTwit.addAll(twits);
		reafficherTwit();
	}

	@Override
	public void actionTwitDeleted(Set<Twit> twits, Twit twit) {
		listTwit.clear();
		listTwit.addAll(twits);
		reafficherTwit();
	}

	@Override
	public void actionTwitModified(Set<Twit> twits, Twit twit) {
		listTwit.clear();
		listTwit.addAll(twits);
		reafficherTwit();
	}

	@Override
	public void actionSearchResult(Set<Twit> twits) {
		listTwitResearch.clear();
		listTwitResearch.addAll(twits);
		reafficherTwit();
	}

}

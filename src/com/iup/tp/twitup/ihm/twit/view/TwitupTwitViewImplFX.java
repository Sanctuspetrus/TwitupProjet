package com.iup.tp.twitup.ihm.twit.view;
import java.util.ArrayList;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.ConstanteJavaFX;

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

public class TwitupTwitViewImplFX extends GridPane implements TwitupTwitView, IDatabaseObserver {
	
	Button rechercher = new Button("RECHERCHER");
	Button twit = new Button("TWIT !!!");
	
	TextField textField = new TextField("rechercher");
	TextArea textArea = new TextArea();
	
	ScrollPane scroll = new ScrollPane();
	GridPane scrollPane = new GridPane();
	int compteurValue = 150;
	Text compteur = new Text(String.valueOf(150));
	
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
		scroll.setContent(scrollPane);

		
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

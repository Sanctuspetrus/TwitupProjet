package com.iup.tp.twitup.ihm.account.view;
import com.iup.tp.twitup.ihm.ConstanteJavaFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ConnexionPane extends GridPane {


	final Text actiontarget = new Text();
	Text scenetitle = new Text("Connexion");
	Label userName = new Label("Login :");
	Label pw = new Label("Mot de passe :");
	TextField userTextField = new TextField();
	PasswordField pwBox = new PasswordField();
	Button btn = new Button("Se connecter");
	HBox hbBtn = new HBox(10);
    Rectangle rectangle = new Rectangle();


	public ConnexionPane(){

        rectangle.setX(400);
        rectangle.setY(400);
        rectangle.setWidth(310);
        rectangle.setHeight(155);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        this.add(rectangle, 0, 0, 4, 6);

		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		this.setAlignment(Pos.CENTER);
		this.setStyle(ConstanteJavaFX.COULEURPRINCIPALE);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25, 25, 25, 25));
		this.add(scenetitle, 1, 1, 2, 1);

		userTextField.setPrefWidth(200);
		
		this.add(userName, 1, 2);
		this.add(userTextField, 2, 2);
		this.add(pw, 1, 3);
		this.add(pwBox, 2, 3);

		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(userTextField.getText().isEmpty() || pwBox.getText().isEmpty() ){
					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("Veuillez rentrer tous les champs");
				}else{
					actiontarget.setText("");
				}
			}
		});

		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		this.add(hbBtn, 2, 4);
		this.add(actiontarget, 1, 4, 2, 1);

	}

}

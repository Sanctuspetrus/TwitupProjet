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

public class CreationComptePane extends GridPane {


	final Text actiontarget = new Text();
	Text scenetitle = new Text("S'inscrire");
	Label login = new Label("Login :");
	Label nom = new Label("Nom :");
	Label pw = new Label("Mot de passe :");
	Label pathImage = new Label("Path Image :");
	TextField loginTextField = new TextField();
	TextField nomTextField = new TextField();
	PasswordField pwBox = new PasswordField();
	TextField pathImageTextField = new TextField();
	Button btn = new Button("S'inscrire");
	HBox hbBtn = new HBox(10);
    Rectangle rectangle = new Rectangle();


	public CreationComptePane(){
		
        rectangle.setX(400);
        rectangle.setY(400);
        rectangle.setWidth(310);
        rectangle.setHeight(220);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        this.add(rectangle, 0, 0, 4, 8);

		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		this.setAlignment(Pos.CENTER);
		this.setStyle(ConstanteJavaFX.COULEURPRINCIPALE);
		this.setHgap(10);
		this.setVgap(10);
		this.setPadding(new Insets(25, 25, 25, 25));
		this.add(scenetitle, 1, 1, 2, 1);

		loginTextField.setPrefWidth(200);
		
		this.add(login, 1, 2);
		this.add(loginTextField, 2, 2);
		this.add(nom, 1, 3);
		this.add(nomTextField, 2, 3);
		this.add(pw, 1, 4);
		this.add(pwBox, 2, 4);
		this.add(pathImage, 1, 5);
		this.add(pathImageTextField, 2, 5);


		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(loginTextField.getText().isEmpty() || nomTextField.getText().isEmpty() || pwBox.getText().isEmpty() || pathImageTextField.getText().isEmpty() ){
					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("Veuillez rentrer tous les champs");
				}else{
					actiontarget.setText("");
				}
			}
		});

		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		this.add(hbBtn, 2, 6);
		this.add(actiontarget, 1, 6, 2, 1);

	}

}

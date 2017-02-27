package com.iup.tp.twitup.ihm.user.view;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class VignetteTwitFX extends GridPane {

	ImageView avatar;
	Button abonnement = new Button("abo");
	Label nomLabel;
	Text text;
	Rectangle rectangle = new Rectangle();
	
	public VignetteTwitFX(String nom, String pathImage, String text){
		
		this.text = new Text(text);
		nomLabel = new Label(nom);
		nomLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		avatar = new ImageView(new Image (pathImage));
		avatar.setFitWidth(60);
		avatar.setFitHeight(60);
		avatar.setPreserveRatio(false);
		
        rectangle.setX(400);
        rectangle.setY(400);
        rectangle.setWidth(450);
        rectangle.setHeight(110);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
		
		this.setAlignment(Pos.CENTER);
		this.setHgap(20);
        
		this.add(rectangle, 0, 0, 3, 3);
		this.add(avatar, 1, 1, 1, 2);
		this.add(abonnement, 1, 3);
		this.add(nomLabel, 2, 0);
		this.add(this.text, 2, 1);

		
	}
}

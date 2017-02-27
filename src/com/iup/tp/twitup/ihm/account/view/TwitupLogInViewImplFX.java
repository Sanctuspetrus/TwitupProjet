package com.iup.tp.twitup.ihm.account.view;
import java.util.ArrayList;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.ConstanteJavaFX;
import com.iup.tp.twitup.ihm.account.LogInViewObserver;
import com.iup.tp.twitup.ihm.event.TwitupWatchable;
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

public class TwitupLogInViewImplFX extends GridPane implements TwitupLogInView {


	protected Text actiontarget;
	protected Text scenetitle;
	protected Label userName;
	protected Label pw;
	protected TextField userTextField;
	protected PasswordField pwBox;
	protected Button btn;
	protected HBox hbBtn;
	protected Rectangle rectangle;

	protected ArrayList<LogInViewObserver> obs = new ArrayList<LogInViewObserver>();


	public TwitupLogInViewImplFX(){}


	@Override
	public void initView() {
		actiontarget = new Text();
		scenetitle = new Text("Connexion");
		userName = new Label("Login :");
		pw = new Label("Mot de passe :");
		userTextField = new TextField();
		pwBox = new PasswordField();
		btn = new Button("Se connecter");
		hbBtn = new HBox(10);
		rectangle = new Rectangle();
		
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
					sendLogInAttempt();
				}
			}
		});

		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		this.add(hbBtn, 2, 4);
		this.add(actiontarget, 1, 4, 2, 1);

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
	public void success(String msg) {
		System.out.println(msg);
	}

	@Override
	public void error(String msg) {
		System.out.println(msg);
	}

	@Override
	public String getUsername() {
		return userTextField.getText();
	}

	@Override
	public char[] getLoginPassword() {
		return pwBox.getText().toCharArray();
	}


	@Override
	public void show() {
		this.show();
	}

	@Override
	public void actionLogIn(User u) {}

	@Override
	public void actionLogOut(User u) {}

	@Override
	public void actionSignUp(User u) {}

	@Override
	public void actionShowLogIn() {
		initView();
		show();
	}

	@Override
	public void actionShowLogOut() {}

	@Override
	public void actionShowSignUp() {}

	@Override
	public void addLogInViewObserver(LogInViewObserver livo) {
		obs.add(livo);
	}

	@Override
	public void delLogInViewObserver(LogInViewObserver livo) {
		obs.remove(livo);
	}

	@Override
	public void sendLogInAttempt() {
		for (LogInViewObserver logInViewObserver : obs) {
			logInViewObserver.actionLogInAttempt(userTextField.getText(), pwBox.getText());
		}
	}

	@Override
	public void sendLogInCancel() {}

}

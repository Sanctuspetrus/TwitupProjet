package com.iup.tp.twitup.ihm.account.view;
import java.util.ArrayList;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.ConstanteJavaFX;
import com.iup.tp.twitup.ihm.account.SignUpViewObserver;
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

public class TwitupSignUpViewImplFX extends GridPane implements TwitupSignUpView{

	protected Text actiontarget;
	protected Text scenetitle;
	protected Label login;
	protected Label nom;
	protected Label pw;
	protected Label pathImage;
	protected TextField loginTextField;
	protected TextField nomTextField;
	protected PasswordField pwBox;
	protected TextField pathImageTextField;
	protected Button btn;
	protected HBox hbBtn;
	protected Rectangle rectangle;
	protected ArrayList<SignUpViewObserver> obs = new ArrayList<SignUpViewObserver>();

	public TwitupSignUpViewImplFX(){}

	@Override
	public void initView() {
		
		actiontarget = new Text();
		scenetitle = new Text("S'inscrire");
		login = new Label("Login :");
		nom = new Label("Nom :");
		pw = new Label("Mot de passe :");
		pathImage = new Label("Path Image :");
		loginTextField = new TextField();
		nomTextField = new TextField();
		pwBox = new PasswordField();
		pathImageTextField = new TextField();
		btn = new Button("S'inscrire");
		hbBtn = new HBox(10);
		rectangle = new Rectangle();
		
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
					sendSignUpAttempt();
					actiontarget.setText("");
				}
			}
		});

		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		this.add(hbBtn, 2, 6);
		this.add(actiontarget, 1, 6, 2, 1);

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
	public void error(String msg) {
		System.out.println(msg);
	}


	@Override
	public void success(String msg) {
		System.out.println(msg);
		nomTextField.setText("");
		loginTextField.setText("");
		pwBox.setText("");
		pathImageTextField.setText("");	
	}

	@Override
	public String getUsername() {
		return nomTextField.getText();
	}


	@Override
	public String getUsertag() {
		return loginTextField.getText();
	}


	@Override
	public char[] getSignUpPassword() {
		return loginTextField.getText().toCharArray();
	}

	@Override
	public void actionLogIn(User u) {}


	@Override
	public void actionLogOut(User u) {}


	@Override
	public void actionSignUp(User u) {}


	@Override
	public void actionShowLogIn() {}


	@Override
	public void actionShowLogOut() {}


	@Override
	public void actionShowSignUp() {
		initView();
		show();
	}


	@Override
	public void addSignUpViewObserver(SignUpViewObserver suvo) {
		obs.add(suvo);		
	}


	@Override
	public void delSignUpViewObserver(SignUpViewObserver suvo) {
		obs.remove(suvo);
	}

	@Override
	public void sendSignUpAttempt() {
		for (SignUpViewObserver signUpViewObserver : obs) {
			signUpViewObserver.actionSignUpAttempt(loginTextField.getText(), pwBox.getText(), nomTextField.getText(), pathImageTextField.getText());
		}
	}

	@Override
	public void sendSignUpCancel() {}

	@Override
	public void actionCloseLogIn() {}

	@Override
	public void actionCloseLogOut() {}

	@Override
	public void actionCloseSignUp() {}

}

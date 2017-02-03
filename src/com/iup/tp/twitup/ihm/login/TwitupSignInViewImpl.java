package com.iup.tp.twitup.ihm.login;

import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class TwitupSignInViewImpl implements TwitupSignInView{
	
	protected JFrame frame;
	protected JLabel ident;
	protected JLabel mdp;
	protected JTextField identField;
	protected JPasswordField mdpField;
	
	
	public TwitupSignInViewImpl() {
		frame = new JFrame("Connexion");
		ident = new JLabel("Identifiant : ");
		mdp = new JLabel("Mot de passe : ");
		identField = new JTextField();
		mdpField = new JPasswordField();
	}
	
	@Override
	public void show() {
		
	}

}

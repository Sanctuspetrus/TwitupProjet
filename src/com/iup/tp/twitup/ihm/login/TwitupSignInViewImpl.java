package com.iup.tp.twitup.ihm.login;

import javax.swing.JTextField;

import java.awt.Container;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class TwitupSignInViewImpl implements TwitupSignInView{
	
	protected JPanel panel;
	protected JLabel identLabel;
	protected JLabel pwdLabel;
	protected JTextField identField;
	protected JPasswordField pwdField;
	protected JButton signIn;
	protected JButton cancel;
	
	
	public TwitupSignInViewImpl(JPanel p) {
		panel = p;
		identLabel = new JLabel("Identifiant : ");
		pwdLabel = new JLabel("Mot de passe : ");
		identField = new JTextField();
		pwdField = new JPasswordField();
		signIn = new JButton("Connexion");
		cancel = new JButton("Annuler");
	}
	
	@Override
	public void show() {
//		container.setLayout(new GridBagConstraints());
		JPanel body = new JPanel();
		body.add(identLabel);
		body.add(identField);
		body.add(pwdLabel);
		body.add(pwdField);
		
		JPanel foot = new JPanel();
		foot.add(signIn);
		foot.add(cancel);
		
		panel.add(body);
		panel.add(foot);
}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}

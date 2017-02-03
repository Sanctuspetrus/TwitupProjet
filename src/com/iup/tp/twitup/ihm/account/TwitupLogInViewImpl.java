package com.iup.tp.twitup.ihm.account;

import javax.swing.JTextField;

import com.iup.tp.twitup.ihm.event.TwitupWatcher;

import java.awt.Container;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class TwitupLogInViewImpl implements TwitupLogInView{
	
	protected JPanel panel;
	protected JLabel identLabel;
	protected JLabel pwdLabel;
	protected JTextField identField;
	protected JPasswordField pwdField;
	protected JButton signIn;
	protected JButton cancel;
	
	
	public TwitupLogInViewImpl(JPanel p) {
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

	@Override
	public void success(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addActionLogIn(TwitupWatcher tw) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delActionLogIn(TwitupWatcher tw) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addActionCancel(TwitupWatcher tw) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delActionCancel(TwitupWatcher tw) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}

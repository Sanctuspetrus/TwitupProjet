package com.iup.tp.twitup.ihm.account;

import javax.swing.JTextField;

import com.iup.tp.twitup.ihm.event.TwitupWatchable;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class TwitupLogInViewImpl extends JPanel implements TwitupLogInView{

	protected JLabel identLabel;
	protected JLabel pwdLabel;
	protected JLabel connecLabel;
	protected JLabel subscribeLabel;
	protected JTextField loginSignInField;
	protected JPasswordField pwdSignInField;
	protected JTextField loginSubsField;
	protected JTextField nomSubsField;
	protected JPasswordField pwdSubsField;
	protected JTextField pathAvatar;

	protected JButton signIn;
	protected JButton subscribe;
	
	protected TwitupWatchable signUpWatchable;
	protected TwitupWatchable loginWatchable;
	
	
	public TwitupLogInViewImpl() {
		connecLabel = new JLabel("Se Connecter");
		subscribeLabel = new JLabel("S'inscrire");
		loginSignInField = new JTextField("login");
		pwdSignInField = new JPasswordField();
		loginSubsField = new JTextField("login");
		nomSubsField = new JTextField("nom");
		pwdSubsField = new JPasswordField();
		pathAvatar = new JTextField("path image");
		
		signIn = new JButton("Se Connecter !!!");
		subscribe = new JButton("S'inscrire !!!");
		
	}
	
	@Override
	public void show() {
		

}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addActionLogIn(TwitupWatcher tw) {
		loginWatchable.addWatcher(tw);
	}

	@Override
	public void delActionLogIn(TwitupWatcher tw) {
		loginWatchable.delWatcher(tw);
	}

	@Override
	public void addActionCancel(TwitupWatcher tw) {
		signUpWatchable.addWatcher(tw);
	}

	@Override
	public void delActionCancel(TwitupWatcher tw) {
		signUpWatchable.delWatcher(tw);
	}

	@Override
	public String getUsername() {
		return loginSignInField.getText();
	}

	@Override
	public char[] getPassword() {
		return pwdSignInField.getPassword();
	}

	@Override
	public void init() {
		this.setLayout(new GridLayout(1,1));
		
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		
		leftPanel.setLayout(new GridBagLayout());
		rightPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		//left panel
		c.fill = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		c.insets = new Insets(50,0,0,0);
		leftPanel.add(connecLabel,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		c.insets = new Insets(20,50,0,50);
		leftPanel.add(loginSignInField,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		c.insets = new Insets(20,50,0,50);
		leftPanel.add(pwdSignInField,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.weighty = 2;
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		c.insets = new Insets(20,50,0,50);
		leftPanel.add(signIn,c);
		

		
		// right panel
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		c.insets = new Insets(50,0,0,0);
		rightPanel.add(subscribeLabel, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		c.insets = new Insets(20,50,0,50);
		rightPanel.add(loginSubsField, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		c.insets = new Insets(20,50,0,50);
		rightPanel.add(pwdSubsField, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;
		c.insets = new Insets(20,50,0,50);
		rightPanel.add(nomSubsField, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 2;
		c.insets = new Insets(20,50,0,50);
		rightPanel.add(pwdSubsField,c );
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 2;
		c.insets = new Insets(20,50,0,50);
		rightPanel.add(pathAvatar,c );
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.weighty = 2;
		c.gridx = 2;
		c.gridy = 6;
		c.insets = new Insets(20,50,0,50);
		rightPanel.add(subscribe, c);
		
		this.add(leftPanel);
		this.add(rightPanel);
	}

	@Override
	public void destroy() {
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

}

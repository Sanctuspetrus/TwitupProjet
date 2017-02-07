package com.iup.tp.twitup.ihm.account.view;

import javax.swing.JTextField;

import com.iup.tp.twitup.ihm.event.TwitupWatchable;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class TwitupLogInViewImpl extends JPanel implements TwitupLogInView {

	protected JLabel identLabel;
	protected JLabel pwdLabel;
	protected JLabel connecLabel;
	protected JPasswordField pwdLoginField;
	protected JTextField loginLoginField;

	protected JButton login;

	

	protected TwitupWatchable loginWatchable;
	
	
	public TwitupLogInViewImpl() {
		
		loginWatchable = new TwitupWatchable();
		
		connecLabel = new JLabel("Se Connecter");
		loginLoginField = new JTextField("login");
		pwdLoginField = new JPasswordField();
		
		login = new JButton("Se Connecter !!!");
		
	}


	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void init() {
		

		login.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginWatchable.sendEvent();
			}
		});
		
		this.setLayout(new GridLayout(1,1));
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		c.insets = new Insets(50,0,0,0);
		this.add(connecLabel,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		c.insets = new Insets(20,50,0,50);
		this.add(loginLoginField,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		c.insets = new Insets(20,50,0,50);
		this.add(pwdLoginField,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.weighty = 2;
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		c.insets = new Insets(20,50,0,50);
		this.add(login,c);
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

	@Override
	public void addActionCancel(TwitupWatcher tw) {
		loginWatchable.addWatcher(tw);
	}

	@Override
	public void delActionCancel(TwitupWatcher tw) {
		loginWatchable.delWatcher(tw);
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
	public String getUsername() {
		return loginLoginField.getText();
	}

	@Override
	public char[] getLoginPassword() {
		return pwdLoginField.getPassword();
	}
	


}

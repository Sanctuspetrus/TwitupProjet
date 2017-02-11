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
	
	protected JPanel subPanel;

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
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(50,0,0,0);
		this.add(connecLabel,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(20,50,0,50);
		this.add(loginLoginField,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(20,50,0,50);
		this.add(pwdLoginField,c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		c.insets = new Insets(20,50,0,50);
		this.add(login,c);
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
	
	@Override
	public void show() {
		this.setVisible(true);
	}
	


}

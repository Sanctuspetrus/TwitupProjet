package com.iup.tp.twitup.ihm.account.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.iup.tp.twitup.ihm.event.TwitupWatchable;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

@SuppressWarnings("serial")
public class TwitupSignUpViewImpl extends JPanel implements TwitupSignUpView{
	
	
	
	protected JLabel signUpLabel;
	protected JTextField loginsignUpField;
	protected JTextField nomSignUpField;
	protected JPasswordField pwdSignUpField;
	protected JTextField pathAvatar;
	
	protected JButton signUp;

	protected TwitupWatchable signUpWatchable;
	
	
	public TwitupSignUpViewImpl() {
		
		signUpWatchable = new TwitupWatchable();
		
		signUpLabel = new JLabel("S'inscrire");
		loginsignUpField = new JTextField("login");
		nomSignUpField = new JTextField("nom");
		pwdSignUpField = new JPasswordField();
		pathAvatar = new JTextField("path image");
		
		signUp = new JButton("S'inscrire !!!");

		
	}


	@Override
	public void init() {
		
		signUp.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				signUpWatchable.sendEvent();
			}
		});
		
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.CENTER;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		c.insets = new Insets(50,0,0,0);
		this.add(signUpLabel, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		c.insets = new Insets(20,50,0,50);
		this.add(loginsignUpField, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		c.insets = new Insets(20,50,0,50);
		this.add(pwdSignUpField, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;
		c.insets = new Insets(20,50,0,50);
		this.add(nomSignUpField, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 2;
		c.insets = new Insets(20,50,0,50);
		this.add(pwdSignUpField,c );
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 2;
		c.insets = new Insets(20,50,0,50);
		this.add(pathAvatar,c );
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.weighty = 2;
		c.gridx = 2;
		c.gridy = 6;
		c.insets = new Insets(20,50,0,50);
		this.add(signUp, c);

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
		
		loginsignUpField = new JTextField("login");
		nomSignUpField = new JTextField("nom");
		pwdSignUpField = new JPasswordField();
		pathAvatar = new JTextField("path image");
		
		System.out.println(msg);
	}

	@Override
	public void addActionSignUp(TwitupWatcher tw) {
		signUpWatchable.addWatcher(tw);
		
	}

	@Override
	public void delActionSignUp(TwitupWatcher tw) {
		signUpWatchable.delWatcher(tw);
		
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
		return nomSignUpField.getText();
	}

	@Override
	public String getUsertag() {
		return loginsignUpField.getText();
	}

	@Override
	public char[] getSignUpPassword() {
		return pwdSignUpField.getPassword();
	}
	
	@Override
	public void show() {
		this.setVisible(true);
	}


}

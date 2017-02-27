package com.iup.tp.twitup.ihm.account.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.account.LogInViewObserver;

@SuppressWarnings("serial")
public class TwitupLogInViewImpl extends JPanel implements TwitupLogInView {

	protected JLabel identLabel;
	protected JLabel pwdLabel;
	protected JLabel connecLabel;
	protected JPasswordField pwdLoginField;
	protected JTextField loginLoginField;
	
	protected JPanel subPanel;

	protected JButton login;	
	
	protected ArrayList<LogInViewObserver> obs = new ArrayList<LogInViewObserver>();
	
	public TwitupLogInViewImpl() {
		
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
	public void initView() {
		login.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				sendLogInAttempt();
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
		this.revalidate();
		this.repaint();
	}

	@Override
	public void actionLogIn(User u) {}

	@Override
	public void actionLogOut(User u) {}

	@Override
	public void actionSignUp(User u) {}

	@Override
	public void actionShowLogIn() {
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
			logInViewObserver.actionLogInAttempt(loginLoginField.getText(), String.valueOf(pwdLoginField.getPassword()));
		}
	}

	@Override
	public void sendLogInCancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionCloseLogIn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionCloseLogOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionCloseSignUp() {
		// TODO Auto-generated method stub
		
	}
	


}

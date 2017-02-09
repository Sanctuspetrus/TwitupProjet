package com.iup.tp.twitup.ihm.user;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iup.tp.twitup.datamodel.User;

@SuppressWarnings("serial")
public class VignetteAbonnes extends JPanel{
	
	ImageIcon image;
	String nomUser;
	
	
	JLabel imageLabel;
	JLabel nomUserLabel;
	
	public VignetteAbonnes(User user){
		
		imageLabel.setText(user.getAvatarPath());
		nomUserLabel.setText(nomUserLabel.getName());
		
		
		
	}
	
	
	

}

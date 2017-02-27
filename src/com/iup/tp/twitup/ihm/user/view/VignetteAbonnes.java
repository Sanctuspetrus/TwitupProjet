package com.iup.tp.twitup.ihm.user.view;

import java.awt.Color;
import javax.swing.BorderFactory;
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
		
		imageLabel = new JLabel();
		nomUserLabel = new JLabel();
		
		imageLabel.setText(user.getAvatarPath());
		nomUserLabel.setText(user.getName());
		
		this.add(imageLabel);
		this.add(nomUserLabel);
		
		this.setBackground(Color.white);
		this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		this.setVisible(true);
	}
}

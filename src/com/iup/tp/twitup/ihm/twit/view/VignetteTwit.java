package com.iup.tp.twitup.ihm.twit.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VignetteTwit extends JPanel{
	
	
	
	JLabel text;
	JLabel image;
	ImageIcon avatar;
	
	
	
	public VignetteTwit(String twitText, String avatarPath){
		
		this.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.red));
		this.avatar = new ImageIcon(avatarPath);
		image = new JLabel(avatar);
		text = new JLabel(twitText);
		
		this.add(image);
		this.add(text);


	}
	
	

}

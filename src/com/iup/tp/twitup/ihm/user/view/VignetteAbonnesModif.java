package com.iup.tp.twitup.ihm.user.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.iup.tp.twitup.datamodel.User;

@SuppressWarnings("serial")
public class VignetteAbonnesModif extends JPanel{
	
	VignetteAbonnes vi;
	JButton button;
	User u;
	
	
		
	public VignetteAbonnesModif(VignetteAbonnes vi, JButton button){
		this.vi = vi;
		this.button = button;
		
		this.add(vi);
		this.add(button);
		
	}
	
	
	
	
	
	

}

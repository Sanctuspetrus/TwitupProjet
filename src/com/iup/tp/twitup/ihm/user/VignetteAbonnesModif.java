package com.iup.tp.twitup.ihm.user;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VignetteAbonnesModif extends JPanel{
	
	VignetteAbonnes vi;
	JButton button;
	
	
	public VignetteAbonnesModif(VignetteAbonnes vi, JButton button){
		
		this.vi = vi;
		this.button = button;
		
		this.add(vi);
		this.add(button);
		
	}
	
	
	
	
	
	

}

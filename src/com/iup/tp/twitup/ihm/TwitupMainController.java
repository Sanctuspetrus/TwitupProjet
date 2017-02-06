package com.iup.tp.twitup.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import com.iup.tp.twitup.ihm.mainview.controller.TwitupMainViewController;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarViewImpl;

public class TwitupMainController implements TwitupController{
	
	final ImageIcon logoIUP = new ImageIcon("/TwitUp/src/resources/images/logoIUP_50.jpg");
	
	TwitupMainViewController mainView;
	TwitupMenuBarViewImpl menuBar;
	
	
	
	public TwitupMainController(TwitupMainViewController mainView){
		this.mainView = mainView;
		
	}

	
}

package com.iup.tp.twitup.ihm;

import javax.swing.ImageIcon;
import com.iup.tp.twitup.ihm.mainview.controller.TwitupMainViewController;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarViewImpl;

public class TwitupMainController implements TwitupController{
	
	final ImageIcon logoIUP = new ImageIcon("/TwitUp/src/resources/images/logoIUP_50.jpg");
	
	TwitupMainViewController mainView;
	TwitupMenuBarViewImpl menuBar;
	
	
	
	public TwitupMainController(TwitupMainViewController mainView){
		this.mainView = mainView;
		
	}



	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}

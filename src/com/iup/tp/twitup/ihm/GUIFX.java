package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogOutView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpView;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainView;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarView;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarViewImplFX;
import com.iup.tp.twitup.ihm.twit.controller.TwitupTwitController;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;
import com.iup.tp.twitup.ihm.user.TwitupUserView;
import com.iup.tp.twitup.ihm.user.TwitupUserViewImplFX;

public class GUIFX implements GUI{
	
	/**
	 * Vue principale de l'application.
	 */
	protected static GUISwing singleton;
	
	// MODEL
	protected IDatabase db;
	
	// CTRL
	protected TwitupTwitController twitCtrl;
	
	// VUES
	protected TwitupMainView mainView = new TwitupMainViewImplFX();
	protected TwitupMenuBarView menuBar = new TwitupMenuBarViewImplFX();
	protected TwitupUserView userView = new TwitupUserViewImplFX();
	protected TwitupTwitView twitView = new TwitupTwitViewImplFX();
	protected TwitupLogInView liv = new TwitupUserViewImplFX();
	//protected TwitupLogOutView lov = new TwitupUserViewImplFX();
	protected TwitupSignUpView suv = new TwitupUserViewImplFX();
	
	
	
	
	
	

	@Override
	public void launch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TwitupFrame getFrame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TwitupUserView getTwitupUserView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TwitupTwitView getTwitupTwitView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TwitupLogInView getTwitupLogInView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TwitupSignUpView getTwitupSignupView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TwitupAccountActionView getTwitupAccountActionView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTwitCtrl(TwitupTwitController ttc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDatabase(IDatabase db) {
		// TODO Auto-generated method stub
		
	}

}

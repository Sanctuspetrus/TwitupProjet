package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInViewImpl;
import com.iup.tp.twitup.ihm.account.view.TwitupLogOutView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpView;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;
import com.iup.tp.twitup.ihm.mainview.controller.TwitupMainViewController;
import com.iup.tp.twitup.ihm.mainview.controller.TwitupMainViewControllerImpl;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainView;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainViewImpl;
import com.iup.tp.twitup.ihm.menubar.controller.TwitupMenuBarControllerImpl;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarView;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarViewImpl;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitViewImpl;
import com.iup.tp.twitup.ihm.user.TwitupUserView;
import com.iup.tp.twitup.ihm.user.TwitupUserViewImpl;

public class GUISwing implements GUI {

	/**
	 * Vue principale de l'application.
	 */
	protected static GUISwing singleton;
	protected TwitupFrame mainFrame;
	protected TwitupMainView mMainView;
	TwitupMenuBarView menuBar;
	TwitupUserView userView;
	TwitupTwitView twitView;
	TwitupLogInView liv;
	TwitupLogOutView lov;
	TwitupSignUpView suv;
	TwitupAccountActionView aac;
	
	protected GUISwing() {
		mainFrame = new TwitupFrame();
		mMainView = new TwitupMainViewImpl(mainFrame);
		menuBar = new TwitupMenuBarViewImpl(mainFrame);
		userView = new TwitupUserViewImpl();
		twitView = new TwitupTwitViewImpl();
		liv = new TwitupLogInViewImpl();
		lov = null;
		suv = null;
		aac = (TwitupAccountActionView) menuBar;
	}
	
	public static GUISwing getInstance(){
		if(singleton == null){
			singleton = new GUISwing();
		}
		return singleton;
	}
	
	@Override
	public void launch() {

		// Initialisation des vues
		TwitupUserView userView = new TwitupUserViewImpl();
		TwitupTwitView twitView = new TwitupTwitViewImpl();
		TwitupLogInView liv = new TwitupLogInViewImpl();
		TwitupLogOutView lov = null;
		TwitupSignUpView suv = null;
		TwitupAccountActionView aac = (TwitupAccountActionView) menuBar;
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
	public TwitupFrame getFrame() {
		// TODO Auto-generated method stub
		return null;
	}

}

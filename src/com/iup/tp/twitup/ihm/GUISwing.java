package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.ihm.account.controller.TwitupAccountController;
import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInViewImpl;
import com.iup.tp.twitup.ihm.account.view.TwitupLogOutView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpViewImpl;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainView;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainViewImpl2;
import com.iup.tp.twitup.ihm.menubar.controller.TwitupMenuBarController;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarView;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarViewImpl;
import com.iup.tp.twitup.ihm.twit.controller.TwitupTwitController;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitViewImpl;
import com.iup.tp.twitup.ihm.user.TwitupUserController;
import com.iup.tp.twitup.ihm.user.TwitupUserView;
import com.iup.tp.twitup.ihm.user.TwitupUserViewImpl;

public class GUISwing implements GUI {

	/**
	 * Vue principale de l'application.
	 */
	protected static GUISwing singleton;
	
	// MODEL
	protected IDatabase db;
	
	// CTRL
	protected TwitupMenuBarController menuBarCtrl;
	protected TwitupAccountController accountCtrl;
	protected TwitupUserController userCtrl;
	protected TwitupTwitController twitCtrl;
	
	// VUES
	protected TwitupFrame mainFrame;
	protected TwitupMainView mainView;
	protected TwitupMenuBarView menuBar;
	protected TwitupUserView userView;
	protected TwitupTwitView twitView;
	protected TwitupLogInView liv;
	protected TwitupLogOutView lov;
	protected TwitupSignUpView suv;
	protected TwitupAccountActionView aac;
	
	protected GUISwing() {
		mainFrame = new TwitupFrame();
		mainView = new TwitupMainViewImpl2(mainFrame);
		menuBar = new TwitupMenuBarViewImpl(mainFrame);
		userView = new TwitupUserViewImpl();
		twitView = new TwitupTwitViewImpl();
		liv = new TwitupLogInViewImpl();
		lov = null;
		suv = new TwitupSignUpViewImpl();
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
		
		mainFrame.setSize(1000,500);
		mainFrame.setLocation(700, 100);
		mainView.init(userView, twitView);
		
		mainFrame.setContentPane((TwitupMainViewImpl2)mainView);
		
		liv.addLogInViewObserver(accountCtrl);
		suv.addSignUpViewObserver(accountCtrl);
		aac.addAccountActionViewObserver(accountCtrl);
		
		userView.addListUserViewObserver(userCtrl);
		
		twitView.addObserver(twitCtrl);
		twitView.setDatabase(db);

		liv.initView();
		suv.initView();
		aac.initView();
		userView.initView();
		twitView.initView();
		
		mainView.show();
	}

	@Override
	public TwitupUserView getTwitupUserView() {
		return userView;
	}

	@Override
	public TwitupTwitView getTwitupTwitView() {
		return twitView;
	}

	@Override
	public TwitupLogInView getTwitupLogInView() {
		return liv;
	}

	@Override
	public TwitupSignUpView getTwitupSignupView() {
		return suv;
	}

	@Override
	public TwitupAccountActionView getTwitupAccountActionView() {
		return aac;
	}

	@Override
	public TwitupFrame getFrame() {
		return mainFrame;
	}
	
	@Override
	public void setDatabase(IDatabase db) {
		this.db = db;
	}

	public void setTwitCtrl(TwitupTwitController ttc){
		this.twitCtrl = ttc;
	}

	@Override
	public void setAccountCtrl(TwitupAccountController tac) {
		this.accountCtrl = tac;
	}

	@Override
	public void setMenuBarCtrl(TwitupMenuBarController tmbc) {
		menuBarCtrl = tmbc;
	}

	@Override
	public void setUserCtrl(TwitupUserController tuc) {
		userCtrl = tuc;
	}
}

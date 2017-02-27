package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.ihm.account.controller.TwitupAccountController;
import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInViewImplFX;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpViewImplFX;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainView;
import com.iup.tp.twitup.ihm.menubar.controller.TwitupMenuBarController;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarMainViewImplFX;
import com.iup.tp.twitup.ihm.twit.controller.TwitupTwitController;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitViewImplFX;
import com.iup.tp.twitup.ihm.user.controller.TwitupUserController;
import com.iup.tp.twitup.ihm.user.view.TwitupUserView;
import com.iup.tp.twitup.ihm.user.view.TwitupUserViewImplFX;

import javafx.application.Application;

public class GUIFX implements GUI{
	
	/**
	 * Vue principale de l'application.
	 */
	protected static GUIFX singleton;
	
	// MODEL
	protected IDatabase db;
	
	// CTRL
	protected TwitupTwitController twitCtrl;
	protected TwitupAccountController accountControl;
	protected TwitupMenuBarController menuBarControl;
	protected TwitupUserController userControl;
	
	// VUES
	protected TwitupMainView mainView = new TwitupMenuBarMainViewImplFX();
	protected TwitupUserView userView = new TwitupUserViewImplFX();
	protected TwitupTwitView twitView = new TwitupTwitViewImplFX();
	protected TwitupLogInView liv = new TwitupLogInViewImplFX();
	protected TwitupSignUpView suv = new TwitupSignUpViewImplFX();
	
	protected TwitupAccountActionView aac;
	
	protected GUIFX(){
		aac = (TwitupAccountActionView) mainView;
	}
	
	public static GUIFX getInstance(){
		if(singleton == null){
			singleton = new GUIFX();
		}
		return singleton;
	}
	
	@Override
	public void launch() {

		liv.addLogInViewObserver(accountControl);
		suv.addSignUpViewObserver(accountControl);
		aac.addAccountActionViewObserver(accountControl);
		userView.addListUserViewObserver(userControl);
		
		twitView.addObserver(twitCtrl);
		twitView.setDatabase(db);
		

		twitView.initView();
		userView.initView();
		liv.initView();
		suv.initView();
		Application.launch(TwitupMenuBarMainViewImplFX.class);
		mainView.init(userView, twitView);
		mainView.show();
		
	}

	@Override
	public TwitupFrame getFrame() {
		// TODO Auto-generated method stub
		return null;
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
	public void setTwitCtrl(TwitupTwitController ttc) {
		this.twitCtrl = ttc;
	}

	@Override
	public void setDatabase(IDatabase db) {
		this.db = db;
	}

	@Override
	public void setAccountCtrl(TwitupAccountController tac) {
		this.accountControl = tac;
	}

	@Override
	public void setMenuBarCtrl(TwitupMenuBarController tmbc) {
		this.menuBarControl = tmbc;
	}

	@Override
	public void setUserCtrl(TwitupUserController tuc) {
		this.userControl = tuc;
	}

}

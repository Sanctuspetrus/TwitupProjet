package com.iup.tp.twitup.ihm;

import java.awt.Container;
import java.util.ArrayList;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.account.controller.AccountObserver;
import com.iup.tp.twitup.ihm.account.controller.TwitupAccountController;
import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInViewImpl;
import com.iup.tp.twitup.ihm.account.view.TwitupLogOutView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpViewImpl;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainView;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainViewImpl2;
import com.iup.tp.twitup.ihm.menubar.controller.MenuBarObserver;
import com.iup.tp.twitup.ihm.menubar.controller.TwitupMenuBarController;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarView;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarViewImpl;
import com.iup.tp.twitup.ihm.twit.controller.TwitupTwitController;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitViewImpl;
import com.iup.tp.twitup.ihm.user.TwitupUserController;
import com.iup.tp.twitup.ihm.user.TwitupUserView;
import com.iup.tp.twitup.ihm.user.TwitupUserViewImpl;

public class GUISwing implements GUI, AccountObserver {

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
		aac = menuBar;
	}
	
	public static GUISwing getInstance(){
		if(singleton == null){
			singleton = new GUISwing();
		}
		return singleton;
	}
	
	@Override
	public void launch() {
		
		mainFrame.setSize(500,300);
		mainFrame.setLocation(0, 0);
		mainView.init(userView, twitView);
		
		mainFrame.setContentPane((TwitupMainViewImpl2)mainView);
		
		menuBar.addMenuBarViewObserver(menuBarCtrl);
		menuBarCtrl.addMenuBarObserver(new MenuBarObserver() {
			
			@Override
			public void actionExchangeFolder() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void actionClose() {
				 System.exit(0);
			}
		});
				
		liv.addLogInViewObserver(accountCtrl);
		suv.addSignUpViewObserver(accountCtrl);
		aac.addAccountActionViewObserver(accountCtrl);
		accountCtrl.addAccountObserver(liv);
		accountCtrl.addAccountObserver(suv);
		
		userView.addListUserViewObserver(userCtrl);
		userCtrl.addUserObserver(userView);
		
		twitView.addObserver(twitCtrl);
		twitView.setDatabase(db);

		
		
		menuBar.initView();
		liv.initView();
		suv.initView();
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
		this.accountCtrl.addAccountObserver(this);
	}

	@Override
	public void setMenuBarCtrl(TwitupMenuBarController tmbc) {
		menuBarCtrl = tmbc;
	}

	@Override
	public void setUserCtrl(TwitupUserController tuc) {
		userCtrl = tuc;
	}

	@Override
	public void actionLogIn(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionLogOut(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionSignUp(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionShowLogIn() {
		System.out.println("Log In");
		mainFrame.setContentPane((Container)liv);
		liv.show();
	}

	@Override
	public void actionShowLogOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionShowSignUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionCloseLogIn() {
		mainFrame.setContentPane((TwitupMainViewImpl2)mainView);
		mainView.show();
	}

	@Override
	public void actionCloseLogOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionCloseSignUp() {
		// TODO Auto-generated method stub
		
	}
}

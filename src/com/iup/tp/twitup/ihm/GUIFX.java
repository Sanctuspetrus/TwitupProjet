package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.ihm.account.controller.TwitupAccountController;
import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInViewImplFX;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpViewImplFX;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainView;
import com.iup.tp.twitup.ihm.menubar.controller.MenuBarObserver;
import com.iup.tp.twitup.ihm.menubar.controller.TwitupMenuBarController;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarMainViewImplFX;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarViewImpl;
import com.iup.tp.twitup.ihm.twit.controller.TwitupTwitController;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitViewImplFX;
import com.iup.tp.twitup.ihm.user.controller.TwitupUserController;
import com.iup.tp.twitup.ihm.user.view.TwitupUserView;
import com.iup.tp.twitup.ihm.user.view.TwitupUserViewImplFX;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIFX extends Application implements GUI{
	
	/**
	 * Vue principale de l'application.
	 */
	protected static GUIFX singleton;
	
	// MODEL
	protected IDatabase db;
	
	// CTRL
	protected TwitupTwitController twitCtrl;
	protected TwitupAccountController accountCtrl;
	protected TwitupMenuBarController menuBarCtrl;
	protected TwitupUserController userCtrl;
	
	// VUES
	protected TwitupMainView mainView;
	protected TwitupUserView userView;
	protected TwitupTwitView twitView;
	protected TwitupLogInView liv;
	protected TwitupSignUpView suv;
	
	protected TwitupAccountActionView aac;
	
	protected Scene scene;
	
	public GUIFX(){}
	
	public static GUIFX getInstance(){
		if(singleton == null){
			singleton = new GUIFX();
		}
		return singleton;
	}
	
	@Override
	public void launch() {
		Application.launch();
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
		this.accountCtrl = tac;
	}

	@Override
	public void setMenuBarCtrl(TwitupMenuBarController tmbc) {
		this.menuBarCtrl = tmbc;
	}

	@Override
	public void setUserCtrl(TwitupUserController tuc) {
		this.userCtrl = tuc;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		mainView = new TwitupMenuBarMainViewImplFX();
		aac = (TwitupAccountActionView) mainView;
		userView = new TwitupUserViewImplFX();
		twitView = new TwitupTwitViewImplFX();
		liv = new TwitupLogInViewImplFX();
		suv = new TwitupSignUpViewImplFX();
		
		scene = new Scene((Parent) mainView, 850, 500, Color.LIGHTBLUE);
		
		primaryStage.setMinWidth(1100);
		primaryStage.setMinHeight(650);
		primaryStage.setTitle("Twitup");
		
		
		
		((TwitupMenuBarMainViewImplFX) mainView).addMenuBarViewObserver(menuBarCtrl);
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
		userCtrl.addListUserObserver(userView);
		
		twitView.addObserver(twitCtrl);
		twitCtrl.addTwitObserver(twitView);

		mainView.init(userView, twitView);
		((TwitupMenuBarMainViewImplFX)mainView).chargementTwitup();

		//Application.launch((TwitupMenuBarMainViewImplFX)mainView);
		mainView.initView();
		liv.initView();
		suv.initView();
		userView.initView();
		twitView.initView();
		
		mainView.show();
		primaryStage.setScene(scene);
		scene.setRoot((Parent) mainView);
		primaryStage.show();
		
		
	}

}

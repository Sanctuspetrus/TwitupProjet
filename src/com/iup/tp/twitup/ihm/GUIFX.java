package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInViewImplFX;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpViewImplFX;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainView;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarMainViewImplFX;
import com.iup.tp.twitup.ihm.twit.controller.TwitupTwitController;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitViewImplFX;
import com.iup.tp.twitup.ihm.user.TwitupUserView;
import com.iup.tp.twitup.ihm.user.TwitupUserViewImplFX;

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
	
	// VUES
	protected TwitupMainView mainView = new TwitupMenuBarMainViewImplFX();
	protected TwitupUserView userView = new TwitupUserViewImplFX();
	protected TwitupTwitView twitView = new TwitupTwitViewImplFX();
	protected TwitupLogInView liv = new TwitupLogInViewImplFX();
	protected TwitupSignUpView suv = new TwitupSignUpViewImplFX();
	protected TwitupUserViewImplFX gauche = new TwitupUserViewImplFX();
	protected TwitupTwitViewImplFX droit = new TwitupTwitViewImplFX();
	
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
		Application.launch(TwitupMenuBarMainViewImplFX.class);
		
		aac.addActionSignUp(new TwitupWatcher() {
			@Override
			public void action(Object o) {
				System.out.println("Cr�ation compte");
				((TwitupMenuBarMainViewImplFX)mainView).chargementCreationCompte();
				mainView.show();
			}
		});
		aac.addActionLogIn(new TwitupWatcher() {
			@Override
			public void action(Object o) {
				System.out.println("Connexion");
				((TwitupMenuBarMainViewImplFX)mainView).chargementConnexion();
				mainView.show();
			}
		});
		
		/*suv.addActionSignUp(new TwitupWatcher() {
			@Override
			public void action(Object o) {
				//mainFrame.setContentPane((TwitupUserViewImpl)userView);
				mainView.setContentPane((TwitupMainViewImpl2)mainView);
				mainView.show();
			}
		});
		liv.addActionLogIn(new TwitupWatcher() {
			@Override
			public void action(Object o) {
				//mainFrame.setContentPane((TwitupUserViewImpl)userView);
				mainView.setContentPane((TwitupMainViewImpl2)mainView);
				mainView.show();
			}
		});*/
		
		twitView.addObserver(twitCtrl);
		twitView.setDatabase(db);
		twitView.initView();
		
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

}

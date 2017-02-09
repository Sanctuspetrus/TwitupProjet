package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInViewImpl;
import com.iup.tp.twitup.ihm.account.view.TwitupLogOutView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpViewImpl;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainView;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainViewImpl;
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
		mainView = new TwitupMainViewImpl(mainFrame);
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
		mainFrame.setContentPane((TwitupUserViewImpl)userView);
		aac.addActionSignUp(new TwitupWatcher() {
			@Override
			public void action(Object o) {
				System.out.println("Création compte");
				mainFrame.setContentPane((TwitupSignUpViewImpl)suv);
				mainView.show();
			}
		});
		aac.addActionLogIn(new TwitupWatcher() {
			@Override
			public void action(Object o) {
				System.out.println("Connexion");
				mainFrame.setContentPane((TwitupLogInViewImpl)liv);
				mainView.show();
			}
		});
		
		suv.addActionSignUp(new TwitupWatcher() {
			@Override
			public void action(Object o) {
				mainFrame.setContentPane((TwitupUserViewImpl)userView);
			}
		});
		liv.addActionLogIn(new TwitupWatcher() {
			@Override
			public void action(Object o) {
				mainFrame.setContentPane((TwitupUserViewImpl)userView);
			}
		});
		
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

}

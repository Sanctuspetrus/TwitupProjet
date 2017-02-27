package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.ihm.account.controller.TwitupAccountController;
import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpView;
import com.iup.tp.twitup.ihm.menubar.controller.TwitupMenuBarController;
import com.iup.tp.twitup.ihm.twit.controller.TwitupTwitController;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;
import com.iup.tp.twitup.ihm.user.TwitupUserController;
import com.iup.tp.twitup.ihm.user.TwitupUserView;

public interface GUI {
	void launch();
	TwitupFrame getFrame();
	TwitupUserView getTwitupUserView();
	TwitupTwitView getTwitupTwitView();
	TwitupLogInView getTwitupLogInView();
	TwitupSignUpView getTwitupSignupView();
	TwitupAccountActionView getTwitupAccountActionView();
	
	// CTRL
	void setMenuBarCtrl(TwitupMenuBarController tmbc);
	void setAccountCtrl(TwitupAccountController tac);
	void setUserCtrl(TwitupUserController tuc);
	void setTwitCtrl(TwitupTwitController ttc);

	void setDatabase(IDatabase db);
}

package com.iup.tp.twitup.ihm;

import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpView;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;
import com.iup.tp.twitup.ihm.user.TwitupUserView;

public interface GUI {
	void launch();
	TwitupFrame getFrame();
	TwitupUserView getTwitupUserView();
	TwitupTwitView getTwitupTwitView();
	TwitupLogInView getTwitupLogInView();
	TwitupSignUpView getTwitupSignupView();
	TwitupAccountActionView getTwitupAccountActionView();
}

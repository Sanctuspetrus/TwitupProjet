package com.iup.tp.twitup.ihm.account.view;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.account.TwitupError;
import com.iup.tp.twitup.ihm.account.TwitupSuccess;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupSignUpView extends TwitupView, TwitupError, TwitupSuccess {

	void addActionSignUp(TwitupWatcher tw);
	void delActionSignUp(TwitupWatcher tw);
	
	void addActionCancel(TwitupWatcher tw);
	void delActionCancel(TwitupWatcher tw);

	String getUsername();
	String getUsertag();
	String getPassword();
}

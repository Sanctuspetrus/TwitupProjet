package com.iup.tp.twitup.ihm.account;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupSignUpView extends TwitupView {

	void addActionSignUp(TwitupWatcher tw);
	void delActionSignUp(TwitupWatcher tw);
	
	void addActionCancel(TwitupWatcher tw);
	void delActionCancel(TwitupWatcher tw);

	String getUsername();
	String getPassword();
}

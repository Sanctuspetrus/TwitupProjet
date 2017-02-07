package com.iup.tp.twitup.ihm.account;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupLogInView extends TwitupView, TwitupSuccess, TwitupError{

	// Bouton connection
	void addActionLogIn(TwitupWatcher tw);
	void delActionLogIn(TwitupWatcher tw);

	// Bouton connection
	void addActionCancel(TwitupWatcher tw);
	void delActionCancel(TwitupWatcher tw);

	String getUsername();

	char[] getLoginPassword();
	
}

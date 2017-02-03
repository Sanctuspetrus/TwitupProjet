package com.iup.tp.twitup.ihm.account;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupLogInView extends TwitupView {

	// Bouton connection
	void addActionConnection(TwitupWatcher tw);
	void delActionConnection(TwitupWatcher tw);

	String getTag();

	String getPassword();
	
}

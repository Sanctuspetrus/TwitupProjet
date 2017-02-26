package com.iup.tp.twitup.ihm.account.view;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.account.LogInViewObserver;
import com.iup.tp.twitup.ihm.account.TwitupError;
import com.iup.tp.twitup.ihm.account.TwitupSuccess;
import com.iup.tp.twitup.ihm.account.controller.AccountObserver;

public interface TwitupLogInView extends TwitupView, AccountObserver, TwitupSuccess, TwitupError{
	
	void addLogInViewObserver(LogInViewObserver livo);
	void delLogInViewObserver(LogInViewObserver livo);
	
	// Bouton connexion
	void sendLogInAttempt();
	// Bouton Annuler
	void sendLogInCancel();

	String getUsername();

	char[] getLoginPassword();
	
}

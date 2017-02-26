package com.iup.tp.twitup.ihm.account.view;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.account.LogInViewObserver;
import com.iup.tp.twitup.ihm.account.SignUpViewObserver;
import com.iup.tp.twitup.ihm.account.TwitupError;
import com.iup.tp.twitup.ihm.account.TwitupSuccess;
import com.iup.tp.twitup.ihm.account.controller.AccountObserver;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupSignUpView extends TwitupView, AccountObserver, TwitupError, TwitupSuccess {

	void addSignUpViewObserver(SignUpViewObserver suvo);
	void delSignUpViewObserver(SignUpViewObserver suvo);
	
	// Bouton créer compte
	void sendSignUpAttempt();
	// Bouton Annuler
	void sendSignUpCancel();

	String getUsername();
	String getUsertag();
	char[] getSignUpPassword();
}

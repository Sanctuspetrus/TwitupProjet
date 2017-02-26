package com.iup.tp.twitup.ihm.account.view;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.account.LogInViewObserver;
import com.iup.tp.twitup.ihm.account.controller.AccountObserver;

public interface TwitupLogOutView extends TwitupView, AccountObserver {

	void addLogOutViewObserver(LogInViewObserver livo);
	void delLogOutViewObserver(LogInViewObserver livo);
	
	// Bouton connexion
	void sendLogOutAttempt();
	// Bouton Annuler
	void sendLogOutCancel();
	
}

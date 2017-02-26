package com.iup.tp.twitup.ihm.account.view;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.account.LogInViewObserver;
import com.iup.tp.twitup.ihm.account.LogOutViewObserver;
import com.iup.tp.twitup.ihm.account.controller.AccountObserver;

public interface TwitupLogOutView extends TwitupView, AccountObserver {

	void addLogOutViewObserver(LogOutViewObserver lovo);
	void delLogOutViewObserver(LogOutViewObserver lovo);
	
	// Bouton connexion
	void sendLogOutAttempt();
	// Bouton Annuler
	void sendLogOutCancel();
	
}

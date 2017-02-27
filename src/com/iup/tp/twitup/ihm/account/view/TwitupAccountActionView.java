package com.iup.tp.twitup.ihm.account.view;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.account.AccountActionViewObserver;
import com.iup.tp.twitup.ihm.account.controller.AccountObserver;

public interface TwitupAccountActionView extends TwitupView, AccountObserver {
	
	void addAccountActionViewObserver(AccountActionViewObserver aavo);
	void delAccountActionViewObserver(AccountActionViewObserver aavo);
	
	// Bouton connexion
	void sendLogInButton();
	// Bouton déconnexon
	void sendLogOutButton();
	// Bouton création compte
	void sendSignUpButton();
	
	
	
	
}

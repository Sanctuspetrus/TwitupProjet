package com.iup.tp.twitup.ihm.account.view;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.account.AccountActionViewObserver;

public interface TwitupAccountActionView extends TwitupView{
	
	void addAccountActionViewObserver(AccountActionViewObserver aavo);
	void delAccountActionViewObserver(AccountActionViewObserver aavo);
	
	// Bouton connexion
	void sendLogInButton();
	// Bouton déconnexon
	void sendLogOutButton();
	// Bouton création compte
	void sendSignUpButton();
	
	
	
	
}

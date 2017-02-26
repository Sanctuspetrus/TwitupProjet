package com.iup.tp.twitup.ihm.account.view;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.account.AccountActionViewObserver;

public interface TwitupAccountActionView extends TwitupView{
	
	void addAccountActionViewObserver(AccountActionViewObserver aavo);
	void delAccountActionViewObserver(AccountActionViewObserver aavo);
	
	// Bouton connexion
	void sendLogInButton();
	// Bouton d�connexon
	void sendLogOutButton();
	// Bouton cr�ation compte
	void sendSignUpButton();
	
	
	
	
}

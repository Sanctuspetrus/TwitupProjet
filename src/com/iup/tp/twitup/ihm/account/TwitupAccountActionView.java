package com.iup.tp.twitup.ihm.account;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupAccountActionView extends TwitupView{
	
	// Bouton Cr�er un compte
	public void addActionSignUp(TwitupWatcher tw);
	public void delActionSignUp(TwitupWatcher tw);
	
	// Bouton Connexion
	public void addActionLogIn(TwitupWatcher tw);
	public void delActionLogIn(TwitupWatcher tw);
	public void showSignIn(boolean bool);
	
	// Bouton D�connexion
	public void addActionLogOut(TwitupWatcher tw);
	public void delActionLogOut(TwitupWatcher tw);
	public void showSignOut(boolean bool);
	
}

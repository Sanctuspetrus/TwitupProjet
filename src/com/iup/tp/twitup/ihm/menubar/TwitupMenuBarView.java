package com.iup.tp.twitup.ihm.menubar;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupMenuBarView extends TwitupView{
	// Bouton fermer
	public void addActionClose(TwitupWatcher tw);
	public void delActionClose(TwitupWatcher tw);
	
	// Bouton A propos
	public void addActionAbout(TwitupWatcher tw);
	public void delActionAbout(TwitupWatcher tw);
	
	// Bouton Modifier le dossier d'Ã©change
	public void addActionModifyExchangeFolder(TwitupWatcher tw);
	public void delActionModifyExchangeFolder(TwitupWatcher tw);
	
	// Bouton Créer un compte
	public void addActionSignUp(TwitupWatcher tw);
	public void delActionSignUp(TwitupWatcher tw);
	
	// Bouton Connexion
	public void addActionSignIn(TwitupWatcher tw);
	public void delActionSignIn(TwitupWatcher tw);
	
	// Bouton Déconnexion
	public void addActionSignOut(TwitupWatcher tw);
	public void delActionSignOut(TwitupWatcher tw);
}

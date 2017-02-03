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
	
	// Bouton Modifier le dossier d'échange
	public void addActionModifyExchangeFolder(TwitupWatcher tw);
	public void delActionModifyExchangeFolder(TwitupWatcher tw);
	
}

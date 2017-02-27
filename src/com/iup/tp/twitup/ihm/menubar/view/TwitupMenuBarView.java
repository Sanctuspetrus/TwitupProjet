package com.iup.tp.twitup.ihm.menubar.view;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.account.AccountActionViewObserver;
import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupMenuBarView extends TwitupView, TwitupAccountActionView{
	
	void addMenuBarViewObserver(MenuBarViewObserver aavo);
	void delMenuBarViewObserver(MenuBarViewObserver aavo);
	
	// Bouton fermer
	void notifyCloseButton();
	// Bouton A propos
	void notifyAboutButton();
	// Bouton Modifier le dossier d'échange
	void notifyModifyExchangeFolderButton();
	
}

package com.iup.tp.twitup.ihm.menubar.controller;

import com.iup.tp.twitup.ihm.TwitupController;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;
import com.iup.tp.twitup.ihm.menubar.view.MenuBarViewObserver;

public interface TwitupMenuBarController extends TwitupController, MenuBarViewObserver{
	
	public void addMenuBarObserver(MenuBarObserver mbo);
	public void delMenuBarObserver(MenuBarObserver mbo);
	
	void notifyExchangeFolder();
	void notifyClose();
	
}

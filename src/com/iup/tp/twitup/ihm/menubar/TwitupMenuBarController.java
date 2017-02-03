package com.iup.tp.twitup.ihm.menubar;

import com.iup.tp.twitup.ihm.TwitupController;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupMenuBarController extends TwitupController{
	
	public void addActionExchangeFolder(TwitupWatcher tw);
	public void delActionExchangeFolder(TwitupWatcher tw);
	
}

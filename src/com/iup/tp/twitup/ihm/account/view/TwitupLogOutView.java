package com.iup.tp.twitup.ihm.account.view;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.account.controller.AccountObserver;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupLogOutView extends TwitupView, AccountObserver {

	void addActionLogOut(TwitupWatcher tw);
	void delActionLogOut(TwitupWatcher tw);
	
	void addActionCancel(TwitupWatcher tw);
	void delActionCancel(TwitupWatcher tw);
	
}

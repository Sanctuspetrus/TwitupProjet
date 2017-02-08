package com.iup.tp.twitup.ihm.account.controller;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitupController;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupAccountController extends TwitupController {
	
	void addAccountObserver(AccountObserver ao);
	void delAccountObserver(AccountObserver ao);
	void notifyLogIn(User u);
	void notifyLogOut(User u);
}

package com.iup.tp.twitup.ihm.account;

import com.iup.tp.twitup.ihm.TwitupController;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupAccountController extends TwitupController {
	void addActionLogIn(TwitupWatcher tw);
	void delActionLogIn(TwitupWatcher tw);
	
	void addActionLogOut(TwitupWatcher tw);
	void delActionLogOut(TwitupWatcher tw);
}

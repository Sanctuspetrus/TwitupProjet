package com.iup.tp.twitup.ihm.account;

import com.iup.tp.twitup.ihm.TwitupController;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupAccountController extends TwitupController {
	void addActionUser(TwitupWatcher tw);
	void delActionUser(TwitupWatcher tw);
}

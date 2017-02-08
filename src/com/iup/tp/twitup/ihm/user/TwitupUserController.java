package com.iup.tp.twitup.ihm.user;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.account.controller.AccountObserver;

public interface TwitupUserController extends AccountObserver, TwitupView {
	void addUserObserver(UserObserver uo);
	void delUserObserver(UserObserver uo);
	void notifyUserChange(User u);
}

package com.iup.tp.twitup.ihm.account.controller;

import com.iup.tp.twitup.datamodel.User;

public interface AccountObserver {
	void actionLogIn(User u);

	void actionLogOut(User u);
}

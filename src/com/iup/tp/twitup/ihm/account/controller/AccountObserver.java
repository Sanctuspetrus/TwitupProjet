package com.iup.tp.twitup.ihm.account.controller;

import com.iup.tp.twitup.datamodel.User;

public interface AccountObserver {
	void notifyLogIn(User u);

	void notifyLogOut(User u);
	
	void notifySignUp(User u);
	
	void notifyShowLogIn();
	void notifyShowLogOut();
	void notifyShowSignUp();
}

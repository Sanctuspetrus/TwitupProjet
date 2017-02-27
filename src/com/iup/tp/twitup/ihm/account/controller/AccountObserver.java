package com.iup.tp.twitup.ihm.account.controller;

import com.iup.tp.twitup.datamodel.User;

public interface AccountObserver {
	void actionLogIn(User u);
	void actionLogOut(User u);
	void actionSignUp(User u);
	
	void actionShowLogIn();
	void actionShowLogOut();
	void actionShowSignUp();
	
	void actionCloseLogIn();
	void actionCloseLogOut();
	void actionCloseSignUp();
}

package com.iup.tp.twitup.ihm.account.controller;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitupController;
import com.iup.tp.twitup.ihm.account.AccountActionViewObserver;
import com.iup.tp.twitup.ihm.account.LogInViewObserver;
import com.iup.tp.twitup.ihm.account.LogOutViewObserver;
import com.iup.tp.twitup.ihm.account.SignUpViewObserver;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupAccountController extends TwitupController, LogInViewObserver, LogOutViewObserver, SignUpViewObserver, AccountActionViewObserver {
	
	void addAccountObserver(AccountObserver ao);
	void delAccountObserver(AccountObserver ao);
	void sendLogIn(User u);
	void sendLogOut(User u);
	void sendSignUp(User u);
}

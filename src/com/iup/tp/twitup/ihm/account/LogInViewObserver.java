package com.iup.tp.twitup.ihm.account;

public interface LogInViewObserver {
	void actionLogInAttempt(String tag, char[] pwd);
	void actionLogInCancel();
}

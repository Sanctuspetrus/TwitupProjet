package com.iup.tp.twitup.ihm.account;

public interface SignUpViewObserver {
	void actionSignUpAttempt(String tag, String pwd, String name, String img);
	void actionSignUpCancel();
}

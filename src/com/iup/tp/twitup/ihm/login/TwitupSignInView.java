package com.iup.tp.twitup.ihm.login;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupSignInView extends TwitupView {

	void addActionConnection();

	void showSuccess();

	void showError();

	void addActionLoginAttempt(TwitupWatcher loginAttempt);

	String getTag();

	String getPassword();

}

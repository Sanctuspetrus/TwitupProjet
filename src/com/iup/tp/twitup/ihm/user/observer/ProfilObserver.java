package com.iup.tp.twitup.ihm.user.observer;

import com.iup.tp.twitup.datamodel.User;

public interface ProfilObserver {
	void actionUserChange(User u);
	void actionProfilChange(User u);
}

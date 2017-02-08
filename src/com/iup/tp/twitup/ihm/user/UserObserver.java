package com.iup.tp.twitup.ihm.user;

import com.iup.tp.twitup.datamodel.User;

public interface UserObserver {
	void actionUserChange(User u);
}

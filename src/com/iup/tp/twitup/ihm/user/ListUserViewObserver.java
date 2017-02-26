package com.iup.tp.twitup.ihm.user;

import com.iup.tp.twitup.datamodel.User;

public interface ListUserViewObserver {
	public void actionSearchUser(String str);
	public void actionSelectUser(User u);
}

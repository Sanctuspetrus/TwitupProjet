package com.iup.tp.twitup.ihm.user.observer;

import java.util.Set;

import com.iup.tp.twitup.datamodel.User;

public interface ListUserObserver {
	void actionFollowUser(User f);
	void actionSearchUser(Set<User> searchResult);
}

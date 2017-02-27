package com.iup.tp.twitup.ihm.user;

import java.util.Set;

import com.iup.tp.twitup.datamodel.User;

public interface UserObserver {
	void actionUserChange(User u);
	void actionNewFollower(User f);
	void actionLostFollower(User f);
	void actionFollowUser(User f);
	void actionUnfollowUser(User f);
	void actionSearchUser(Set<User> searchResult);
	void actionProfilChange(User u);
}

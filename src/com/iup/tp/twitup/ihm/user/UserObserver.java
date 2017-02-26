package com.iup.tp.twitup.ihm.user;

import com.iup.tp.twitup.datamodel.User;

public interface UserObserver {
	void actionUserChange(User u);
	void actionNewFollower(User f);
	void actionLostFollower(User f);
	void actionFollowUser(User f);
	void actionUnfollowUser(User f);
}

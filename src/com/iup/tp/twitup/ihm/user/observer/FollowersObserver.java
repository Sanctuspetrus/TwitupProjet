package com.iup.tp.twitup.ihm.user.observer;

import com.iup.tp.twitup.datamodel.User;

public interface FollowersObserver {
	void actionNewFollower(User f);
	void actionLostFollower(User f);
	void actionUnfollowUser(User f);
}

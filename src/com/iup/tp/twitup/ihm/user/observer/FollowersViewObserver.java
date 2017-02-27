package com.iup.tp.twitup.ihm.user.observer;

import com.iup.tp.twitup.datamodel.User;

public interface FollowersViewObserver {
	public void actionFollowUser(User u);
	public void actionUnfollowUser(User u);
}

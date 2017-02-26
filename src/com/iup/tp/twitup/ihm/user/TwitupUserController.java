package com.iup.tp.twitup.ihm.user;

import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.account.controller.AccountObserver;

public interface TwitupUserController extends AccountObserver, IDatabaseObserver {
	void addUserObserver(UserObserver uo);
	void delUserObserver(UserObserver uo);
	void notifyUserChange(User u);
	void notifyNewFollower(User u);
	void notifyLostFollower(User u);
	void notifyFollowUser(User u);
	void notifyUnfollowUser(User u);
}

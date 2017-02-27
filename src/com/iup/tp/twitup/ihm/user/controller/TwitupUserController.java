package com.iup.tp.twitup.ihm.user.controller;

import java.util.Set;

import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.account.controller.AccountObserver;
import com.iup.tp.twitup.ihm.user.observer.FollowersObserver;
import com.iup.tp.twitup.ihm.user.observer.FollowersViewObserver;
import com.iup.tp.twitup.ihm.user.observer.ListUserViewObserver;
import com.iup.tp.twitup.ihm.user.observer.ProfilObserver;
import com.iup.tp.twitup.ihm.user.observer.ProfilUserViewObserver;
import com.iup.tp.twitup.ihm.user.observer.ListUserObserver;

public interface TwitupUserController extends AccountObserver, IDatabaseObserver,  ProfilUserViewObserver, ListUserViewObserver, FollowersViewObserver{
	void addProfilObserver(ProfilObserver po);
	void delProfilObserver(ProfilObserver po);
	void addListUserObserver(ListUserObserver uo);
	void delListUserObserver(ListUserObserver uo);
	void addFollowersObserver(FollowersObserver fo);
	void delFollowersObserver(FollowersObserver fo);
	
	void notifyUserChange(User u);
	void notifyProfilChange(User u);
	void notifyNewFollower(User u);
	void notifyLostFollower(User u);
	void notifyFollowUser(User u);
	void notifyUnfollowUser(User u);
	void notifySearchResult(Set<User> users);
}

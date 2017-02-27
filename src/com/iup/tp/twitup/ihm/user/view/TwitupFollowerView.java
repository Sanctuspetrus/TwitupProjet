package com.iup.tp.twitup.ihm.user.view;

import java.util.Set;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.user.observer.FollowersObserver;
import com.iup.tp.twitup.ihm.user.observer.FollowersViewObserver;

public interface TwitupFollowerView extends TwitupView, FollowersObserver {
	
	public void addFollowersViewOberserver(FollowersViewObserver luvo);
	public void delFollowersViewOberserver(FollowersViewObserver luvo);
	
	void notifySearchFollower(String str);
	void notifyUnfollowFollower(User u);
	void notifySelectFollower(User u);
	void notifyFollowFollower(User u);
	 
	public void setListFollowerAbonnes(Set<User> listUser);
	public void setListFollowerResearched(Set<User> listUser);

}

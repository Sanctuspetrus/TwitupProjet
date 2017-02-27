package com.iup.tp.twitup.ihm.user.view;

import java.util.Set;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.user.observer.ListUserViewObserver;
import com.iup.tp.twitup.ihm.user.observer.ListUserObserver;

public interface TwitupUserView extends TwitupView, ListUserObserver {
	
	public void addListUserViewObserver(ListUserViewObserver luvo);
	public void delListUserViewObserver(ListUserViewObserver luvo);
	
	void notifySearchUser(String str);
	void notifySelectUser(User u);
	void notifyFollowUser(User u);
	 
	public void setListUserAbonnes(Set<User> listUser);
	public void setListResearched(Set<User> listUser);
}

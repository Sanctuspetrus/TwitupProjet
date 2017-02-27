package com.iup.tp.twitup.ihm.user;

import java.util.Set;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitupView;

public interface TwitupUserView extends TwitupView, UserObserver {
	
	public void addListUserViewObserver(ListUserViewObserver luvo);
	public void delListUserViewObserver(ListUserViewObserver luvo);
	
	void notifySearchUser(String str);
	void notifySelectUser(User u);
	void notifyFollowUser(User u);
	 
	public void setListUserAbonnes(Set<User> listUser);
	public void setListResearched(Set<User> listUser);
}

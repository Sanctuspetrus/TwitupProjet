package com.iup.tp.twitup.ihm.user;

import java.util.Set;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupUserView extends TwitupView {
	
	void addActionResearch(TwitupWatcher tw);
	void delActionResearch(TwitupWatcher tw);
	
	void addActionSuppr(TwitupWatcher tw);
	void delActionSuppr(TwitupWatcher tw);
	
	void addActionAddAbo(TwitupWatcher tw);
	void delActionAddAbo(TwitupWatcher tw);
	
	public void setListUserAbonnes(Set<User> listUser);
	public void setListResearched(Set<User> listUser);
	void showUserAbonnes();
	void showUserResearched();
}

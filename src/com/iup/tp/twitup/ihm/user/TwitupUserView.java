package com.iup.tp.twitup.ihm.user;

import java.util.Set;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.TwitupView;

public interface TwitupUserView extends TwitupView {
	public void setListUser(Set<User> listUser);
}

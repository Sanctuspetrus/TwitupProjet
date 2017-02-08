package com.iup.tp.twitup.ihm.user;

import java.util.Set;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.ihm.TwitupView;

public interface TwitupUserView extends TwitupView {
	public void setListTwit(Set<Twit> listTwit);
}

package com.iup.tp.twitup.ihm.twit.controller;

import java.util.Set;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.ihm.TwitupController;
import com.iup.tp.twitup.ihm.twit.view.TwitViewObserver;
import com.iup.tp.twitup.ihm.user.UserObserver;

public interface TwitupTwitController extends TwitupController, UserObserver, TwitViewObserver{
	void notifySearchResult(Set<Twit> twits);
}

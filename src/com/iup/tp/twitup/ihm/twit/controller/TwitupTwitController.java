package com.iup.tp.twitup.ihm.twit.controller;

import java.util.Set;

import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.ihm.TwitupController;
import com.iup.tp.twitup.ihm.twit.view.TwitViewObserver;
import com.iup.tp.twitup.ihm.user.UserObserver;

public interface TwitupTwitController extends TwitupController, UserObserver, TwitViewObserver, IDatabaseObserver{
	void notifySearchResult(Set<Twit> twits);
	void notifyTwitAdded(Set<Twit> twits, Twit twit);
	void notifyTwitDeleted(Set<Twit> twits, Twit twit);
	void notifyTwitModified(Set<Twit> twits, Twit twit);
}

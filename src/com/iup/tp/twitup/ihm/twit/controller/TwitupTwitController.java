package com.iup.tp.twitup.ihm.twit.controller;

import java.util.Set;

import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.ihm.TwitupController;
import com.iup.tp.twitup.ihm.twit.TwitObserver;
import com.iup.tp.twitup.ihm.twit.view.TwitViewObserver;
import com.iup.tp.twitup.ihm.user.observer.ListUserObserver;
import com.iup.tp.twitup.ihm.user.observer.ProfilObserver;

public interface TwitupTwitController extends TwitupController, ProfilObserver, TwitViewObserver, IDatabaseObserver{
	public void addTwitObserver(TwitObserver to);
	public void delTwitObserver(TwitObserver to);
	
	void notifySearchResult(Set<Twit> twits);
	void notifyStartTwit(Set<Twit> twits);
	void notifyNewTwit(Set<Twit> twits, Twit twit);
	void notifyRemoveTwit(Set<Twit> twits, Twit twit);
	void notifyModifyTwit(Set<Twit> twits, Twit twit);
}

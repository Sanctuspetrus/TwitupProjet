package com.iup.tp.twitup.ihm.twit.view;

import com.iup.tp.twitup.datamodel.Twit;

public interface TwitViewObserver {
	void notifyNewTwit(String t);
	void notifyRecherche(String r);
}

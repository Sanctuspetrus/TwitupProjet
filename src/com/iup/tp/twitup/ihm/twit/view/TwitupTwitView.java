package com.iup.tp.twitup.ihm.twit.view;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupTwitView extends TwitupView{
	void setDatabase(IDatabase db);
	
	void addObserver(TwitViewObserver tvo);
	void delObserver(TwitViewObserver tvo);
	void sendNewTwit(String t);
	void sendRecherche(String str);
	
	String getTwitSent();
}

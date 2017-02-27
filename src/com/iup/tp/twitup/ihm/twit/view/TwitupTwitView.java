package com.iup.tp.twitup.ihm.twit.view;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.twit.TwitObserver;

public interface TwitupTwitView extends TwitupView, TwitObserver{
	
	void addObserver(TwitViewObserver tvo);
	void delObserver(TwitViewObserver tvo);
	void sendNewTwit(String t);
	void sendRecherche(String str);
	
	String getTwitSent();
}

package com.iup.tp.twitup.ihm.twit.view;

import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupTwitView extends TwitupView{
	void addActionNewTwit(TwitupWatcher tw);
	void delActionNewTwit(TwitupWatcher tw);
	void addActionResearchTwit(TwitupWatcher tw);
	void delActionResearchTwit(TwitupWatcher tw);
	
	String getTwitSent();
}

package com.iup.tp.twitup.ihm.message.view;

import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public interface TwitupMessageView {
	void addActionNewTwit(TwitupWatcher tw);
	void delActionNewTwit(TwitupWatcher tw);
	
	String getLastTwit();
}

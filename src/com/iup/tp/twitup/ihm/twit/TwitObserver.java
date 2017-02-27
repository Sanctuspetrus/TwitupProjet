package com.iup.tp.twitup.ihm.twit;

import java.util.Set;

import com.iup.tp.twitup.datamodel.Twit;

public interface TwitObserver {
	public void actionSearchResult(Set<Twit> twits);
}

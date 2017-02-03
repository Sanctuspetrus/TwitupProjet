package com.iup.tp.twitup.ihm.event;

import java.util.ArrayList;

public class TwitupWatchable{
	public ArrayList<TwitupWatcher> watcherList;
	
	public TwitupWatchable(){
		watcherList = new ArrayList<TwitupWatcher>();
	}
	
	public void addWatcher(TwitupWatcher w){
		watcherList.add(w);
	}
	
	public void delWatcher(TwitupWatcher w){
		watcherList.remove(w);
	}
	
	public void sendEvent(Object o){
		for (TwitupWatcher watcher : watcherList) {
			watcher.action(o);
		}
	}
	
	public void sendEvent(){
		sendEvent(null);
	}
}

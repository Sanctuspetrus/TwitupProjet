package com.iup.tp.twitup.ihm.twit.controller;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;

public class TwitupTwitControllerImpl implements TwitupTwitController{
	
	protected IDatabase database;
	protected User user;
	protected TwitupTwitView msgView;
	
	TwitupTwitControllerImpl(IDatabase db, User u, TwitupTwitView mv){
		database = db;
		user = u;
		msgView = mv;
	}

	@Override
	public void init() {
		msgView.addActionNewTwit(newMsg());
		msgView.init();
	}

	@Override
	public void destroy() {
	}
	
	protected TwitupWatcher newMsg(){
		return new TwitupWatcher() {
			@Override
			public void action(Object o) {
				database.addTwit(new Twit(user, msgView.getTwitSent()));
			}
		};
	}
	

}

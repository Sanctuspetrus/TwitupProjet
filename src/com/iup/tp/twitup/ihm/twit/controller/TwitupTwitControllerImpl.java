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

	public TwitupTwitControllerImpl(IDatabase db, TwitupTwitView mv){
		database = db;
		user = null;
		msgView = mv;
	}

	@Override
	public void init() {
		msgView.addActionNewTwit(newMsg());
		msgView.setDatabase(database);
		msgView.init();
	}

	@Override
	public void destroy() {
	}

	protected TwitupWatcher newMsg(){
		return new TwitupWatcher() {
			@Override
			public void action(Object o) {
				if(user != null){
					database.addTwit(new Twit(user, msgView.getTwitSent()));
				}
			}
		};
	}

	@Override
	public void actionUserChange(User u) {
		this.user = u;
	}

}

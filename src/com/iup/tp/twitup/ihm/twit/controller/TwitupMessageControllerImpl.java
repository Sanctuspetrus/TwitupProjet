package com.iup.tp.twitup.ihm.twit.controller;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;
import com.iup.tp.twitup.ihm.twit.view.TwitupMessageView;

public class TwitupMessageControllerImpl implements TwitupMessageController{
	
	protected IDatabase database;
	protected User user;
	protected TwitupMessageView msgView;
	
	TwitupMessageControllerImpl(IDatabase db, User u, TwitupMessageView mv){
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
		// TODO Auto-generated method stub
		
	}
	
	protected TwitupWatcher newMsg(){
		return new TwitupWatcher() {
			@Override
			public void action(Object o) {
				database.addTwit(new Twit(user, msgView.getLastTwit()));
			}
		};
	}
	

}

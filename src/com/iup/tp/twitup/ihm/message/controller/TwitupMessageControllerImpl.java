package com.iup.tp.twitup.ihm.message.controller;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;
import com.iup.tp.twitup.ihm.message.view.TwitupMessageView;

public class TwitupMessageControllerImpl implements TwitupMessageController{
	
	protected IDatabase database;
	protected TwitupMessageView msgView;
	
	TwitupMessageControllerImpl(IDatabase db, TwitupMessageView mv){
		database = db;
		msgView = mv;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	protected TwitupWatcher newMsg(){
		return new TwitupWatcher() {
			@Override
			public void action(Object o) {
				
			}
		};
	}
	

}

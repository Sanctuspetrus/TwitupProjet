package com.iup.tp.twitup.ihm.login;

import com.iup.tp.twitup.datamodel.Database;

public class TwitupLoginControllerImpl implements TwitupLoginController {
	
	protected Database db;
	protected TwitupLoginView loginView;
	
	public TwitupLoginControllerImpl(Database db, TwitupLoginView lv){
		this.db = db;
		this.loginView = lv;
	}
	
	
	
}

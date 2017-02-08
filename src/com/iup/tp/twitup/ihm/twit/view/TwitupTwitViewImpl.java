package com.iup.tp.twitup.ihm.twit.view;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public class TwitupTwitViewImpl implements TwitupTwitView, IDatabaseObserver{

	IDatabase database;
	
	public TwitupTwitViewImpl(IDatabase db){
		database = db;
		database.addObserver(this);
	}

	@Override
	public void init() {
		
	}

	@Override
	public void show() {
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addActionNewTwit(TwitupWatcher tw) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delActionNewTwit(TwitupWatcher tw) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLastTwit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void notifyTwitAdded(Twit addedTwit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyTwitDeleted(Twit deletedTwit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyTwitModified(Twit modifiedTwit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyUserAdded(User addedUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyUserDeleted(User deletedUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyUserModified(User modifiedUser) {
		// TODO Auto-generated method stub
		
	}
	
}

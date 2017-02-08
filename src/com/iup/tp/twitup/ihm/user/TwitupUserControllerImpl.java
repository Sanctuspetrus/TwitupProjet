package com.iup.tp.twitup.ihm.user;

import java.util.ArrayList;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;

public class TwitupUserControllerImpl implements TwitupUserController{
	
	protected User currentUser;
	protected ArrayList<UserObserver> uolist;
	protected IDatabase database;
	protected TwitupUserView userView;
	
	public TwitupUserControllerImpl(IDatabase database, TwitupUserView uv) {
		this.userView = uv;
		this.database = database;
		this.currentUser = null;
		this.uolist = new ArrayList<UserObserver>();
	}

	@Override
	public void actionLogIn(User u) {
		currentUser = u;
	}

	@Override
	public void actionLogOut(User u) {
		currentUser = null;
	}

	@Override
	public void init() {
		userView.init();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
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
	public void addUserObserver(UserObserver uo) {
		uolist.add(uo);
	}

	@Override
	public void delUserObserver(UserObserver uo) {
		uolist.remove(uo);
	}

	@Override
	public void notifyUserChange(User u) {
		for (UserObserver uo : uolist) {
			uo.actionUserChange(u);
		}
	}


	public User getCurrentUser() {
		return currentUser;
	}


	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
		notifyUserChange(currentUser);
	}


}

package com.iup.tp.twitup.ihm.account;

import java.util.Iterator;
import java.util.Set;

import com.iup.tp.twitup.datamodel.Database;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public class TwitupAccountControllerImpl implements TwitupAccountController {

	protected Database database;
	protected TwitupLogInView logInView;
	protected TwitupLogOutView logOutView;
	protected TwitupSignUpView signUpView;
	protected TwitupAccountActionView actionView;

	public TwitupAccountControllerImpl(Database db, TwitupAccountActionView aav, TwitupLogInView liv, TwitupLogOutView lov, TwitupSignUpView suv){
		database = db;
		logInView = liv;
		logOutView = lov;
		signUpView = suv;
		actionView = aav;
	}

	public void initView(){
		logInView.addActionLogIn(loginAttempt());
		loginView.show();
	}


	//v�rifie si l'utilisateur existe
	//return l'User trouv�, null sinon
	public User connection(String userTag, String password){

		Set<User> users = database.getUsers();	
		Iterator<User> i = users.iterator();
		while(i.hasNext()){

			//si le pseudo et mdp correspondent � un user, return du User
			if(((i.next().getUserTag().equals(userTag)) && (i.next()).getUserPassword().equals(password))){
				return i.next();
			}
		}
		return null;		
	}

	public TwitupWatcher loginAttempt(){

		return new TwitupWatcher() {
			@Override
			public void action(Object o) {
				if(connection(loginView.getUsername(), loginView.getPassword()) == null){
					loginView.error("La tentative a �chou�");
				}else{
					loginView.success("Connect�");
				}
				
			}
		};
	}

	@Override
	public void addActionLogIn(TwitupWatcher tw) {
		
	}

	@Override
	public void delActionLogIn(TwitupWatcher tw) {
		
	}

	@Override
	public void addActionLogOut(TwitupWatcher tw) {
		
	}

	@Override
	public void delActionLogOut(TwitupWatcher tw) {
		
	}

}

package com.iup.tp.twitup.ihm.account;

import java.util.Iterator;
import java.util.Set;

import com.iup.tp.twitup.datamodel.Database;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public class TwitupAccountControllerImpl implements TwitupAccountController {

	protected Database db;
	protected TwitupLogInView loginView;

	public TwitupAccountControllerImpl(Database db, TwitupLogInView lv){
		this.db = db;
		this.loginView = lv;
	}

	public void initView(){
		loginView.addActionLoginAttempt(loginAttempt());
		loginView.show();
	}


	//vérifie si l'utilisateur existe
	//return l'User trouvé, null sinon
	public User connection(String userTag, String password){

		Set<User> users = db.getUsers();	
		Iterator<User> i = users.iterator();
		while(i.hasNext()){

			//si le pseudo et mdp correspondent à un user, return du User
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
				if(connection(loginView.getTag(), loginView.getPassword()) == null){
					loginView.showError();
				}else{
					loginView.showSuccess();
				}
				
			}
		};
	}

}

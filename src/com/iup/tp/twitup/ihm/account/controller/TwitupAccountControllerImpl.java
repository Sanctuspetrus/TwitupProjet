package com.iup.tp.twitup.ihm.account.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogOutView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpView;
import com.iup.tp.twitup.ihm.event.TwitupWatchable;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public class TwitupAccountControllerImpl implements TwitupAccountController {

	protected User user;
	protected IDatabase database;
	protected TwitupLogInView logInView;
	protected TwitupLogOutView logOutView;
	protected TwitupSignUpView signUpView;
	protected TwitupAccountActionView actionView;
	protected ArrayList<AccountObserver> aolist; 

 	public TwitupAccountControllerImpl(IDatabase db, TwitupAccountActionView aav, TwitupLogInView liv, TwitupLogOutView lov, TwitupSignUpView suv){
		database = db;
		logInView = liv;
		logOutView = lov;
		signUpView = suv;
		actionView = aav;
		aolist = new ArrayList<AccountObserver>();
	}

	public User findUserByTag(String tag){
		for (User user : database.getUsers()) {
			if(user.getUserTag().equals(tag));
				return user;
		}
		return null;
	}
	
	//vérifie si l'utilisateur existe
	//return l'User trouvé, null sinon
	protected User connection(String userTag, char[] cs){
		User user = this.findUserByTag(userTag);	
		
		if(user != null){
			if(user.getUserPassword().equals(new String(cs))){
				return user;
			}
		}
		return null;		
	}

	/**
	 * Action effectuée lorsque l'utilisateur tente de se connecter
	 * @return TwitupWatcher un observateur sur l'évennement de connection
	 */
	protected TwitupWatcher logInAttempt(){
		return new TwitupWatcher() {
			@Override
			public void action(Object o) {
				User attempt = connection(logInView.getUsername(), logInView.getLoginPassword());
				if(attempt == null){
					StringBuilder msg = new StringBuilder();
					msg.append("L'utilisateur ");
					msg.append(logInView.getUsername());
					msg.append(" n'est pas reconnu");
					logInView.error(msg.toString());
				}else{
					setUser(attempt);
					StringBuilder msg = new StringBuilder();
					msg.append("Connecté en tant que ");
					msg.append(attempt.getName());
					msg.append(", bravo!");
					logInView.success(msg.toString());
				}
			}
		};
	}
	/**
	 * Action effectuée lorsque l'utilisateur tente de se déconnecter
	 * @return TwitupWatcher un observateur sur l'évennement de déconnection
	 */
	protected TwitupWatcher logOutAttempt(){
		return new TwitupWatcher() {
			@Override
			public void action(Object o) {
				setUser(null);
			}
		};
	}
	/**
	 * Action effectuée lorsque l'utilisateur tente de créer un nouveau compte
	 * @return TwitupWatcher un observateur sur l'évennement de création d'un compte
	 */
	protected TwitupWatcher signUpAttempt(){
		return new TwitupWatcher() {
			@Override
			public void action(Object o) {
				String userTag = signUpView.getUsertag();
				String userPassword = String.valueOf(signUpView.getSignUpPassword());
				String name = signUpView.getUsername();
				String image = "";
				
				if(findUserByTag(userTag) == null){
					User newuser = new User(UUID.randomUUID(), userTag, userPassword, name, null, image);
					database.addUser(newuser);
					setUser(newuser); // nécessaire pour notifier les observateurs

					StringBuilder msg = new StringBuilder();
					msg.append("Le compte ");
					msg.append(newuser.getName());
					msg.append(" a été créé : ");
					msg.append("\nNom : "+newuser.getName());
					msg.append("\nTag : "+newuser.getUserTag());
					msg.append("\nMot de passe : "+newuser.getUserPassword());
					msg.append("\nAvatar : "+newuser.getAvatarPath());
					signUpView.success(msg.toString());
				} else {
					signUpView.error("La tentative a échoué, le compte éxiste déjà");					
				}
			}
		};
	}

	@Override
	public void init() {
		actionView.init();
		// Action 
		actionView.addActionLogIn(new TwitupWatcher() {
			@Override
			public void action(Object o) {
				logInView.show();
			}
		});
		actionView.addActionLogOut(new TwitupWatcher() {
			@Override
			public void action(Object o) {
				logOutView.show();
			}
		});
		actionView.addActionSignUp(new TwitupWatcher() {
			@Override
			public void action(Object o) {
				signUpView.show();
			}
		});
		
		logInView.init();
		logInView.addActionLogIn(logInAttempt());
		if(logOutView != null){
			logOutView.init();
			logOutView.addActionLogOut(logOutAttempt());
		}
		signUpView.addActionSignUp(signUpAttempt());
		signUpView.init();
	}

	@Override
	public void destroy() {
		logInView.destroy();
		logOutView.destroy();
		signUpView.destroy();
		actionView.destroy();
	}

	public IDatabase getDatabase() {
		return database;
	}

	public void setDatabase(IDatabase database) {
		this.database = database;
	}

	public TwitupLogInView getLogInView() {
		return logInView;
	}

	public void setLogInView(TwitupLogInView logInView) {
		this.logInView = logInView;
	}

	public TwitupLogOutView getLogOutView() {
		return logOutView;
	}

	public void setLogOutView(TwitupLogOutView logOutView) {
		this.logOutView = logOutView;
	}

	public TwitupSignUpView getSignUpView() {
		return signUpView;
	}

	public void setSignUpView(TwitupSignUpView signUpView) {
		this.signUpView = signUpView;
	}

	public TwitupAccountActionView getActionView() {
		return actionView;
	}

	public void setActionView(TwitupAccountActionView actionView) {
		this.actionView = actionView;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		// Inutile de modifier et notifier tout le monde si user est exactement le même
		if(this.user == null || !this.user.equals(user)){
			this.user = user;
			notifyLogIn(user);
		}
	}

	// OBSERVER USER
	@Override
	public void addAccountObserver(AccountObserver ao) {
		aolist.add(ao);
	}

	@Override
	public void delAccountObserver(AccountObserver ao) {
		aolist.remove(ao);
	}

	@Override
	public void notifyLogIn(User u) {
		for (AccountObserver ao : aolist) {
			ao.actionLogIn(u);
		}
	}

	@Override
	public void notifyLogOut(User u) {
		for (AccountObserver ao : aolist) {
			ao.actionLogOut(u);
		}
	}

	
	
}

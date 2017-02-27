package com.iup.tp.twitup.ihm.account.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.account.AccountActionViewObserver;
import com.iup.tp.twitup.ihm.account.LogInViewObserver;
import com.iup.tp.twitup.ihm.account.LogOutViewObserver;
import com.iup.tp.twitup.ihm.account.SignUpViewObserver;
import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogInView;
import com.iup.tp.twitup.ihm.account.view.TwitupLogOutView;
import com.iup.tp.twitup.ihm.account.view.TwitupSignUpView;
import com.iup.tp.twitup.ihm.event.TwitupWatchable;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public class TwitupAccountControllerImpl implements TwitupAccountController{

	protected User user;
	protected IDatabase database;
	protected EntityManager entityManager;
	protected ArrayList<AccountObserver> aolist; 

	public TwitupAccountControllerImpl(EntityManager em, IDatabase db){
		database = db;
		entityManager = em;
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
	protected User connection(String userTag, String pwd){
		User user = this.findUserByTag(userTag);	

		if(user != null){
			if(user.getUserPassword().equals(pwd)){
				return user;
			}
		}
		return null;		
	}

	public IDatabase getDatabase() {
		return database;
	}

	public void setDatabase(IDatabase database) {
		this.database = database;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		// Inutile de modifier et notifier tout le monde si user est exactement le même
		if(user == null){
			this.user = user;
			sendLogOut(user);
			return;
		}
		if(this.user == null || !this.user.equals(user)){
			this.user = user;
			sendLogIn(user);
			return;
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
	public void sendLogIn(User u) {
		for (AccountObserver ao : aolist) {
			ao.actionLogIn(u);
			ao.actionCloseLogIn();
		}
	}

	@Override
	public void sendLogOut(User u) {
		for (AccountObserver ao : aolist) {
			ao.actionLogOut(u);
			ao.actionCloseLogOut();
		}
	}

	@Override
	public void sendSignUp(User u) {
		for (AccountObserver ao : aolist) {
			ao.actionSignUp(u);
			ao.actionCloseSignUp();
		}
	}

	@Override
	public void actionLogInAttempt(String tag, String pwd) {
		User u = connection(tag, pwd);
		if(u == null){
			StringBuilder msg = new StringBuilder();
			msg.append("L'utilisateur ");
			msg.append(tag);
			msg.append(" n'est pas reconnu");
			return;
		}
		if(u.equals(user)){
			StringBuilder msg = new StringBuilder();
			msg.append("Vous êtes déjà connecté en tant que ");
			msg.append(user.getName());
			return;
		}
		setUser(u);
		StringBuilder msg = new StringBuilder();
		msg.append("Connecté en tant que ");
		msg.append(user.getName());
		msg.append(", bravo!");
	}
	@Override
	public void actionLogInCancel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionLogOutAttempt() {
		setUser(null);
		StringBuilder msg = new StringBuilder();
		msg.append("Déconnecté");
	}

	@Override
	public void actionLogOutCancel() {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionSignUpAttempt(String tag, String pwd, String name, String img) {
		String userTag = tag;
		String userPassword = String.valueOf(pwd);
		String userName = name;
		String userImage = img;

		if(findUserByTag(userTag) == null){
			User newuser = new User(UUID.randomUUID(), userTag, userPassword, userName, new TreeSet<String>(), userImage);
			entityManager.sendUser(newuser);
			setUser(newuser); // nécessaire pour notifier les observateurs

			StringBuilder msg = new StringBuilder();
			msg.append("Le compte ");
			msg.append(newuser.getName());
			msg.append(" a été créé : ");
			msg.append("\nNom : "+newuser.getName());
			msg.append("\nTag : "+newuser.getUserTag());
			msg.append("\nMot de passe : "+newuser.getUserPassword());
			msg.append("\nAvatar : "+newuser.getAvatarPath());
			System.out.println(msg.toString());
		} else {
			System.out.println("La tentative a échoué, le compte éxiste déjà");					
		}
	}
	@Override
	public void actionSignUpCancel() {
		// TODO Auto-generated method stub

	}



	@Override
	public void actionLogInButton() {
		for (AccountObserver ao : aolist) {
			ao.actionShowLogIn();
		}
	}

	@Override
	public void actionLogOutButton() {
		for (AccountObserver ao : aolist) {
			ao.actionShowLogOut();
		}
	}

	@Override
	public void actionSignUpButton() {
		for (AccountObserver ao : aolist) {
			ao.actionShowSignUp();
		}
	}



}

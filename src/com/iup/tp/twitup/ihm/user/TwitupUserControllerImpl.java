package com.iup.tp.twitup.ihm.user;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;

public class TwitupUserControllerImpl implements TwitupUserController{

	protected User currentUser;
	protected ArrayList<UserObserver> uolist;
	protected IDatabase database;
	protected TwitupUserView userView;
	protected Set<User> followers;
	protected Set<User> searchResult;
	protected Set<Twit> userTwit;

	public TwitupUserControllerImpl(IDatabase database, TwitupUserView uv) {
		this.userView = uv;
		this.database = database;
		this.currentUser = null;
		this.uolist = new ArrayList<UserObserver>();
		this.followers = new TreeSet<User>();
		this.searchResult = new TreeSet<User>();
		this.userTwit = new TreeSet<Twit>();
	}

	@Override
	public void actionLogIn(User u) {
		setCurrentUser(u);
	}

	@Override
	public void actionLogOut(User u) {
		setCurrentUser(null);
	}

	@Override
	public void init() {
		database.addObserver(this);
		userView.setListUserAbonnes(followers);
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
		updateFollowers();
		notifyUserChange(currentUser);
	}

	/**
	 * Met à jour la liste des twits de l'utilisateur courrant
	 */
	@Override
	public void notifyTwitAdded(Twit addedTwit) {
		if(currentUser != null){
			setUserTwit(database.getTwitsWithUserTag(currentUser.getUserTag()));
		}
	}

	/**
	 * Met à jour la liste des twits de l'utilisateur courrant
	 */
	@Override
	public void notifyTwitDeleted(Twit deletedTwit) {
		if(currentUser != null){
			setUserTwit(database.getTwitsWithUserTag(currentUser.getUserTag()));
		}
	}

	/**
	 * Met à jour la liste des twits de l'utilisateur courrant
	 */
	@Override
	public void notifyTwitModified(Twit modifiedTwit) {
		if(currentUser != null){
			setUserTwit(database.getTwitsWithUserTag(currentUser.getUserTag()));
		}
	}

	/**
	 * Met à jour la liste des abonnés de l'utilisateur courrant
	 */
	@Override
	public void notifyUserAdded(User addedUser) {
		System.out.println("New user : ");
		printUser(addedUser);
		if(currentUser != null){
			updateFollowers();
		}
	}

	/**
	 * Met à jour la liste des abonnés de l'utilisateur courrant
	 */
	@Override
	public void notifyUserDeleted(User deletedUser) {
		System.out.println("Deleted user : ");
		printUser(deletedUser);
		if(currentUser != null){
			updateFollowers();
		}
	}

	/**
	 * Met à jour la liste des abonnés de l'utilisateur courrant
	 */
	@Override
	public void notifyUserModified(User modifiedUser) {
		System.out.println("Modified user : ");
		printUser(modifiedUser);
		if(currentUser != null){
			updateFollowers();
		}
	}

	
	// GETTERS / SETTERS
	public Set<User> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<User> abonne) {
		this.followers = abonne;
		userView.setListUserAbonnes(abonne);
	}
	
	public void updateFollowers(){
		setFollowers(database.getUsers());
		for (User user : followers) {
			System.out.println(user.getName());
		}
	}

	public Set<User> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(Set<User> recherche) {
		this.searchResult = recherche;
		userView.setListResearched(recherche);
	}

	public Set<Twit> getUserTwit() {
		return userTwit;
	}

	public void setUserTwit(Set<Twit> userTwit) {
		this.userTwit = userTwit;
	}

	public void printUser(User u){
		StringBuilder msg = new StringBuilder();
		msg.append("\nNom : "+u.getName());
		msg.append("\nTag : "+u.getUserTag());
		msg.append("\nMot de passe : "+u.getUserPassword());
		msg.append("\nAvatar : "+u.getAvatarPath());
		System.out.println(msg);
	}
	

}

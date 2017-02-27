package com.iup.tp.twitup.ihm.user;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;

public class TwitupUserControllerImpl implements TwitupUserController{

	protected User currentUser;
	protected IDatabase database;
	protected Set<User> followers;
	protected Set<User> searchResult;
	protected Set<Twit> userTwit;
	protected ArrayList<UserObserver> uolist;

	public TwitupUserControllerImpl(IDatabase database) {
		this.database = database;
		this.currentUser = null;
		this.uolist = new ArrayList<UserObserver>();
		this.followers = new TreeSet<User>();
		this.searchResult = new TreeSet<User>();
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
	public void addUserObserver(UserObserver uo) {
		uolist.add(uo);
	}

	@Override
	public void delUserObserver(UserObserver uo) {
		uolist.remove(uo);
	}


	public User getCurrentUser() {
		return currentUser;
	}


	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
		if(currentUser != null){
			this.followers = database.getFollowers(currentUser);
		} else {
			this.followers = new TreeSet<User>();
		}
		notifyProfilChange(currentUser);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void notifyTwitAdded(Twit addedTwit) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void notifyTwitDeleted(Twit deletedTwit) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void notifyTwitModified(Twit modifiedTwit) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void notifyUserAdded(User addedUser) {
		System.out.println("New user : ");
		printUser(addedUser);
		System.out.println(currentUser);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void notifyUserDeleted(User deletedUser) {
		System.out.println("Deleted user : ");
		printUser(deletedUser);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void notifyUserModified(User modifiedUser) {
		System.out.println("Modified user : ");
		printUser(modifiedUser);
	}


	// GETTERS / SETTERS

	public Set<User> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(Set<User> recherche) {
		this.searchResult = recherche;
		notifySearchResult(searchResult);
	}

	public void printUser(User u){
		StringBuilder msg = new StringBuilder();
		msg.append("\nNom : "+u.getName());
		msg.append("\nTag : "+u.getUserTag());
		msg.append("\nMot de passe : "+u.getUserPassword());
		msg.append("\nAvatar : "+u.getAvatarPath());
		System.out.println(msg);
	}

	// OBS

	@Override
	public void notifyUserChange(User u) {
		for (UserObserver uo : uolist) {
			uo.actionUserChange(u);
		}
	}
	
	@Override
	public void notifyProfilChange(User u) {
		for (UserObserver uo : uolist) {
			uo.actionProfilChange(u);
		}
	}
		
	@Override
	public void notifyNewFollower(User u) {
		for (UserObserver uo : uolist) {
			uo.actionNewFollower(u);
		}
	}

	@Override
	public void notifyLostFollower(User u) {
		for (UserObserver uo : uolist) {
			uo.actionLostFollower(u);
		}
	}

	@Override
	public void notifyFollowUser(User u) {
		for (UserObserver uo : uolist) {
			uo.actionFollowUser(u);
		}
	}

	@Override
	public void notifyUnfollowUser(User u) {
		for (UserObserver uo : uolist) {
			uo.actionUnfollowUser(u);
		}
	}

	@Override
	public void notifySearchResult(Set<User> users) {
		for (UserObserver uo : uolist) {
			uo.actionSearchUser(users);
		}
	}


	@Override
	public void actionSignUp(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionShowLogIn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionShowLogOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionShowSignUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionModifyName(String name) {
		currentUser.setName(name);
		notifyProfilChange(currentUser);
	}

	@Override
	public void actionModifyAvatar(String path) {
		currentUser.setAvatarPath(path);
		notifyProfilChange(currentUser);
	}

	@Override
	public void actionSearchUser(String str) {
		searchResult = new TreeSet<User>();
		for (User user : database.getUsers()) {
			if(user.getName().contains(str)){
				searchResult.add(user);		
				notifySearchResult(searchResult);
			}
		}
	}

	@Override
	public void actionSelectUser(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionFollowUser(User u) {
		currentUser.addFollowing(u.getUserTag());
		this.followers = database.getFollowers(currentUser);
		notifyFollowUser(u);
	}

	@Override
	public void actionUnfollowUser(User u) {
		currentUser.removeFollowing(u.getUserTag());
		this.followers = database.getFollowers(currentUser);
		notifyFollowUser(u);
	}


}

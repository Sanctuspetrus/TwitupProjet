package com.iup.tp.twitup.ihm.user.controller;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.user.observer.FollowersObserver;
import com.iup.tp.twitup.ihm.user.observer.ListUserObserver;
import com.iup.tp.twitup.ihm.user.observer.ProfilObserver;

public class TwitupUserControllerImpl implements TwitupUserController{

	protected User currentUser;
	protected IDatabase database;
	protected Set<User> followers;
	protected Set<User> searchResult;
	protected Set<Twit> userTwit;
	protected ArrayList<ListUserObserver> listUserObslist;
	protected ArrayList<FollowersObserver> folObslist;
	protected ArrayList<ProfilObserver> profilObslist;

	public TwitupUserControllerImpl(IDatabase database) {
		this.database = database;
		this.database.addObserver(this);
		this.currentUser = null;
		this.profilObslist = new ArrayList<ProfilObserver>();
		this.listUserObslist = new ArrayList<ListUserObserver>();
		this.folObslist = new ArrayList<FollowersObserver>();
		this.followers = new TreeSet<User>();
		this.searchResult = new TreeSet<User>();
	}

	@Override
	public void addListUserObserver(ListUserObserver uo) {
		listUserObslist.add(uo);
	}

	@Override
	public void delListUserObserver(ListUserObserver uo) {
		listUserObslist.remove(uo);
	}

	@Override
	public void addProfilObserver(ProfilObserver po) {
		profilObslist.add(po);
	}

	@Override
	public void delProfilObserver(ProfilObserver po) {
		profilObslist.remove(po);
	}

	@Override
	public void addFollowersObserver(FollowersObserver fo) {
		folObslist.add(fo);
	}

	@Override
	public void delFollowersObserver(FollowersObserver fo) {
		folObslist.remove(fo);
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
		notifyUserChange(currentUser);
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
		
		if(currentUser != null){
			for (String tag : modifiedUser.getFollows()) {
				if(database.getFollowersCount(currentUser) != this.f) {

				}
			}			
		}
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
	public void actionLogIn(User u) {
		setCurrentUser(u);
	}

	@Override
	public void actionLogOut(User u) {
		setCurrentUser(null);
	}

	@Override
	public void notifyUserChange(User u) {
		for (ProfilObserver po : profilObslist) {
			po.actionUserChange(u);
		}
	}
	
	@Override
	public void notifyProfilChange(User u) {
		for (ProfilObserver po : profilObslist) {
			po.actionProfilChange(u);
		}
	}
		
	@Override
	public void notifyNewFollower(User u) {
		for (FollowersObserver fo : folObslist) {
			fo.actionNewFollower(u);
		}
	}

	@Override
	public void notifyLostFollower(User u) {
		for (FollowersObserver fo : folObslist) {
			fo.actionLostFollower(u);
		}
	}

	@Override
	public void notifyFollowUser(User u) {
		for (ListUserObserver uo : listUserObslist) {
			uo.actionFollowUser(u);
		}
	}

	@Override
	public void notifyUnfollowUser(User u) {
		for (FollowersObserver fo : folObslist) {
			fo.actionUnfollowUser(u);
		}
	}

	@Override
	public void notifySearchResult(Set<User> users) {
		for (ListUserObserver uo : listUserObslist) {
			uo.actionSearchUser(users);
		}
	}


	@Override
	public void actionSignUp(User u) {
		notifyUserChange(u);
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

	@Override
	public void actionCloseLogIn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionCloseLogOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionCloseSignUp() {
		// TODO Auto-generated method stub
		
	}

}

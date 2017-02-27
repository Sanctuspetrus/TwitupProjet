package com.iup.tp.twitup.ihm.twit.controller;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.twit.TwitObserver;

public class TwitupTwitControllerImpl implements TwitupTwitController{

	protected EntityManager em;
	protected IDatabase database;
	protected User user;
	protected ArrayList<TwitObserver> listTwitObs;

	public TwitupTwitControllerImpl(IDatabase db, EntityManager em){
		this.em = em;
		this.database = db;
		user = null;
		listTwitObs = new ArrayList<TwitObserver>();
	}

	@Override
	public void actionUserChange(User u) {
		this.user = u;
	}

	@Override
	public void actionNewTwit(String t) {
		if(user != null){
			em.sendTwit(new Twit(user, t));
			System.out.println("Twit :\n" + t);
		} else {
			System.out.println("Pas connecté");
		}
	}

	@Override
	public void actionRecherche(String r) {
		// On ne fait rien si la chaine est vide
		if(!r.isEmpty() && r.substring(1).length() > 3){
			Set<Twit> twits = new TreeSet<Twit>();

			String str = r;
			char sym = r.charAt(0);
			// Si le premier caractère est un des symboles spéciaux ont le retire
			if(sym == '@' || sym == '#')
				str = r.substring(1);			

			// Si il n'est pas explicitement demandé les tags non user ont prend la list par tag user
			if(sym != '#')
				twits.addAll(database.getTwitsWithUserTag(str));
			// Si il n'est pas explicitement demandé les tags user ont prend la list par tag
			if(sym != '@')
				twits.addAll(database.getTwitsWithTag(str));		
			notifySearchResult(twits);
		}
	}

	@Override
	public void actionNewFollower(User f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionLostFollower(User f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionFollowUser(User f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionUnfollowUser(User f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionSearchUser(Set<User> searchResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionProfilChange(User u) {
		// TODO Auto-generated method stub

	}


	@Override
	public void notifySearchResult(Set<Twit> twits) {
		for (TwitObserver twitObs : listTwitObs) {
			twitObs.actionSearchResult(twits);
		}
	}

	@Override
	public void notifyTwitAdded(Set<Twit> twits, Twit twit) {
		for (TwitObserver twitObs : listTwitObs) {
			twitObs.actionTwitAdded(twits, twit);
		}
	}

	@Override
	public void notifyTwitDeleted(Set<Twit> twits, Twit twit) {
		for (TwitObserver twitObs : listTwitObs) {
			twitObs.actionTwitDeleted(twits, twit);
		}
	}
	@Override
	public void notifyTwitModified(Set<Twit> twits, Twit twit) {
		for (TwitObserver twitObs : listTwitObs) {
			twitObs.actionTwitModified(twits, twit);
		}
	}


	// OBS DATABASE
	@Override
	public void notifyTwitAdded(Twit addedTwit) {
		notifyTwitAdded(database.getTwits(), addedTwit);
	}

	@Override
	public void notifyTwitDeleted(Twit deletedTwit) {
		notifyTwitAdded(database.getTwits(), deletedTwit);
	}

	@Override
	public void notifyTwitModified(Twit modifiedTwit) {
		notifyTwitModified(database.getTwits(), modifiedTwit);
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

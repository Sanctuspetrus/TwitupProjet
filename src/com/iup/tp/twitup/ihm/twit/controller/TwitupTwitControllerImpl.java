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
		db.addObserver(this);
		user = null;
		listTwitObs = new ArrayList<TwitObserver>();
	}

	@Override
	public void actionUserChange(User u) {
		this.user = u;
		if(user != null){			
			Set<Twit> listtwits = database.getTwitsWithUserTag(user.getUserTag());
			listtwits.addAll(database.getUserTwits(user));
			this.notifyStartTwit(listtwits);
		}
	}

	@Override
	public void actionNewTwit(String t) {
		if(user != null){
			em.sendTwit(new Twit(user, t));
			System.out.println("Twit :\n" + t);
		} else {
			System.out.println("Pas connect�");
		}
	}

	@Override
	public void actionRecherche(String r) {
		// On ne fait rien si la chaine est vide
		if(!r.isEmpty() && r.substring(1).length() > 3){
			Set<Twit> twits = new TreeSet<Twit>();

			String str = r;
			char sym = r.charAt(0);
			// Si le premier caract�re est un des symboles sp�ciaux ont le retire
			if(sym == '@' || sym == '#')
				str = r.substring(1);			

			// Si il n'est pas explicitement demand� les tags non user ont prend la list par tag user
			if(sym != '#')
				twits.addAll(database.getTwitsWithUserTag(str));
			// Si il n'est pas explicitement demand� les tags user ont prend la list par tag
			if(sym != '@')
				twits.addAll(database.getTwitsWithTag(str));		
			notifySearchResult(twits);
		}
	}

	@Override
	public void actionProfilChange(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTwitObserver(TwitObserver to){
		listTwitObs.add(to);
	}

	@Override
	public void delTwitObserver(TwitObserver to){
		listTwitObs.remove(to);
	}

	@Override
	public void notifySearchResult(Set<Twit> twits) {
		for (TwitObserver twitObs : listTwitObs) {
			twitObs.actionSearchResult(twits);
		}
	}

	@Override
	public void notifyStartTwit(Set<Twit> twits) {
		System.out.println("Observateurs des twits notifier");
		for (TwitObserver twitObs : listTwitObs) {
			twitObs.actionStartTwits(twits);
		}
	}
	@Override
	public void notifyNewTwit(Set<Twit> twits, Twit twit) {
		System.out.println("Observateurs des twits notifier");
		for (TwitObserver twitObs : listTwitObs) {
			twitObs.actionTwitAdded(twits, twit);
		}
	}
	@Override
	public void notifyRemoveTwit(Set<Twit> twits, Twit twit) {
		for (TwitObserver twitObs : listTwitObs) {
			twitObs.actionTwitDeleted(twits, twit);
		}
	}
	@Override
	public void notifyModifyTwit(Set<Twit> twits, Twit twit) {
		for (TwitObserver twitObs : listTwitObs) {
			twitObs.actionTwitModified(twits, twit);
		}
	}


	// OBS DATABASE
	@Override
	public void notifyTwitAdded(Twit addedTwit) {
		if (user != null && addedTwit.containsUserTag(user.getUserTag())) {
			Set<Twit> listtwits = database.getTwitsWithUserTag(user.getUserTag());
			listtwits.addAll(database.getUserTwits(user));
			notifyNewTwit(listtwits, addedTwit);
		}
	}

	@Override
	public void notifyTwitDeleted(Twit deletedTwit) {
		if (user != null && deletedTwit.containsUserTag(user.getUserTag())) {
			Set<Twit> listtwits = database.getTwitsWithUserTag(user.getUserTag());
			listtwits.addAll(database.getUserTwits(user));
			notifyRemoveTwit(listtwits, deletedTwit);
		}
	}

	@Override
	public void notifyTwitModified(Twit modifiedTwit) {
		if (user != null && modifiedTwit.containsUserTag(user.getUserTag())) {
			Set<Twit> listtwits = database.getTwitsWithUserTag(user.getUserTag());
			listtwits.addAll(database.getUserTwits(user));
			notifyModifyTwit(listtwits, modifiedTwit);
		}
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

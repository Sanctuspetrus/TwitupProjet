package com.iup.tp.twitup.ihm.twit.controller;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;

public class TwitupTwitControllerImpl implements TwitupTwitController{

	protected EntityManager em;
	protected User user;

	public TwitupTwitControllerImpl(EntityManager em){
		this.em = em;
		user = null;
	}

	@Override
	public void init() {
	}

	@Override
	public void destroy() {
	}

	@Override
	public void actionUserChange(User u) {
		this.user = u;
	}

	@Override
	public void notifyNewTwit(String t) {
		if(user != null){
			em.sendTwit(new Twit(user, t));
			
			System.out.println("Twit :\n" + t);
		} else {
			System.out.println("Pas connecté");
		}
	}

	@Override
	public void notifyRecherche(String r) {
		System.out.println(r);
	}

}

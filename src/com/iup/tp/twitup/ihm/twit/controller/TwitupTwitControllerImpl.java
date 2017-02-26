package com.iup.tp.twitup.ihm.twit.controller;

import com.iup.tp.twitup.core.EntityManager;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;

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

}

package com.iup.tp.twitup.ihm.login;

import com.iup.tp.twitup.core.EntityManager;

public class TwitupLoginControllerImpl implements TwitupLoginController {
	
	protected EntityManager em;
	protected TwitupSignInView loginView;
	
	public TwitupLoginControllerImpl(EntityManager em, TwitupSignInView lv){
		this.em = em;
		this.loginView = lv;
	}
	
	
	
	public boolean connexion(String pseudo, String password){
		
		
		
		
		return false;		
	}
	
}

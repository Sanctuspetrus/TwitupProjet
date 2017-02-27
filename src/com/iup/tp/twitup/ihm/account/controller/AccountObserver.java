package com.iup.tp.twitup.ihm.account.controller;

import com.iup.tp.twitup.datamodel.User;

public interface AccountObserver {
	/**
	 * Code � effectu� quand le contr�leur de compte connecte l'utilisateur
	 * @param u
	 */
	void actionLogIn(User u);
	/**
	 * Code � effectu� quand le contr�leur de compte d�connecte l'utilisateur
	 * @param u
	 */
	void actionLogOut(User u);
	/**
	 * Code � effectu� quand le contr�leur de compte cr�e un nouvel utilisateur
	 * @param u
	 */
	void actionSignUp(User u);
	/**
	 * le contr�leur de compte demande d'afficher la fen�tre de connexion
	 * @param u
	 */
	void actionShowLogIn();
	/**
	 * le contr�leur de compte demande d'afficher la fen�tre de d�connexion
	 * @param u
	 */
	void actionShowLogOut();
	/**
	 * le contr�leur de compte demande d'afficher la fen�tre de cr�ation de compte
	 * @param u
	 */
	void actionShowSignUp();

	/**
	 * le contr�leur de compte demande de fermer la fen�tre de connexion
	 * @param u
	 */
	void actionCloseLogIn();
	/**
	 * le contr�leur de compte demande de fermer la fen�tre de d�connexion
	 * @param u
	 */
	void actionCloseLogOut();
	/**
	 * le contr�leur de compte demande de fermer la fen�tre de cration de compte
	 * @param u
	 */
	void actionCloseSignUp();
}

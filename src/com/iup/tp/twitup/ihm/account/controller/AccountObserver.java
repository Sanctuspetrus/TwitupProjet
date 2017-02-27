package com.iup.tp.twitup.ihm.account.controller;

import com.iup.tp.twitup.datamodel.User;

public interface AccountObserver {
	/**
	 * Code à effectué quand le contrôleur de compte connecte l'utilisateur
	 * @param u
	 */
	void actionLogIn(User u);
	/**
	 * Code à effectué quand le contrôleur de compte déconnecte l'utilisateur
	 * @param u
	 */
	void actionLogOut(User u);
	/**
	 * Code à effectué quand le contrôleur de compte crée un nouvel utilisateur
	 * @param u
	 */
	void actionSignUp(User u);
	/**
	 * le contrôleur de compte demande d'afficher la fenêtre de connexion
	 * @param u
	 */
	void actionShowLogIn();
	/**
	 * le contrôleur de compte demande d'afficher la fenêtre de déconnexion
	 * @param u
	 */
	void actionShowLogOut();
	/**
	 * le contrôleur de compte demande d'afficher la fenêtre de création de compte
	 * @param u
	 */
	void actionShowSignUp();

	/**
	 * le contrôleur de compte demande de fermer la fenêtre de connexion
	 * @param u
	 */
	void actionCloseLogIn();
	/**
	 * le contrôleur de compte demande de fermer la fenêtre de déconnexion
	 * @param u
	 */
	void actionCloseLogOut();
	/**
	 * le contrôleur de compte demande de fermer la fenêtre de cration de compte
	 * @param u
	 */
	void actionCloseSignUp();
}

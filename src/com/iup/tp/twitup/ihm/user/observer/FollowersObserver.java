package com.iup.tp.twitup.ihm.user.observer;

import com.iup.tp.twitup.datamodel.User;

public interface FollowersObserver {
	/**
	 * Code à exécuter quand une nouvelle personne suit l'utilisateur connecté
	 * @param f
	 */
	void actionNewFollower(User f);
	/**
	 * Code à exécuter quand une personne arrete de suivre l'utilisateur connecté
	 * @param f
	 */
	void actionLostFollower(User f);
	void actionUnfollowUser(User f);
}

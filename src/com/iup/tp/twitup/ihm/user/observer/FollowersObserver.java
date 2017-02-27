package com.iup.tp.twitup.ihm.user.observer;

import com.iup.tp.twitup.datamodel.User;

public interface FollowersObserver {
	/**
	 * Code � ex�cuter quand une nouvelle personne suit l'utilisateur connect�
	 * @param f
	 */
	void actionNewFollower(User f);
	/**
	 * Code � ex�cuter quand une personne arrete de suivre l'utilisateur connect�
	 * @param f
	 */
	void actionLostFollower(User f);
	void actionUnfollowUser(User f);
}

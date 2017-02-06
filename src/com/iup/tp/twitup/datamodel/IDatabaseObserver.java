package com.iup.tp.twitup.datamodel;

/**
 * Interface des observateurs des modifications de la base de donn�es.
 * 
 * @author S.Lucas
 */
public interface IDatabaseObserver {
	/**
	 * Notification lorsqu'un Twit est ajout� en base de donn�es.
	 * 
	 * @param addedTwit
	 */
	void notifyTwitAdded(Twit addedTwit);

	/**
	 * Notification lorsqu'un Twit est supprim� de la base de donn�es.
	 * 
	 * @param deletedTwit
	 */
	void notifyTwitDeleted(Twit deletedTwit);

	/**
	 * Notification lorsqu'un Twit est modifi� en base de donn�es.
	 * 
	 * @param modifiedTwit
	 */
	void notifyTwitModified(Twit modifiedTwit);

	/**
	 * Notification lorsqu'un utilisateur est ajout� en base de donn�es.
	 * 
	 * @param addedUser
	 */
	void notifyUserAdded(User addedUser);

	/**
	 * Notification lorsqu'un utilisateur est supprim� de la base de donn�es.
	 * 
	 * @param deletedUser
	 */
	void notifyUserDeleted(User deletedUser);

	/**
	 * Notification lorsqu'un utilisateur est modifi� en base de donn�es.
	 * 
	 * @param modifiedUser
	 */
	void notifyUserModified(User modifiedUser);
}

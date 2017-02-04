package com.iup.tp.twitup.datamodel;

import java.util.Set;

/**
 * Interface de la base de donn�es de l'application.
 * 
 * @author S.Lucas
 */
public interface IDatabase {

	/**
	 * Ajoute un observateur sur les modifications de la base de donn�es.
	 * 
	 * @param observer
	 */
	void addObserver(IDatabaseObserver observer);

	/**
	 * Supprime un observateur sur les modifications de la base de donn�es.
	 * 
	 * @param observer
	 */
	void deleteObserver(IDatabaseObserver observer);

	/**
	 * Retourne la liste des utilisateurs
	 */
	Set<User> getUsers();

	/**
	 * Retourne la liste des twits
	 */
	Set<Twit> getTwits();

	/**
	 * Ajoute un twit � la base de donn�es.
	 * 
	 * @param twitToAdd
	 */
	void addTwit(Twit twitToAdd);

	/**
	 * Supprime un twit de la base de donn�es.
	 * 
	 * @param twitToRemove
	 */
	void removeTwit(Twit twitToRemove);

	/**
	 * Modification d'un twit de la base de donn�es. <br/>
	 * <i>Normalement peu probable qu'un twit soit modifi�...</i>
	 * 
	 * @param twitToModify
	 */
	void modifiyTwit(Twit twitToModify);

	/**
	 * Ajoute un utilisateur � la base de donn�es.
	 * 
	 * @param userToAdd
	 */
	void addUser(User userToAdd);

	/**
	 * Supprime un utilisateur de la base de donn�es.
	 * 
	 * @param userToRemove
	 */
	void removeUser(User userToRemove);

	/**
	 * Modification d'un utilisateur de la base de donn�es.
	 * 
	 * @param userToModify
	 */
	void modifiyUser(User userToModify);

	/**
	 * Supprime l'int�gralit� des twits enregistr�s.
	 */
	void clearTwits();

	/**
	 * Supprime l'int�gralit� des utilisateurs enregistr�s.
	 */
	void clearUsers();

	/**
	 * Supprime l'int�gralit� des donn�es.
	 */
	void clear();

	/**
	 * Retourne tous les Twits pr�sents en base ayant le tag donn�
	 * 
	 * @param tag
	 *            , tag � rechercher.
	 */
	Set<Twit> getTwitsWithTag(String tag);

	/**
	 * Retourne tous les Twits pr�sents en base ayant le tag utilisateur donn�
	 * 
	 * @param userTag
	 *            , tag utilisateur � rechercher.
	 */
	Set<Twit> getTwitsWithUserTag(String userTag);

	/**
	 * Retourne tous les Twits d'un utilisateur.
	 * 
	 * @param user
	 *            , utilisateur dont les twits sont � rechercher.
	 */
	Set<Twit> getUserTwits(User user);

	/**
	 * Retourne tous les utilisateurs suivant l'utilisateur donn�e
	 * 
	 * @param user
	 *            , utilisateur dont les followers sont � rechercher.
	 */
	Set<User> getFollowers(User user);

	/**
	 * Retourne le nombre de followers pour l'utilisateur donn�.
	 * 
	 * @param user
	 *            , utilisateur dont le nombre de followers est � rechercher.
	 */
	int getFollowersCount(User user);

	/**
	 * Retourne l'utilisateur inconnu du syst�me.
	 */
	public User getUnknowUser();

}

package com.iup.tp.twitup.ihm.twit;

import java.util.Set;

import com.iup.tp.twitup.datamodel.Twit;

public interface TwitObserver {
	/**
	 * R�sultat d'une recherche
	 * @param twits
	 */
	public void actionSearchResult(Set<Twit> twits);
	/**
	 * Nouvelle liste de twit + twit ajout�
	 * @param twits
	 */
	public void actionTwitAdded(Set<Twit> twits, Twit twit);
	/**
	 * Nouvelle liste de twit + twit supprim�
	 * @param twits
	 */
	public void actionTwitDeleted(Set<Twit> twits, Twit twit);
	/**
	 * Nouvelle liste de twit + twit supprim�
	 * @param twits
	 */
	public void actionTwitModified(Set<Twit> twits, Twit twit);
	/**
	 * Liste des twits de l'utilisateur connect�
	 * @param twits
	 */
	public void actionStartTwits(Set<Twit> twits);
}

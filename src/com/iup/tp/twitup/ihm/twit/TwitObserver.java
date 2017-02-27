package com.iup.tp.twitup.ihm.twit;

import java.util.Set;

import com.iup.tp.twitup.datamodel.Twit;

public interface TwitObserver {
	/**
	 * Résultat d'une recherche
	 * @param twits
	 */
	public void actionSearchResult(Set<Twit> twits);
	/**
	 * Nouvelle liste de twit + twit ajouté
	 * @param twits
	 */
	public void actionTwitAdded(Set<Twit> twits, Twit twit);
	/**
	 * Nouvelle liste de twit + twit supprimé
	 * @param twits
	 */
	public void actionTwitDeleted(Set<Twit> twits, Twit twit);
	/**
	 * Nouvelle liste de twit + twit supprimé
	 * @param twits
	 */
	public void actionTwitModified(Set<Twit> twits, Twit twit);
	/**
	 * Liste des twits de l'utilisateur connecté
	 * @param twits
	 */
	public void actionStartTwits(Set<Twit> twits);
}

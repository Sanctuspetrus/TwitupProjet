package com.iup.tp.twitup.ihm;


public interface TwitupView {
	
	/**
	 * Initialise tous les composant de la vue et le différentes actions
	 */
	public void init();
	/**
	 * Lance l'affichage de la vue
	 */
	public void show();
	/**
	 * Arrête l'affichage de la vue
	 */
	public void close();
	/**
	 * Désabonne tous les watchers et ferme proprement la vue
	 */
	public void destroy();
}

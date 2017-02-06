package com.iup.tp.twitup.ihm;


public interface TwitupView {
	
	/**
	 * Initialise tous les composant de la vue et le diff�rentes actions
	 */
	public void init();
	/**
	 * Lance l'affichage de la vue
	 */
	public void show();
	/**
	 * Arr�te l'affichage de la vue
	 */
	public void close();
	/**
	 * D�sabonne tous les watchers et ferme proprement la vue
	 */
	public void destroy();
}

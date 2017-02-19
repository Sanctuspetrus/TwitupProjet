package com.iup.tp.twitup.ihm.mainview.view;


import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;
import com.iup.tp.twitup.ihm.user.TwitupUserView;

/**
 * Classe de la vue principale de l'application.
 */
public interface TwitupMainView extends TwitupView {
	
	public void init(TwitupUserView userView, TwitupTwitView twitView);
	public void close();
	
}

package com.iup.tp.twitup.ihm.menubar.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;
import com.iup.tp.twitup.ihm.event.TwitupWatchable;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public class TwitupMenuBarViewImpl implements TwitupMenuBarView, TwitupAccountActionView {

	protected JFrame frame;

	protected JMenuBar menuBar;
	protected JMenu files;
	protected JMenu account;
	protected JMenu help;
	protected JMenuItem shareFolder;
	protected JMenuItem close;
	protected JMenuItem about;
	protected JMenuItem signUp;
	protected JMenuItem signIn;
	protected JMenuItem signOut;

	protected TwitupWatchable closeWatcher;
	protected TwitupWatchable aboutWatcher;
	protected TwitupWatchable modifyExchangeFolderWatcher;
	protected TwitupWatchable signUpWatcher;
	protected TwitupWatchable signInWatcher;
	protected TwitupWatchable signOutWatcher;

	public TwitupMenuBarViewImpl(JFrame f) {
		// Composants graphiques
		menuBar = new JMenuBar();
		frame = f;
		files = new JMenu("Fichier");
		account = new JMenu("Compte");
		help = new JMenu("?");
		shareFolder = new JMenuItem("Répertoire d'échange");
		close = new JMenuItem("Quitter", new ImageIcon("src/resources/images/middle.gif"));
		about = new JMenuItem("A propos");
		signUp = new JMenuItem("Créer un compte");
		signIn = new JMenuItem("Connexion");
		signOut = new JMenuItem("Déconnexion");
		
		// Watchers
		closeWatcher = new TwitupWatchable();
		aboutWatcher = new TwitupWatchable();
		modifyExchangeFolderWatcher = new TwitupWatchable();
		signUpWatcher = new TwitupWatchable();
		signInWatcher = new TwitupWatchable();
		signOutWatcher = new TwitupWatchable();
	}

	@Override
	public void show() {
		// Build the first menu.
		files.setMnemonic(KeyEvent.VK_F);
		// a submenu
		shareFolder.setMnemonic(KeyEvent.VK_Q);
		shareFolder.getAccessibleContext().setAccessibleDescription("Quitter l'application");
		shareFolder.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modifyExchangeFolderWatcher.sendEvent();
			}
		});
		files.add(shareFolder);

		close.setMnemonic(KeyEvent.VK_Q);
		close.getAccessibleContext().setAccessibleDescription("Quitter l'application");
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				closeWatcher.sendEvent();
			}
		});
		files.add(close);

		menuBar.add(files);
		
		
		// Menu Compte
		account.setMnemonic(KeyEvent.VK_C);
		// Bouton créer un compte
		signUp.setMnemonic(KeyEvent.VK_P);
		signUp.getAccessibleContext().setAccessibleDescription("Créer un nouveau compte utilisateur");
		signUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signUpWatcher.sendEvent();
			}
		});
		account.add(signUp);
		// Bouton de connexion
		signIn.setMnemonic(KeyEvent.VK_P);
		signIn.getAccessibleContext().setAccessibleDescription("Connexion");
		signIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signInWatcher.sendEvent();
			}
		});
		account.add(signIn);
		// Bouton de déconnexion
		signOut.setMnemonic(KeyEvent.VK_P);
		signOut.getAccessibleContext().setAccessibleDescription("Déconnexion");
		signOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				signOutWatcher.sendEvent();
			}
		});
		account.add(signOut);
			
		menuBar.add(account);
		

		// Build second menu in the menu bar.
		help.setMnemonic(KeyEvent.VK_COMMA);
		help.getAccessibleContext().setAccessibleDescription("Aide");
		// a submenu
		about.setMnemonic(KeyEvent.VK_Q);
		about.getAccessibleContext().setAccessibleDescription("Informations sur l'application");
		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aboutWatcher.sendEvent();
			}
		});
		help.add(about);

		menuBar.add(help);
		
		frame.setJMenuBar(menuBar);
	}

	public void close(){
		// TODO
		menuBar.removeAll();
	}
	
	// ACTIONS
	@Override
	public void showSignIn(boolean bool) {
		signIn.setVisible(bool);
	}

	@Override
	public void showSignOut(boolean bool) {
		signOut.setVisible(bool);
	}
	
	// WATCHERS
	@Override
	public void addActionClose(TwitupWatcher tw) {
		closeWatcher.addWatcher(tw);
	}

	@Override
	public void delActionClose(TwitupWatcher tw) {
		closeWatcher.delWatcher(tw);
	}

	@Override
	public void addActionAbout(TwitupWatcher tw) {
		aboutWatcher.addWatcher(tw);
	}

	@Override
	public void delActionAbout(TwitupWatcher tw) {
		aboutWatcher.delWatcher(tw);
	}

	@Override
	public void addActionModifyExchangeFolder(TwitupWatcher tw) {
		modifyExchangeFolderWatcher.addWatcher(tw);
	}

	@Override
	public void delActionModifyExchangeFolder(TwitupWatcher tw) {
		modifyExchangeFolderWatcher.delWatcher(tw);
	}

	@Override
	public void addActionSignUp(TwitupWatcher tw) {
		signUpWatcher.addWatcher(tw);
	}

	@Override
	public void delActionSignUp(TwitupWatcher tw) {
		signUpWatcher.delWatcher(tw);
	}

	@Override
	public void addActionLogIn(TwitupWatcher tw) {
		signInWatcher.addWatcher(tw);
	}

	@Override
	public void delActionLogIn(TwitupWatcher tw) {
		signInWatcher.delWatcher(tw);
	}

	@Override
	public void addActionLogOut(TwitupWatcher tw) {
		signOutWatcher.addWatcher(tw);
	}

	@Override
	public void delActionLogOut(TwitupWatcher tw) {
		signOutWatcher.delWatcher(tw);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


}

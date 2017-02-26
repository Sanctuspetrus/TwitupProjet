package com.iup.tp.twitup.ihm.menubar.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.iup.tp.twitup.ihm.account.AccountActionViewObserver;
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
	

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAccountActionViewObserver(AccountActionViewObserver aavo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delAccountActionViewObserver(AccountActionViewObserver aavo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendLogInButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendLogOutButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendSignUpButton() {
		// TODO Auto-generated method stub
		
	}


}

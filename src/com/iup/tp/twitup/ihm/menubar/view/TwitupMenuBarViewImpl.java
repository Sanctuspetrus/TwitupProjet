package com.iup.tp.twitup.ihm.menubar.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.iup.tp.twitup.ihm.account.AccountActionViewObserver;
import com.iup.tp.twitup.ihm.account.view.TwitupAccountActionView;

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

	protected ArrayList<AccountActionViewObserver> obs = new ArrayList<AccountActionViewObserver>();
	protected ArrayList<MenuBarViewObserver> obsMenuBar = new ArrayList<MenuBarViewObserver>();

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
				notifyModifyExchangeFolderButton();
			}
		});
		files.add(shareFolder);

		close.setMnemonic(KeyEvent.VK_Q);
		close.getAccessibleContext().setAccessibleDescription("Quitter l'application");
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				notifyCloseButton();
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
				sendSignUpButton();
			}
		});
		account.add(signUp);
		// Bouton de connexion
		signIn.setMnemonic(KeyEvent.VK_P);
		signIn.getAccessibleContext().setAccessibleDescription("Connexion");
		signIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendLogInButton();
			}
		});
		account.add(signIn);
		// Bouton de déconnexion
		signOut.setMnemonic(KeyEvent.VK_P);
		signOut.getAccessibleContext().setAccessibleDescription("Déconnexion");
		signOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendLogOutButton();
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
				notifyAboutButton();
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
		this.show();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAccountActionViewObserver(AccountActionViewObserver aavo) {
		obs.add(aavo);
	}

	@Override
	public void delAccountActionViewObserver(AccountActionViewObserver aavo) {
		obs.remove(aavo);
	}

	@Override
	public void sendLogInButton() {
		for (AccountActionViewObserver accountActionViewObserver : obs) {
			accountActionViewObserver.actionLogInButton();
		}
	}

	@Override
	public void sendLogOutButton() {
		for (AccountActionViewObserver accountActionViewObserver : obs) {
			accountActionViewObserver.actionLogOutButton();
		}
	}

	@Override
	public void sendSignUpButton() {
		for (AccountActionViewObserver accountActionViewObserver : obs) {
			accountActionViewObserver.actionSignUpButton();
		}
	}

	@Override
	public void addMenuBarViewObserver(MenuBarViewObserver aavo) {
		obsMenuBar.add(aavo);
	}

	@Override
	public void delMenuBarViewObserver(MenuBarViewObserver aavo) {
		obsMenuBar.remove(aavo);
	}

	@Override
	public void notifyCloseButton() {
		for (MenuBarViewObserver menuObserver : obsMenuBar) {
			menuObserver.actionCloseButton();
		}
	}

	@Override
	public void notifyAboutButton() {
		for (MenuBarViewObserver menuObserver : obsMenuBar) {
			menuObserver.actionAboutButton();
		}
	}

	@Override
	public void notifyModifyExchangeFolderButton() {
		for (MenuBarViewObserver menuObserver : obsMenuBar) {
			menuObserver.actionModifyExchangeFolderButton();
		}
	}

}

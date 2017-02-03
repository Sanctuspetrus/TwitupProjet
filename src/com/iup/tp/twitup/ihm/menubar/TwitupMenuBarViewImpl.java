package com.iup.tp.twitup.ihm.menubar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import com.iup.tp.twitup.ihm.event.TwitupWatchable;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public class TwitupMenuBarViewImpl implements TwitupMenuBarView {

	protected JFrame frame;

	protected JMenuBar menuBar;
	protected JMenu files;
	protected JMenu help;
	protected JMenuItem shareFolder;
	protected JMenuItem close;
	protected JMenuItem about;

	protected TwitupWatchable closeWatcher;
	protected TwitupWatchable aboutWatcher;
	protected TwitupWatchable modifyExchangeFolderWatcher;

	public TwitupMenuBarViewImpl(JFrame f) {
		menuBar = new JMenuBar();
		frame = f;
		files = new JMenu("Fichier");
		shareFolder = new JMenuItem("Répertoire d'échange");
		close = new JMenuItem("Quitter", new ImageIcon("src/resources/images/middle.gif"));
		help = new JMenu("?");
		about = new JMenuItem("A propos");
		closeWatcher = new TwitupWatchable();
		aboutWatcher = new TwitupWatchable();
		modifyExchangeFolderWatcher = new TwitupWatchable();
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

}

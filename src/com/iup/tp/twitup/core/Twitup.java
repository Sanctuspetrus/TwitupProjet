package com.iup.tp.twitup.core;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.common.PropertiesManager;
import com.iup.tp.twitup.datamodel.Database;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.events.file.IWatchableDirectory;
import com.iup.tp.twitup.events.file.WatchableDirectory;
import com.iup.tp.twitup.ihm.TwitupFrame;
import com.iup.tp.twitup.ihm.TwitupMock;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;
import com.iup.tp.twitup.ihm.login.TwitupSignInView;
import com.iup.tp.twitup.ihm.login.TwitupSignInViewImpl;
import com.iup.tp.twitup.ihm.mainview.TwitupMainViewControllerImpl;
import com.iup.tp.twitup.ihm.mainview.TwitupMainViewImpl;
import com.iup.tp.twitup.ihm.mainview.TwitupMainView;
import com.iup.tp.twitup.ihm.menubar.TwitupMenuBarViewImpl;
import com.iup.tp.twitup.ihm.menubar.TwitupMenuBarControllerImpl;
import com.iup.tp.twitup.ihm.menubar.TwitupMenuBarView;

/**
 * Classe principale l'application.
 * 
 * @author S.Lucas
 */
public class Twitup {
	/**
	 * Base de donn�es.
	 */
	protected IDatabase mDatabase;

	/**
	 * Gestionnaire des entit�s contenu de la base de donn�es.
	 */
	protected EntityManager mEntityManager;

	/**
	 * Vue principale de l'application.
	 */
	protected TwitupMainView mMainView;

	/**
	 * Classe de surveillance de r�pertoire
	 */
	protected IWatchableDirectory mWatchableDirectory;

	/**
	 * R�pertoire d'�change de l'application.
	 */
	protected String mExchangeDirectoryPath;

	/**
	 * Idnique si le mode bouchon� est activ�.
	 */
	protected boolean mIsMockEnabled = false;

	/**
	 * Nom de la classe de l'UI.
	 */
	protected String mUiClassName;

	/**
	 * Constructeur.
	 */
	public Twitup() {
		// Init du look and feel de l'application
		this.initLookAndFeel();

		// Initialisation de la base de donn�es
		this.initDatabase();

		if (this.mIsMockEnabled) {
			// Initialisation du bouchon de travail
			this.initMock();
		}

		// Initialisation de l'IHM
		this.initGui();

		// Initialisation du r�pertoire d'�change
		this.initDirectory();
	}

	/**
	 * Initialisation du look and feel de l'application.
	 */
	protected void initLookAndFeel() {
	}

	/**
	 * Initialisation de l'interface graphique.
	 */
	protected void initGui() {
		
		TwitupFrame mainFrame = new TwitupFrame();
		TwitupMainViewControllerImpl mainViewCtrl = new TwitupMainViewControllerImpl();
		mMainView = new TwitupMainViewImpl(mainFrame);


		TwitupMenuBarView menuBar = new TwitupMenuBarViewImpl(mainFrame);
		TwitupMenuBarControllerImpl menuBarCtrl = new TwitupMenuBarControllerImpl(mainFrame, menuBar);
		// On "observe" si le chemin du r�pertoir d'�change a �t� modifi�
		menuBarCtrl.addActionExchangeFolder(new TwitupWatcher() {
			@Override
			public void action(Object o) {
				chooseExchangeDirectory();
			}
		});
		menuBarCtrl.initView();
	}

	/**
	 * Initialisation du r�pertoire d'�change (depuis la conf ou depuis un file
	 * chooser). <br/>
	 * <b>Le chemin doit obligatoirement avoir �t� saisi et �tre valide avant de
	 * pouvoir utiliser l'application</b>
	 */
	protected void initDirectory() {
		// Chargement du fichier de configuration
		Properties properties = PropertiesManager.loadProperties(Constants.CONFIGURATION_FILE);
		// V�rification que le chemin vers le dossier d'�change est fournit dans le fichier de configuration
		if(properties.containsKey(Constants.CONFIGURATION_KEY_EXCHANGE_DIRECTORY)){
			// Chargement du chemin et on quitte
			mExchangeDirectoryPath = properties.getProperty(Constants.CONFIGURATION_KEY_EXCHANGE_DIRECTORY);
			return;
		}
		// Si le chemin n'est pas d�finit on ouvre une boite de dialogue pour la selection du dossier
		String path = this.chooseExchangeDirectory();
		if(path != null){
			// Si le chemin est bon on le sauvegarde en dur et en m�moire
			properties.setProperty(Constants.CONFIGURATION_KEY_EXCHANGE_DIRECTORY, path);
			PropertiesManager.writeProperties(properties, Constants.CONFIGURATION_FILE);
			initDirectory(path);
		} else {
			JOptionPane.showMessageDialog(null, path + " n'est pas un chemin valide.", "Chemin invalide", JOptionPane.ERROR_MESSAGE);
			mMainView.close();
		}
	}
	
	/**
	 * Ouvre une boite de dialogue pour selectionner le dossier d'�change
	 * @return bool
	 */
	protected String chooseExchangeDirectory(){
		String path = this.chooseDirectory();
		if(path != null && isValideExchangeDirectory(new File(path))){
			return path;
		} else {
			return null;
		}
	}

	/**
	 * Ouvre une boite de dialogue pour selectionner un dossier
	 */
	protected String chooseDirectory(){
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );
		if( fc.showOpenDialog( null ) == JFileChooser.APPROVE_OPTION )
		{
			return fc.getSelectedFile().getAbsolutePath();
		}
		return null;
	}

	/**
	 * Indique si le fichier donn� est valide pour servire de r�pertoire
	 * d'�change
	 * 
	 * @param directory
	 *            , R�pertoire � tester.
	 */
	protected boolean isValideExchangeDirectory(File directory) {
		// Valide si r�pertoire disponible en lecture et �criture
		return directory != null && directory.exists() && directory.isDirectory() && directory.canRead()
				&& directory.canWrite();
	}

	/**
	 * Initialisation du mode bouchon� de l'application
	 */
	protected void initMock() {
		TwitupMock mock = new TwitupMock(this.mDatabase, this.mEntityManager);
		mock.showGUI();
	}

	/**
	 * Initialisation de la base de donn�es
	 */
	protected void initDatabase() {
		mDatabase = new Database();
		mEntityManager = new EntityManager(mDatabase);
	}

	/**
	 * Initialisation du r�pertoire d'�change.
	 * 
	 * @param directoryPath
	 */
	public void initDirectory(String directoryPath) {
		mExchangeDirectoryPath = directoryPath;
		mWatchableDirectory = new WatchableDirectory(directoryPath);
		mEntityManager.setExchangeDirectory(directoryPath);

		mWatchableDirectory.initWatching();
		mWatchableDirectory.addObserver(mEntityManager);
	}

	public void show() {
		mMainView.show();
	}
}

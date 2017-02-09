package com.iup.tp.twitup.core;

import java.io.File;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import com.iup.tp.twitup.common.Constants;
import com.iup.tp.twitup.common.PropertiesManager;
import com.iup.tp.twitup.datamodel.Database;
import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.events.file.IWatchableDirectory;
import com.iup.tp.twitup.events.file.WatchableDirectory;
import com.iup.tp.twitup.ihm.GUI;
import com.iup.tp.twitup.ihm.GUISwing;
import com.iup.tp.twitup.ihm.TwitupMock;
import com.iup.tp.twitup.ihm.account.controller.TwitupAccountController;
import com.iup.tp.twitup.ihm.account.controller.TwitupAccountControllerImpl;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;
import com.iup.tp.twitup.ihm.mainview.controller.TwitupMainViewController;
import com.iup.tp.twitup.ihm.mainview.controller.TwitupMainViewControllerImpl;
import com.iup.tp.twitup.ihm.mainview.view.TwitupMainView;
import com.iup.tp.twitup.ihm.menubar.controller.TwitupMenuBarControllerImpl;
import com.iup.tp.twitup.ihm.menubar.view.TwitupMenuBarView;
import com.iup.tp.twitup.ihm.twit.controller.TwitupTwitController;
import com.iup.tp.twitup.ihm.twit.controller.TwitupTwitControllerImpl;
import com.iup.tp.twitup.ihm.user.TwitupUserController;
import com.iup.tp.twitup.ihm.user.TwitupUserControllerImpl;

/**
 * Classe principale l'application.
 * 
 * @author S.Lucas
 */
public class Twitup {
	/**
	 * Base de données.
	 */
	protected IDatabase mDatabase;

	/**
	 * Gestionnaire des entités contenu de la base de données.
	 */
	protected EntityManager mEntityManager;

	/**
	 * Vue principale de l'application.
	 */
	protected TwitupMainView mMainView;

	/**
	 * Classe de surveillance de répertoire
	 */
	protected IWatchableDirectory mWatchableDirectory;

	/**
	 * Répertoire d'échange de l'application.
	 */
	protected String mExchangeDirectoryPath;

	/**
	 * Indique si le mode bouchoné est activé.
	 */
	protected boolean mIsMockEnabled = true;

	/**
	 * Nom de la classe de l'UI.
	 */
	protected String mUiClassName;
	
	protected User connectedUser;
	
	protected GUI guiSwing;

	/**
	 * Constructeur.
	 */
	public Twitup() {
		// Init du look and feel de l'application
		this.initLookAndFeel();

		// Initialisation de la base de données
		this.initDatabase();

		if (this.mIsMockEnabled) {
			// Initialisation du bouchon de travail
			this.initMock();
		}

		// Initialisation de l'IHM
		this.initGui();

		// Initialisation du répertoire d'échange
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
		
		guiSwing = GUISwing.getInstance(); 
		
		TwitupMainViewController mainViewCtrl = new TwitupMainViewControllerImpl();
		TwitupMenuBarControllerImpl menuBarCtrl = new TwitupMenuBarControllerImpl(guiSwing.getFrame(), (TwitupMenuBarView) guiSwing.getTwitupAccountActionView());
		// On "observe" si le chemin du répertoir d'échange a été modifié
		menuBarCtrl.addActionExchangeFolder(new TwitupWatcher() {
			@Override
			public void action(Object o) {
				chooseExchangeDirectory();
			}
		});
		menuBarCtrl.initView();
		TwitupUserController userCtrl = new TwitupUserControllerImpl(mDatabase, guiSwing.getTwitupUserView());
		TwitupTwitController twitCtrl = new TwitupTwitControllerImpl(mDatabase, guiSwing.getTwitupTwitView());
		TwitupAccountController accountCtrl = new TwitupAccountControllerImpl(mDatabase, guiSwing.getTwitupAccountActionView(), guiSwing.getTwitupLogInView(), null, guiSwing.getTwitupSignupView());
		accountCtrl.addAccountObserver(userCtrl);
		userCtrl.init();
		twitCtrl.init();
		accountCtrl.init();

	}

	/**
	 * Initialisation du répertoire d'échange (depuis la conf ou depuis un file
	 * chooser). <br/>
	 * <b>Le chemin doit obligatoirement avoir été saisi et être valide avant de
	 * pouvoir utiliser l'application</b>
	 */
	protected void initDirectory() {
		// Chargement du fichier de configuration
		Properties properties = PropertiesManager.loadProperties(Constants.CONFIGURATION_FILE);
		// Vérification que le chemin vers le dossier d'échange est fournit dans le fichier de configuration
		if(properties.containsKey(Constants.CONFIGURATION_KEY_EXCHANGE_DIRECTORY)){
			// Chargement du chemin et on quitte
			mExchangeDirectoryPath = properties.getProperty(Constants.CONFIGURATION_KEY_EXCHANGE_DIRECTORY);
			return;
		}
		// Si le chemin n'est pas définit on ouvre une boite de dialogue pour la selection du dossier
		String path = this.chooseExchangeDirectory();
		if(path != null){
			// Si le chemin est bon on le sauvegarde en dur et en mémoire
			properties.setProperty(Constants.CONFIGURATION_KEY_EXCHANGE_DIRECTORY, path);
			PropertiesManager.writeProperties(properties, Constants.CONFIGURATION_FILE);
			initDirectory(path);
		} else {
			JOptionPane.showMessageDialog(null, path + " n'est pas un chemin valide.", "Chemin invalide", JOptionPane.ERROR_MESSAGE);
			mMainView.close();
		}
	}
	
	/**
	 * Ouvre une boite de dialogue pour selectionner le dossier d'échange
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
	 * Indique si le fichier donné est valide pour servire de répertoire
	 * d'échange
	 * 
	 * @param directory
	 *            , Répertoire à tester.
	 */
	protected boolean isValideExchangeDirectory(File directory) {
		// Valide si répertoire disponible en lecture et écriture
		return directory != null && directory.exists() && directory.isDirectory() && directory.canRead()
				&& directory.canWrite();
	}

	/**
	 * Initialisation du mode bouchoné de l'application
	 */
	protected void initMock() {
		TwitupMock mock = new TwitupMock(this.mDatabase, this.mEntityManager);
		mock.showGUI();
	}

	/**
	 * Initialisation de la base de données
	 */
	protected void initDatabase() {
		mDatabase = new Database();
		mEntityManager = new EntityManager(mDatabase);
	}

	/**
	 * Initialisation du répertoire d'échange.
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
		guiSwing.launch();
	}
}

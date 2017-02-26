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
import com.iup.tp.twitup.ihm.GUIFX;
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
	 * Indique si le mode bouchon� est activ�.
	 */
	protected boolean mIsMockEnabled = true;

	/**
	 * Nom de la classe de l'UI.
	 */
	protected String mUiClassName;
	
	protected User connectedUser;
	
	protected GUI guiSwing;
	
	protected GUI guiFX;

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
		
		guiSwing = GUISwing.getInstance();
		guiSwing.setDatabase(mDatabase);
		
		TwitupMainViewController mainViewCtrl = new TwitupMainViewControllerImpl();
		TwitupMenuBarControllerImpl menuBarCtrl = new TwitupMenuBarControllerImpl(guiSwing.getFrame(), (TwitupMenuBarView) guiSwing.getTwitupAccountActionView());
		// On "observe" si le chemin du r�pertoir d'�change a �t� modifi�
		menuBarCtrl.addActionExchangeFolder(new TwitupWatcher() {
			@Override
			public void action(Object o) {
				chooseExchangeDirectory();
			}
		});
		menuBarCtrl.initView();
		TwitupUserController userCtrl = new TwitupUserControllerImpl(mDatabase, guiSwing.getTwitupUserView());
		userCtrl.initView();
		
		// ACCOUNT
		TwitupAccountController accountCtrl = new TwitupAccountControllerImpl(mEntityManager, mDatabase);
		accountCtrl.addAccountObserver(userCtrl);
		accountCtrl.init();
		guiSwing.setAccountCtrl(accountCtrl);
		
		// TWIT
		TwitupTwitController twitCtrl = new TwitupTwitControllerImpl(mEntityManager);
		userCtrl.addUserObserver(twitCtrl);
		guiSwing.setTwitCtrl(twitCtrl);
		guiSwing.setDatabase(mDatabase);
		
		guiFX = GUIFX.getInstance();
		
		
		
		
		

		
		guiFX.setTwitCtrl(twitCtrl);
		guiFX.setDatabase(mDatabase);
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
			String path = properties.getProperty(Constants.CONFIGURATION_KEY_EXCHANGE_DIRECTORY);
			// V�rification que le chemin est valide
			if(isValideExchangeDirectory(new File(path))){
				System.out.println("R�pertoire d'�change :\n" + properties.getProperty(Constants.CONFIGURATION_KEY_EXCHANGE_DIRECTORY));
				// Chargement du chemin et on quitte
				initDirectory(properties.getProperty(Constants.CONFIGURATION_KEY_EXCHANGE_DIRECTORY));
				return;
			}
		}
		// Si le chemin n'est pas d�finit on ouvre une boite de dialogue pour la selection du dossier
		String path = this.chooseExchangeDirectory();
		System.out.println("Nouveau :\n" + path);
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
		guiSwing.launch();
	}
}

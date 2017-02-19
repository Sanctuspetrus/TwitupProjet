package com.iup.tp.twitup.ihm.twit.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.iup.tp.twitup.datamodel.IDatabase;
import com.iup.tp.twitup.datamodel.IDatabaseObserver;
import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.event.TwitupWatchable;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;
import com.sun.javafx.scene.layout.region.Margins;

@SuppressWarnings("serial")
public class TwitupTwitViewImpl extends JPanel implements TwitupTwitView, IDatabaseObserver{

	IDatabase database;
	
	JTextField researchBar;
	JTextArea zoneRedacTwit;
	
	JButton researchButton;
	JButton zoneRedacButton;
	
	Set<Twit> listTwit;
	
	JPanel zoneTwit;
	JPanel zoneNorth;
	JPanel zoneSouth;
	
	protected TwitupWatchable researchWatchable;
	protected TwitupWatchable sendTwitWatchable;
	
	public TwitupTwitViewImpl(){
		
		researchBar = new JTextField();
		zoneRedacTwit = new JTextArea();
		//limite le nombre de caractères écrivibles  à 150
		zoneRedacTwit.setDocument(new TwitLimit(150));
		
		researchButton = new JButton("Rechercher");
		zoneRedacButton = new JButton("TWIT");
		
		zoneNorth = new JPanel();
		zoneNorth.setLayout(new GridLayout(1,2));
		zoneSouth = new JPanel();
		zoneSouth.setLayout(new GridLayout(2,1));
		zoneTwit = new JPanel();
		
		researchWatchable = new TwitupWatchable();
		sendTwitWatchable = new TwitupWatchable();
		
		this.setBackground(Color.BLACK);
		
	}

	@Override
	public void init() {
		
		database.addObserver(this);

		researchButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				researchWatchable.sendEvent();
			}
		});
		
		zoneRedacButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				sendTwitWatchable.sendEvent();
			}
		});
		
		this.setLayout(new BorderLayout());
		
		zoneNorth.add(researchBar);
		zoneNorth.add(researchButton);
		this.add(zoneNorth, BorderLayout.NORTH);
		
		listTwit = database.getTwits();
		
		for (Twit twit : listTwit) {
			zoneTwit.add( new TwitTwitPanel(twit.getText(), twit.getTwiter().getAvatarPath()));
		}
		
		this.add(zoneTwit, BorderLayout.CENTER);	
		
		zoneSouth.add(zoneRedacTwit);
		zoneSouth.add(zoneRedacButton);
		this.add(zoneSouth, BorderLayout.SOUTH);

		
	}

	@Override
	public void show() {
		this.setVisible(true);
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addActionNewTwit(TwitupWatcher tw) {
		sendTwitWatchable.addWatcher(tw);
	}

	@Override
	public void delActionNewTwit(TwitupWatcher tw) {
		sendTwitWatchable.delWatcher(tw);	
	}


	@Override
	public void addActionResearchTwit(TwitupWatcher tw) {
		researchWatchable.addWatcher(tw);
	}

	@Override
	public void delActionResearchTwit(TwitupWatcher tw) {
		researchWatchable.delWatcher(tw);
		
	}
	

	@Override
	public void notifyTwitAdded(Twit addedTwit) {
		zoneTwit.removeAll();
		for (Twit twit : listTwit) {
			zoneTwit.add( new TwitTwitPanel(twit.getText(), twit.getTwiter().getAvatarPath()));
		}
		revalidate();
		repaint();
		
		
	}

	@Override
	public void notifyTwitDeleted(Twit deletedTwit) {
		zoneTwit.removeAll();
		for (Twit twit : listTwit) {
			zoneTwit.add( new TwitTwitPanel(twit.getText(), twit.getTwiter().getAvatarPath()));
		}
		revalidate();
		repaint();
		
		
	}

	@Override
	public void notifyTwitModified(Twit modifiedTwit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyUserAdded(User addedUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyUserDeleted(User deletedUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyUserModified(User modifiedUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getTwitSent() {
		return zoneRedacTwit.getText();
	}
	
	public void setDatabase(IDatabase db){
		database = db;
	}
}

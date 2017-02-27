package com.iup.tp.twitup.ihm.twit.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.iup.tp.twitup.datamodel.Twit;

@SuppressWarnings("serial")
public class TwitupTwitViewImpl extends JPanel implements TwitupTwitView {
	
	JTextField researchBar;
	JTextArea zoneRedacTwit;
	
	JButton researchButton;
	JButton zoneRedacButton;
	
	//Set<Twit> listTwit;
	ArrayList<Twit> listTwit;
	
	JPanel zoneTwit;
	JPanel zoneNorth;
	JPanel zoneSouth;
	
	JScrollPane scroll;
	
	protected ArrayList<TwitViewObserver> listObserver; 
	
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
		
		scroll = new JScrollPane(zoneTwit);
		
		//listTwit = new TreeSet<Twit>();
		
		this.setBackground(Color.BLACK);
		
		listObserver = new ArrayList<TwitViewObserver>();
		
		listTwit = new ArrayList<Twit>();
	}

	@Override
	public void initView() {
		zoneTwit.setLayout(new BoxLayout(zoneTwit, BoxLayout.Y_AXIS));

		researchButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				sendRecherche(researchBar.getText());
			}
		});
		
		zoneRedacButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				sendNewTwit(zoneRedacTwit.getText());
			}
		});
		
		this.setLayout(new BorderLayout());
		
		zoneNorth.add(researchBar);
		zoneNorth.add(researchButton);
		this.add(zoneNorth, BorderLayout.NORTH);
		
		for (Twit twit : listTwit) {
			zoneTwit.add( new VignetteTwit(twit.getText(), twit.getTwiter().getAvatarPath()));
		}
		
		this.add(scroll, BorderLayout.CENTER);	
		
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
	public String getTwitSent() {
		return zoneRedacTwit.getText();
	}

	@Override
	public void addObserver(TwitViewObserver tvo) {
		listObserver.add(tvo);
		reafficherTwits();
	}

	@Override
	public void delObserver(TwitViewObserver tvo) {
		listObserver.remove(tvo);
		reafficherTwits();
	}

	@Override
	public void sendNewTwit(String t) {
		for (TwitViewObserver twitViewObserver : listObserver) {
			twitViewObserver.actionNewTwit(t);
		}
	}

	@Override
	public void sendRecherche(String str) {
		for (TwitViewObserver twitViewObserver : listObserver) {
			twitViewObserver.actionRecherche(str);
		}
	}

	@Override
	public void actionSearchResult(Set<Twit> twits) {
		listTwit.clear();
		listTwit.addAll(twits);
		reafficherTwits();
	}
	
	private void reafficherTwits(){
		zoneTwit.removeAll();
		for (Twit twit : listTwit) {
			zoneTwit.add( new VignetteTwit(twit.getText(), twit.getTwiter().getAvatarPath()));
		}
		revalidate();
		repaint();
	}

	@Override
	public void actionTwitAdded(Set<Twit> twits, Twit twit) {
		System.out.println("La vue a reçu un nouveau twit");
		listTwit.clear();
		listTwit.addAll(twits);
		reafficherTwits();
	}

	@Override
	public void actionTwitDeleted(Set<Twit> twits, Twit twit) {
		System.out.println("La vue a suppr twit");
		listTwit.clear();
		listTwit.addAll(twits);
		reafficherTwits();
	}

	@Override
	public void actionTwitModified(Set<Twit> twits, Twit twit) {
		System.out.println("La vue a modif twit");
		listTwit.clear();
		listTwit.addAll(twits);
		reafficherTwits();
	}

	@Override
	public void actionStartTwits(Set<Twit> twits) {
		System.out.println("Twits de départ");
		listTwit.clear();
		listTwit.addAll(twits);
		reafficherTwits();
	}
	
	
}

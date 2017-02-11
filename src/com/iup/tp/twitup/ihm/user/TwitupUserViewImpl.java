package com.iup.tp.twitup.ihm.user;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.event.TwitupWatchable;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

@SuppressWarnings("serial")
public class TwitupUserViewImpl extends JPanel implements TwitupUserView {
	
	
	JTextField researchBar;
	JButton researchButton;
	Set<User> listUserAbo;
	Set<User> listUserResearch;
	
	JList<VignetteAbonnesModif> zoneAbonnes;
	
	TwitupWatchable supprWatchable;
	TwitupWatchable researchWatchable;
	TwitupWatchable addAboWatchable;
	
	JPanel north;
	
	public TwitupUserViewImpl(){
		
		north = new JPanel();
		
		researchBar = new JTextField("rechercher");
		researchButton = new JButton("RECHERCHER");
		
		supprWatchable = new TwitupWatchable();
		researchWatchable = new TwitupWatchable();
		
		zoneAbonnes = new JList<VignetteAbonnesModif>();
		
	}
	
	@Override
	public void init() {

		this.setLayout(new BorderLayout());
		
		north.add(researchBar);
		north.add(researchButton);
		
		this.add(north, BorderLayout.NORTH);
		
		showUserAbonnes();

		this.add(zoneAbonnes, BorderLayout.CENTER);
		
	}

	private void showUserAbonnes() {
		zoneAbonnes.removeAll();
		for (User user : listUserAbo) {
			
			JButton supprButton = new JButton("X");
			supprButton.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						supprWatchable.sendEvent(user);
					}
			});
			zoneAbonnes.add(new VignetteAbonnesModif(new VignetteAbonnes(user), supprButton));
		}
	}
	
	private void showUserResearched() {
		zoneAbonnes.removeAll();
		for (User user : listUserResearch) {
			
			JButton addButton = new JButton("add");
			addButton.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						addAboWatchable.sendEvent(user);
					}
			});
			zoneAbonnes.add(new VignetteAbonnesModif(new VignetteAbonnes(user), addButton));
		}
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
	public void setListUserAbonnes(Set<User> listUserAbo) {
		this.listUserAbo = listUserAbo;
		showUserAbonnes();
		this.revalidate();
		this.repaint();
	}
	
	@Override
	public void setListResearched(Set<User> listUserRech) {
		this.listUserResearch = listUserRech;
		showUserResearched();
		this.revalidate();
		this.repaint();
	}

	@Override
	public void addActionResearch(TwitupWatcher tw) {
		researchWatchable.addWatcher(tw);
	}

	@Override
	public void delActionResearch(TwitupWatcher tw) {
		researchWatchable.delWatcher(tw);
	}

	@Override
	public void addActionSuppr(TwitupWatcher tw) {
		supprWatchable.addWatcher(tw);
	}

	@Override
	public void delActionSuppr(TwitupWatcher tw) {
		supprWatchable.delWatcher(tw);
	}

	@Override
	public void addActionAddAbo(TwitupWatcher tw) {
		addAboWatchable.addWatcher(tw);
	}

	@Override
	public void delActionAddAbo(TwitupWatcher tw) {
		addAboWatchable.delWatcher(tw);
	}

}

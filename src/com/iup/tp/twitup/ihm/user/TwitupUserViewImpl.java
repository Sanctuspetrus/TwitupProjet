package com.iup.tp.twitup.ihm.user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.iup.tp.twitup.datamodel.User;

@SuppressWarnings("serial")
public class TwitupUserViewImpl extends JPanel implements TwitupUserView {
	
	
	JTextField researchBar;
	JButton researchButton;
	Set<User> listUserAbo;
	Set<User> listUserResearch;
	
	JPanel zoneAbonnes;
	JScrollPane scroll;
	
	ArrayList<ListUserViewObserver> obs = new ArrayList<ListUserViewObserver>();
	
	JPanel north;
	
	public TwitupUserViewImpl(){
		
		north = new JPanel();
		
		researchBar = new JTextField("rechercher");
		researchButton = new JButton("RECHERCHER");
		
		zoneAbonnes = new JPanel();
		scroll = new JScrollPane(zoneAbonnes);
		
		listUserAbo = new TreeSet<User>();
		listUserResearch = new TreeSet<User>();

		this.setBackground(Color.GREEN);
		
	}
	
	@Override
	public void initView() {

		this.setLayout(new BorderLayout());
		zoneAbonnes.setLayout(new BoxLayout(zoneAbonnes, BoxLayout.Y_AXIS));
		
		north.add(researchBar);
		north.add(researchButton);
		
		researchButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				notifySearchUser(researchBar.getText());
			}
		});
		
		this.add(north, BorderLayout.NORTH);
		
		showUserAbonnes();

		this.add(scroll, BorderLayout.CENTER);
		
	}

	private void showUserAbonnes() {
		zoneAbonnes.removeAll();
		for (User user : listUserAbo) {
			
			JButton supprButton = new JButton("X");
			supprButton.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
					//	supprWatchable.sendEvent(user);
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
					//	addAboWatchable.sendEvent(user);
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
	public void addListUserViewObserver(ListUserViewObserver luvo) {
		obs.add(luvo);
	}

	@Override
	public void delListUserViewObserver(ListUserViewObserver luvo) {
		obs.remove(luvo);
	}

	@Override
	public void notifySearchUser(String str) {
		for (ListUserViewObserver userObser : obs) {
			userObser.actionSearchUser(str);
		}
	}

	@Override
	public void notifySelectUser(User u) {
		for (ListUserViewObserver userObser : obs) {
			userObser.actionSelectUser(u);
		}
	}

	@Override
	public void actionUserChange(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionNewFollower(User f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionLostFollower(User f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionFollowUser(User f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionUnfollowUser(User f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionSearchUser(Set<User> searchResult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionProfilChange(User u) {
		// TODO Auto-generated method stub
		
	}

}

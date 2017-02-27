package com.iup.tp.twitup.ihm.user.view;

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
import com.iup.tp.twitup.ihm.user.observer.FollowersViewObserver;
import com.iup.tp.twitup.ihm.user.observer.ListUserViewObserver;

@SuppressWarnings("serial")
public class TwitupFollowerViewImpl extends JPanel implements TwitupFollowerView{
	
	JTextField researchBar;
	JButton researchButton;
	Set<User> listFollowers;
	Set<User> listFollowersResearch;
	
	JPanel zoneAbonnes;
	JScrollPane scroll;
	
	ArrayList<FollowersViewObserver> obs = new ArrayList<FollowersViewObserver>();
	
	JPanel north;
	
	public TwitupFollowerViewImpl(){
		
		north = new JPanel();
		
		researchBar = new JTextField("rechercher");
		researchButton = new JButton("RECHERCHER");
		
		zoneAbonnes = new JPanel();
		scroll = new JScrollPane(zoneAbonnes);
		
		listFollowers = new TreeSet<User>();
		listFollowersResearch = new TreeSet<User>();

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
		for (User user : listFollowers) {
			
			JButton supprButton = new JButton("X");
			supprButton.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						notifyUnfollowFollower(user);
					}
			});
			zoneAbonnes.add(new VignetteAbonnesModif(new VignetteAbonnes(user), supprButton));
		}
		this.revalidate();
		this.repaint();
	}
	
	private void showUserResearched() {
		zoneAbonnes.removeAll();
		
		for (User user : listFollowersResearch) {
			
			JButton addButton = new JButton("add");
			addButton.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						notifyUnfollowFollower(user);
					}
			});
			zoneAbonnes.add(new VignetteAbonnesModif(new VignetteAbonnes(user), addButton));
		}
		this.revalidate();
		this.repaint();
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
	public void actionNewFollower(User f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionLostFollower(User f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionUnfollowUser(User f) {
		listFollowers.add(f);
		showUserAbonnes();
	}

	@Override
	public void notifySearchFollower(String str) {
		for (FollowersViewObserver userObser : obs) {
			userObser.ac(str);
		}
	}

	@Override
	public void notifySelectFollower(User u) {
		for (FollowersViewObserver userObser : obs) {
			userObser.actionSearchUser(str);
		}
	}

	@Override
	public void notifyFollowFollower(User u) {
		for (FollowersViewObserver userObser : obs) {
			userObser.actionFollowUser(u);
		}
	}

	@Override
	public void setListFollowerAbonnes(Set<User> listUser) {
		listFollowers = listUser;
		showUserAbonnes();
	}

	@Override
	public void setListFollowerResearched(Set<User> listUser) {
		listFollowersResearch = listUser;
		showUserResearched();
	}

	@Override
	public void addFollowersViewOberserver(FollowersViewObserver luvo) {
		obs.add(luvo);
	}

	@Override
	public void delFollowersViewOberserver(FollowersViewObserver luvo) {
		obs.remove(luvo);
	}

	@Override
	public void notifyUnfollowFollower(User u) {
		for (FollowersViewObserver userObser : obs) {
			userObser.actionUnfollowUser(u);
		}
	}

}

package com.iup.tp.twitup.ihm.user;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.iup.tp.twitup.datamodel.Twit;
import com.iup.tp.twitup.datamodel.User;
import com.iup.tp.twitup.ihm.event.TwitupWatchable;

@SuppressWarnings("serial")
public class TwitupUserViewImpl extends JPanel implements TwitupUserView {
	
	
	JTextArea researchBar;
	JButton researchButton;
	Set<User> listUser;
	
	JPanel zoneAbonnes;
	
	TwitupWatchable supprWatchable;
	TwitupWatchable researchWatchable;
	
	
	public TwitupUserViewImpl(){
		
		researchBar = new JTextArea();
		researchButton = new JButton("RECHERCHER");
		
		zoneAbonnes = new JPanel();
		
		supprWatchable = new TwitupWatchable();
		researchWatchable = new TwitupWatchable();
		
	}
	
	@Override
	public void init() {

		zoneAbonnes.setLayout(new BoxLayout(zoneAbonnes, BoxLayout.Y_AXIS));
		
		this.setLayout(new BorderLayout());
		
		this.add(researchBar, BorderLayout.NORTH);
		this.add(researchButton, BorderLayout.NORTH);
		
		zoneAbonnes.setLayout(new BoxLayout(zoneAbonnes, BoxLayout.Y_AXIS));
		
		
		
		
		for (User user : listUser) {
			
			zoneAbonnes.add(new VignetteAbonnes(user));
			
			/*JPanel temp = new JPanel();
			JButton supprButton = new JButton("suppr");
			supprButton.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						supprWatchable.sendEvent(user);
					}
			});
			
			pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));*/
			
		}
		
		
		
		
		this.add(zoneAbonnes);
		
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
	public void setListUser(Set<User> listUser) {
		this.listUser = listUser;
	}

}

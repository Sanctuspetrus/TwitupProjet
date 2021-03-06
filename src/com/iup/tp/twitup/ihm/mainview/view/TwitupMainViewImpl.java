package com.iup.tp.twitup.ihm.mainview.view;


import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.iup.tp.twitup.ihm.TwitupView;
import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;
import com.iup.tp.twitup.ihm.user.view.TwitupUserView;

/**
 * Classe de la vue principale de l'application.
 */
public class TwitupMainViewImpl implements TwitupMainView{

	protected JFrame frame;
	protected JPanel mainPanel;

	public TwitupMainViewImpl(JFrame f){
		frame = f;
		mainPanel = new JPanel();
	}

	public void show(){
		frame.setVisible(true);
		frame.repaint();
	}
	
	public void close(){
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(TwitupUserView userView, TwitupTwitView twitView) {
		// TODO Auto-generated method stub
		
	}
	

}

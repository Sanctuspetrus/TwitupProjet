package com.iup.tp.twitup.ihm.mainview.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.iup.tp.twitup.ihm.twit.view.TwitupTwitView;
import com.iup.tp.twitup.ihm.user.TwitupUserView;

/**
 * Classe de la vue principale de l'application.
 */
@SuppressWarnings("serial")
public class TwitupMainViewImpl2 extends JPanel implements TwitupMainView{
	protected JFrame frame;
	protected JPanel mainPanel;

	public TwitupMainViewImpl2(JFrame f){
		frame = f;
		this.setLayout(new BorderLayout());
		this.setBackground(Color.RED);
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
		this.add((Component) userView, BorderLayout.WEST);
		this.add((Component) twitView, BorderLayout.CENTER);
	}
}

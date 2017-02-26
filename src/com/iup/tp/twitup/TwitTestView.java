package com.iup.tp.twitup;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.iup.tp.twitup.ihm.account.view.TwitupLogInViewImpl;

public class TwitTestView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame f = new JFrame();
		
		f.setTitle("Twitup");
		ImageIcon img = new ImageIcon("/TwitUp/src/resources/images/logoIUP_20.jpg");

		f.setPreferredSize(new Dimension(400, 400));
		f.setIconImage(img.getImage());
		f.pack();

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
		
		TwitupLogInViewImpl vue = new TwitupLogInViewImpl();
		
		f.add(vue);
		
		vue.initView();
		
		f.revalidate();
		f.repaint();
		

	}

}

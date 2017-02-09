package com.iup.tp.twitup.ihm;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class TwitupFrame extends JFrame {
	protected JFrame my;

	public TwitupFrame(){
		my = this;
		this.setTitle("Twitup");
		ImageIcon img = new ImageIcon("/TwitUp/src/resources/images/logoIUP_20.jpg");

		this.setPreferredSize(new Dimension(400, 400));
		this.setIconImage(img.getImage());
		this.pack();

		my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

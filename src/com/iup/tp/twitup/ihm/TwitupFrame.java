package com.iup.tp.twitup.ihm;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
//		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//		this.addWindowListener( new WindowAdapter()
//		{
//			public void windowClosing(WindowEvent e)
//			{
//				int result = JOptionPane.showConfirmDialog(
//						null,
//						"Are you sure you want to exit the application?",
//						"Exit Application",
//						JOptionPane.YES_NO_OPTION);
//
//				if (result == JOptionPane.YES_OPTION)
//					my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			}
//		});
	}
}

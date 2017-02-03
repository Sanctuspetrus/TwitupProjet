package com.iup.tp.twitup.ihm.menubar;

import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.iup.tp.twitup.ihm.event.TwitupWatchable;
import com.iup.tp.twitup.ihm.event.TwitupWatcher;

public class TwitupMenuBarControllerImpl implements TwitupMenuBarController{

	protected JFrame frame;
	protected TwitupMenuBarView menuBarView;

	protected final TwitupWatchable changeExchangeFolder = new TwitupWatchable();

	public TwitupMenuBarControllerImpl(JFrame f, TwitupMenuBarView mbv){
		frame = f;
		menuBarView = mbv;
	}
	
	public void initView(){
		menuBarView.addActionClose(close());
		menuBarView.addActionAbout(about());
		menuBarView.addActionModifyExchangeFolder(modifyExhangeFolder());
		menuBarView.show();
	}

	protected TwitupWatcher close(){
		return new TwitupWatcher() {
			@Override
			public void action(Object o) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		};
	}

	protected TwitupWatcher about(){
		return new TwitupWatcher() {
			@Override
			public void action(Object o) {
				JOptionPane.showMessageDialog(frame,"UBO M2-TIIL\nDépartement Informatique", "A propos", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/resources/images/logoIUP_50.jpg"));
			}
		};	
	}

	protected TwitupWatcher modifyExhangeFolder(){
		return new TwitupWatcher() {
			@Override
			public void action(Object o) {
				changeExchangeFolder.sendEvent();
			}
		};
	}

	@Override
	public void addActionExchangeFolder(TwitupWatcher tw) {
		changeExchangeFolder.addWatcher(tw);
	}

	@Override
	public void delActionExchangeFolder(TwitupWatcher tw) {
		changeExchangeFolder.delWatcher(tw);
	}



}

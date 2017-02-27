package com.iup.tp.twitup.ihm.menubar.controller;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TwitupMenuBarControllerImpl implements TwitupMenuBarController{

	protected ArrayList<MenuBarObserver> listMBO = new ArrayList<MenuBarObserver>();

	public TwitupMenuBarControllerImpl(){
	}

	@Override
	public void addMenuBarObserver(MenuBarObserver mbo) {
		listMBO.add(mbo);
	}

	@Override
	public void delMenuBarObserver(MenuBarObserver mbo) {
		listMBO.remove(mbo);
	}

	@Override
	public void notifyExchangeFolder() {
		for (MenuBarObserver menuBarObserver : listMBO) {
			menuBarObserver.actionExchangeFolder();
		}
	}

	@Override
	public void notifyClose() {
		for (MenuBarObserver menuBarObserver : listMBO) {
			menuBarObserver.actionClose();
		}
	}

	@Override
	public void actionCloseButton() {
		notifyClose();
	}

	@Override
	public void actionAboutButton() {
		JOptionPane.showMessageDialog(null,"UBO M2-TIIL\nDépartement Informatique", "A propos", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/resources/images/logoIUP_50.jpg"));
	}

	@Override
	public void actionModifyExchangeFolderButton() {
		notifyExchangeFolder();
	}



}

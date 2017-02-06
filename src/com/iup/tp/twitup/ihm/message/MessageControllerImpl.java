package com.iup.tp.twitup.ihm.message;

import java.util.ArrayList;

import com.iup.tp.twitup.datamodel.Twit;

public class MessageControllerImpl {
	
	
	protected ArrayList<Twit> listTwit = new ArrayList<Twit>();
	
	//observateurs du controller
	protected ArrayList<MessageView> messageView = new ArrayList<MessageView>();
	
	
	MessageControllerImpl(ArrayList<Twit> listTwit){
		this.listTwit = listTwit;
	}
	
	
	
	
	

	public void addAbonne(MessageView abo){
		messageView.add(abo);
	}

	public ArrayList<Twit> getListTwit() {
		return listTwit;
	}

	public void setListTwit(ArrayList<Twit> listTwit) {
		this.listTwit = listTwit;
		notifyListTwitChanged();
	}
	
	public void addTwit(Twit t){
		listTwit.add(t);
		notifyListTwitChanged();
	}
	
	public void removeTwit(Twit t){
		listTwit.remove(t);
		notifyListTwitChanged();
	}
	
	//notification aux views que la liste a été modifiée
	private void notifyListTwitChanged(){
		for (MessageView view : messageView) {
			//TODO
		}
	}
	

}

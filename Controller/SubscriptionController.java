package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import Gui.RenterListingView;
import Model.Listing;
import Model.RegisteredRenter;

public class SubscriptionController {
	
	Listing listingModel;
	RegisteredRenter registeredRenter;
	RenterListingView listingView;
	
	DBConnect db = new DBConnect();
	
	public SubscriptionController (RegisteredRenter r, RenterListingView v, Listing l) {
		this.registeredRenter= r;
		this.listingView = v;
		this.listingModel = l;
		
		listingView.setRole("RegisteredRenter");
		checkNotifications();
		listingView.draw();
		
		listingView.searchButton(new search());
		listingView.subscribeButton(new subscribe());
		listingView.returnMessage(new sendMessage());
		listingView.notifyBtn(new notificationBtn());
	}
	
	public class search implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("button pressed");
			ArrayList<Listing> temp = new ArrayList<Listing>();
			
			try {
				temp = listingModel.filterListings(db.getListing(), listingView.getPropertyType(),
													listingView.getBedrooms(), listingView.getBathrooms(),
													listingView.getFurnished(), listingView.getQuadrant());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			listingView.setOutput(temp);
		}
	}
	
	public class subscribe implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			db.saveSearch(registeredRenter.getEmail(), listingView.getPropertyType(), listingView.getBedrooms(),
						listingView.getBathrooms(), listingView.getFurnished(), listingView.getQuadrant());
		}
	}
	
	public class notificationBtn implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			listingView.setNotify(false);
			listingView.draw();
		}
	}
	
	public class sendMessage implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("SC- send message pressed");
			String email =listingModel.landLordIdFromListing(db.getAllListings(), listingView.getPropertyID());
			db.saveMessages(email, listingView.getMessage(), listingView.getPropertyID());
		}
	}
	
	public void checkNotifications() {
		
		ArrayList<String> notifications = new ArrayList<String>();
		try {
			notifications =db.getAllsubscribedSearches();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("checking notifications");
		if(notifications.size() != 0) {
			for (int i=0; i< notifications.size(); i++) {
				String temp [] = notifications.get(i).split("\n");
				System.out.println(temp[6]+", "+ temp[7]);
				if(temp[6].equals("Y")  && temp[7].equals(registeredRenter.getEmail())){
					listingView.setNotify(true);
					db.updatenotify(Integer.valueOf(temp[0]), "N");
				}
			}
		}
	}
}

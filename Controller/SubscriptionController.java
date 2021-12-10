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
		listingView.draw();
		
		listingView.searchButton(new search());
		listingView.subscribeButton(new subscribe());
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
}

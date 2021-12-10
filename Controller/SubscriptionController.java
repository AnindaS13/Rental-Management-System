package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gui.RenterListingView;
import Model.RegisteredRenter;

public class SubscriptionController {
	RegisteredRenter registeredRenter;
	RenterListingView listingView;
	
	
	public SubscriptionController (RegisteredRenter r, RenterListingView v) {
		this.registeredRenter= r;
		this.listingView = v;
		listingView.setRole("RegisteredRenter");
		listingView.draw();
		
		listingView.searchButton(new search());
		listingView.subscribeButton(new subscribe());
	}
	
	public class search implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public class subscribe implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}

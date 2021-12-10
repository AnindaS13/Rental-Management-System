package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import Controller.SubscriptionController.sendMessage;
import Gui.RenterListingView;
import Model.Listing;


public class ListingController extends ParentController {
	
	Listing listingModel;
	RenterListingView listingView;
	DBConnect db = new DBConnect();
	
	public ListingController(Listing model, RenterListingView view) {
		this.listingModel = model;
		this.listingView = view;
		this.listingView.draw();
		listingView.searchButton(new ButtonListener());	
		listingView.returnMessage(new sendMessage());
	}
	
	public void connectDB() {
		db.initializeConnection();
	}
	
	@Override
	public void switchView(String view) {
		super.switchView(view);
	}
	
	public class ButtonListener implements ActionListener{

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
//			switchView("login");
			
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
	
//	public static void main(String[] args) {
//	System.out.println("Listing controller");
//    RenterListingView u = new RenterListingView();
//    Listing model = new Listing();
//    ListingController controller = new ListingController (model, u);
//    controller.connectDB();
//    
// //   u.setVisible(true);
//	}
}


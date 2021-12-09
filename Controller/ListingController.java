package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import Gui.RenterListingView;
import Model.Listing;


public class ListingController extends ParentController {
	
	Listing listingModel;
	RenterListingView listingView;
	DBConnect db = new DBConnect();
	
	public ListingController(Listing model, RenterListingView view) {
		this.listingModel = model;
		this.listingView = view;
		
		listingView.searchButton(new ButtonListener());	
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
	
	public static void main(String[] args) {
	System.out.println("Listing controller");
    RenterListingView u = new RenterListingView();
    Listing model = new Listing();
    ListingController controller = new ListingController (model, u);
    controller.connectDB();
    
 //   u.setVisible(true);
	}
}


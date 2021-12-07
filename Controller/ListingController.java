package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			
			listingView.setOutput(db.getListing());
//			System.out.println("button pressed");
//			switchView("login");
			
		}
	}
	
	
//	public static void main(String[] args) {
//	System.out.println("Main");
//    RenterListingView u = new RenterListingView();
//    Listing model = new Listing();
//    ListingController controller = new ListingController (model, u);
//    controller.connectDB();
//    
// //   u.setVisible(true);
//	}
}


package Controller;

import Gui.RenterListingView;
import Model.Listing;

public class ParentController {
	
	public void switchView (String view) {
		switch(view) {
		
		case "login": 
				System.out.println("login screen view");
				 RenterListingView u1 = new RenterListingView();
				 Listing model1 = new Listing();
				 ListingController controller = new ListingController (model1, u1);
				//controller for login
				break;
				
		case "listing":
				System.out.println("listing screen view");
				//controller
				break;
		}
	}
}

package Controller;

import Gui.RegisterPropertyView;
import Gui.RenterListingView;
import Model.Landlord;
import Model.Listing;
import Model.Manager;

public class ParentController {
	
	public void switchView (String view) {
		switch(view) {
		
		case "login": 
				System.out.println("login screen view");
//				 RenterListingView u1 = new RenterListingView();
//				 Listing model1 = new Listing();
//				 ListingController controller = new ListingController (model1, u1);
				//controller for login
				break;
				
		case "listing":
				System.out.println("listing screen view");
			    RenterListingView u = new RenterListingView();
			    Listing model = new Listing();
			    ListingController controller = new ListingController (model, u);
			    controller.connectDB();
				break;
				
		case "register":
				System.out.println("listing screen view");
				Manager m = new Manager();
				Landlord l = new Landlord(); 
				RegisterPropertyView r = new RegisterPropertyView();
				RegisterPropertyController c = new RegisterPropertyController(l, m, r);
				break;
		}
	}
}

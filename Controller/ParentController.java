package Controller;

import Gui.EditListStatusLandlordView;
import Gui.EditStatusManagerView;
import Gui.LoginView;
import Gui.ReadMessageView;
import Gui.RegisterPropertyView;
import Gui.RenterListingView;
import Model.Landlord;
import Model.Listing;
import Model.Manager;
import Model.RegisteredRenter;
import Model.User;

public class ParentController {
	
	protected Landlord landlord = new Landlord();//to store email when landlord, registered renter or manager login
	protected Manager manager = new Manager();
	protected RegisteredRenter Rrenter = new RegisteredRenter();
	
	public ParentController() {
		
	}
	
	public ParentController(Landlord l, Manager m, RegisteredRenter r ) {
		this.landlord = l;
		this.manager = m;
		this.Rrenter =r;
	}
	
	public void switchView (String view) {
		switch(view) {
		
		case "login": 
				System.out.println("P- In login");
				 LoginView login = new LoginView();
				 User user = new User();
				 LoginController Lcontrol= new LoginController (user, login);
				//controller for login
				break;
				
		case "RegisterProperty":
				System.out.println("P- In Register Property");
				EditListStatusLandlordView landlordEdit= new EditListStatusLandlordView();
			    EditStatusManagerView managerEdit= new EditStatusManagerView ();
			    RegisterPropertyView r = new RegisterPropertyView();
			    Listing model = new Listing();
			    RegisterPropertyController controller = new RegisterPropertyController (landlord, manager, landlordEdit, managerEdit, r);
			    controller.setView(true, false);
				break;
		
		case "landlordListings":
				System.out.println("P- In Register Property");
				EditListStatusLandlordView landlordEdit2= new EditListStatusLandlordView();
			    EditStatusManagerView managerEdit2= new EditStatusManagerView ();
			    RegisterPropertyView r2 = new RegisterPropertyView();
			    Listing model2 = new Listing();
			    RegisterPropertyController controller2 = new RegisterPropertyController (landlord, manager, landlordEdit2, managerEdit2, r2);
			    controller2.setView(false,true);
				break;
			
		case "LandlordMessages":
				ReadMessageView msg = new ReadMessageView();
				System.out.println("P- passing landlord with email "+ landlord.getEmail());
				ContactController c2 = new ContactController(landlord, msg);
				break;
		
//		case "landlordListing":
//				System.out.println("listing screen view");
//			    EditListStatusLandlordView landlordEdit= new EditListStatusLandlordView();
//			    EditStatusManagerView managerEdit= new EditStatusManagerView ();
//			    RegisterPropertyView r2 = new RegisterPropertyView();
//			    Listing model = new Listing();
//			    RegisterPropertyController controller = new RegisterPropertyController (landlord, manager, landlordEdit, managerEdit, r2);
////			    controller.connectDB();
//				break;
				
		case "listing":
//				System.out.println("listing screen view");
//			    RenterListingView u = new RenterListingView();
//			    Listing model = new Listing();
//			    ListingController controller = new ListingController (model, u);
//			    controller.connectDB();
				break;
								
		}
	}
	
	public void setLandlord(String role, String email, String password) {
		landlord.setEmail(email);
		landlord.setPassword(password);
		landlord.setRole(role);
		System.out.println("setting user email to: "+ email);
	}
	
//	public void setUserRole(String username, String role) {
//		this.userEmail = username;
//		this.role = role;
//	}
//	
//	public void setRole(String role) {
//		this.role = role;
//	}
	
    public static void main(String[] args) {
    	Landlord landlord = new Landlord();
    	Manager manager = new Manager();
    	RegisteredRenter rRenter = new RegisteredRenter();
    	ParentController parent = new ParentController(landlord, manager, rRenter);
        parent.switchView("login");
    }
}

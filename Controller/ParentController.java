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

	private ContactController contactC;
    private RegisterPropertyController registerPropC;
	private SummaryReportController summaryRepC;
	private ListingController listingC;
	
	
	
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
				 LoginView login = new LoginView();
				 User user = new User();
				 LoginController loginC= new LoginController (user, login);
				//controller for login
				break;
				
//************************** Landlord cases **********************************	
		case "RegisterProperty":
				EditListStatusLandlordView landlordEdit= new EditListStatusLandlordView();
			    EditStatusManagerView managerEdit= new EditStatusManagerView ();
			    RegisterPropertyView r = new RegisterPropertyView();
			    Listing model = new Listing();
			    registerPropC = new RegisterPropertyController (landlord, manager, landlordEdit, managerEdit, r);
			    registerPropC.setView(true, false, false);
				break;
		
		case "landlordListings":
				EditListStatusLandlordView landlordEdit2= new EditListStatusLandlordView();
			    EditStatusManagerView managerEdit2= new EditStatusManagerView ();
			    RegisterPropertyView r2 = new RegisterPropertyView();
			    Listing model2 = new Listing();
			    registerPropC = new RegisterPropertyController (landlord, manager, landlordEdit2, managerEdit2, r2);
			    registerPropC.setView(false, true, false);
				break;
			
		case "LandlordMessages":
				ReadMessageView msg = new ReadMessageView();
				System.out.println("P- passing landlord with email "+ landlord.getEmail());
				contactC = new ContactController(landlord, msg);
				break;	
				
//************************** Manager cases **********************************	
		case "ManagerEditView":
				EditListStatusLandlordView landlordEdit3= new EditListStatusLandlordView();
			    EditStatusManagerView managerEdit3= new EditStatusManagerView ();
			    RegisterPropertyView r3 = new RegisterPropertyView();
			    Listing model3 = new Listing();
			    registerPropC = new RegisterPropertyController (landlord, manager, landlordEdit3, managerEdit3, r3);
			    registerPropC.setView(false, false, true);
				break;
				
		}
	}
	
	public void setLandlord(String role, String email, String password) {
		landlord.setEmail(email);
		landlord.setPassword(password);
		landlord.setRole(role);
		System.out.println("setting user email to: "+ email);
	}
	
    public static void main(String[] args) {
    	Landlord landlord = new Landlord();
    	Manager manager = new Manager();
    	RegisteredRenter rRenter = new RegisteredRenter();
    	ParentController parent = new ParentController(landlord, manager, rRenter);
        parent.switchView("login");
    }
}

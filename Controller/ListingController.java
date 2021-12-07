package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Gui.RenterListingView;
import Model.Listing;


public class ListingController extends ParentController {
	
	Listing listingModel;
	RenterListingView listingView;
	
	public ListingController(Listing model, RenterListingView view) {
		this.listingModel = model;
		this.listingView = view;
		
		listingView.returnButton(new ButtonListener());	
		}
	
	@Override
	public void switchView(String view) {
		super.switchView(view);
	}
	
	public class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("button pressed");
			switchView("login");
		}
	}
	
	public String data () {
		
		return "";
	}
	
	public static void main(String[] args) {
	System.out.println("Main");
    RenterListingView u = new RenterListingView();
    Listing model = new Listing();
    ListingController controller = new ListingController (model, u);
 //   u.setVisible(true);
	}
}


package Controller;

// import Gui.SummaryReportView;
import Gui.EditStatusManagerView;
import Gui.SummaryReportView;
import Model.Listing;
import Model.User;

import Model.Landlord;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;


public class SummaryReportController extends ParentController{

    Listing listigModel;
    User userModel;

    ArrayList<User> landlords = new ArrayList<>();
    ArrayList<ArrayList<Listing>> listings = new ArrayList<>();

    SummaryReportView reportView = new SummaryReportView(listings, landlords);

    DBConnect db = new DBConnect();


    public SummaryReportController(Listing listingmodel, User usermodel, SummaryReportView view)
    {
        this.listigModel = listingmodel;
        this.userModel = usermodel;

        this.reportView = view;
        reportView.SummaryReportPerformed(new ReportButtonListener());
    }


    public void connectDB() {
        db.initializeConnection();
    }

    @Override
    public void switchView(String view)
    {
        super.switchView(view);
    }

    public class ReportButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Summary Report button pressed");


            int totalListing = listigModel.totalListings(db.getAllListings());
            System.out.println("Total Listings: " + totalListing);
            reportView.setNumHousesListedField(totalListing);

            int houseRented = listigModel.housesRented(db.getAllListings());
            reportView.setNumHousesRentedField(houseRented);
            System.out.println("Total Houses Rented: " + houseRented);

            int houseActive = listigModel.housesActive(db.getAllListings());
            reportView.setNumActiveListingsField(houseActive);
            System.out.println("Total Houses Active: " + houseActive);

            // landlord and listing arraylists
            ArrayList<User> landlords = userModel.getLandlords(db.getUsers());
            System.out.println("User length: " + landlords.size());

            ArrayList<ArrayList<Listing>> listings = listigModel.getLandlordListings(landlords, db.getAllListings());
            reportView.setLandlords(landlords);
            reportView.setListings(listings);
            System.out.println("Listing length: " + listings.size());
            System.out.println("First Index length: " + listings.get(0).get(1).getID());


            reportView.setTable(listings, landlords);


            // switchView("login"); // need to set this later after parent controller is fixed
        }
    }


    public static void main(String[] args)
    {
        System.out.println("Summary Report controller");
        Listing list= new Listing();
        User user = new User();
        ArrayList<ArrayList<Listing>> listings = new ArrayList<>();
        ArrayList<User> u = new ArrayList<>();
        SummaryReportView reportview = new SummaryReportView(listings, u);

        SummaryReportController controller = new SummaryReportController (list, user, reportview);
        controller.connectDB();


//



    }


}


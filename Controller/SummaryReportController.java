package Controller;

// import Gui.SummaryReportView;
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
    // SummaryReportView reportView;
    DBConnect db;


    public SummaryReportController(Listing listingmodel, User usermodel) // SummaryReportView view)
    {
        this.listigModel = listingmodel;
        this.userModel = usermodel;

        // this.reportView = view;
        // reportView.SummaryReportButton(new ReportButtonListener());
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
            System.out.println(" Summary Report button pressed");

            try {
                int totalListing = listigModel.totalListings(db.getListing());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            try {
                int houseRented = listigModel.housesRented(db.getListing());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            ArrayList<User> landlords = userModel.getLandlords(db.getUsers());
            try {
                ArrayList<ArrayList<Listing>> listings = listigModel.getLandlordListings(landlords, db.getListing());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            // view.setTotalListed(totalListing);
            // view.setHouseRented(houseRented);
            // view.setLandlord(landlords);
            // view.setListings(listings);

            // switchView("login"); // need to set this later after parent controller is fixed
        }
    }


    public static void main(String[] args)
    {
        System.out.println("Summary Report controller");
        Listing list= new Listing();
        User user = new User();

//        SummaryReportController controller = new SummaryReportController (list, user);
//        controller.connectDB();
//
//        try {
//            int totalListing = list.totalListings(controller.db.getListing());
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        try {
//            int houseRented = list.housesRented(controller.db.getListing());
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        ArrayList<User> landlords = user.getLandlords(controller.db.getUsers());
//        try {
//            ArrayList<ArrayList<Listing>> listings = list.getLandlordListings(landlords, controller.db.getListing());
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }



        // SummaryReportView view = new SummaryReportView();



    }


}


package Controller;

import Gui.DisplayUsersManagerView;
// import Gui.SummaryReportView;
import Gui.EditFeesView;
import Gui.EditStatusManagerView;
import Gui.SummaryReportView;
import Model.Listing;
import Model.Manager;
import Model.User;
import java.util.*;

import Model.Landlord;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

//controller to get summary report and all users (landlords and registered renter)
// it has two views one for summary view and other one to display users.

public class SummaryReportController extends ParentController{

    Listing listigModel;
    Manager manager;
    SummaryReportView reportView;
    DisplayUsersManagerView allUsers;
    DBConnect db = new DBConnect();

//constructor to initialize model and views
    public SummaryReportController(Listing listingmodel, Manager manager, SummaryReportView view, DisplayUsersManagerView view2)
    {
        this.listigModel = listingmodel;
        this.manager = manager;
        this.allUsers = view2;
        this.reportView = view;
        
        reportView.TimePeriodPerformed(new ReportButtonListener());
        fillUsertable();
        
        //action listners 
        reportView.SummaryReportPerformed(new ReportButtonListener());
        reportView.EditFeesPerformed(new EditFee());
        reportView.renterLandlordPerformed(new RenterLandlords());
        reportView.ListingsPerformed(new Listings());

        allUsers.SummaryReportPerformed(new ReportButtonListener());
        allUsers.EditFeesPerformed(new EditFee());
        allUsers.renterLandlordPerformed(new RenterLandlords());
        allUsers.ListingsPerformed(new Listings());
    }

    //database connection
    public void connectDB() {
        db.initializeConnection();
    }

    // method to change the view for manager that belongs to different controller
    @Override
    public void switchView(String view)
    {
        super.switchView(view);
    }


  //implementation of action listeners
    //getting report data for manager summary based on time period selected
    public class ReportButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            int totalListing = listigModel.totalListings(db.getAllListings());
            reportView.setNumHousesListedField(totalListing);

            // landlord and listing arraylists
            ArrayList<User> landlords = manager.getLandlords(db.getUsers());

            // retrieving all listings from db
            ArrayList<ArrayList<Listing>> listings = listigModel.getLandlordListings(landlords, db.getAllListings());

            // now filter listings based on time period
            LocalDate currDate = LocalDate.now();
            LocalDate lastDate = currDate.minusDays(reportView.getTimePeriodField());
            System.out.println(lastDate.toString());

            ArrayList<ArrayList<Listing>> filteredlist = listigModel.filterTime(listings, lastDate);

            reportView.setLandlords(landlords);
            reportView.setListings(filteredlist);

            reportView.setTable(filteredlist, landlords);

            // houses rented
            int houseRented = 0;
            for (int i = 0; i < filteredlist.size(); i++)
            {
                for(int j =0; j < filteredlist.get(i).size(); j++)
                {
                    if(filteredlist.get(i).get(j).getStatus().equals("Rented"))
                    {
                        houseRented++;
                    }
                }
            }
            reportView.setNumHousesRentedField(houseRented);

            // houses active
            int houseActive = 0; // listigModel.housesActive(db.getAllListings());
            for (int i = 0; i < filteredlist.size(); i++)
            {
                for(int j =0; j < filteredlist.get(i).size(); j++)
                {
                    if(filteredlist.get(i).get(j).getStatus().equals("Active"))
                    {
                        houseActive++;
                    }
                }
            }
            reportView.setNumActiveListingsField(houseActive);
        }
    }

    //for managers to edit listing
    public class Listings implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	switchView("ManagerEditView");
        }
    }
    
    //manager to edit fee and set period
    public class EditFee implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	switchView("EditFee");
        }
    }
    
    //all users (landlords and registered renters) for managers
    public class RenterLandlords implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	fillUsertable(); 
        }
    }
    
    //method to switch between both views
    public void setView(boolean v1, boolean v2) {
    	if (v1) {
    		reportView.draw();
    	}
		if(v2) {
			allUsers.draw();
		}	
    }

    //method to set output table in user view
    public void fillUsertable() {
	    User u = new User();
	    ArrayList<User> users = db.getUsers();
	    ArrayList<User> landlords = u.getLandlords(users);
	    ArrayList<User> registeredRenters = u.getRegisteredRenters(users);
	    System.out.println(landlords.size());
	    System.out.println(registeredRenters.size());
	    allUsers.setLandlordTable(landlords);
	    allUsers.setRenterTable(registeredRenters);
    }

}


package Controller;

import Gui.DisplayUsersManagerView;
// import Gui.SummaryReportView;
import Gui.EditFeesView;
import Gui.EditStatusManagerView;
import Gui.SummaryReportView;
import Model.Listing;
import Model.Manager;
import Model.User;

import Model.Landlord;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class SummaryReportController extends ParentController{

    Listing listigModel;
    Manager manager;
    SummaryReportView reportView;
    DisplayUsersManagerView allUsers;
    EditFeesView feeView;

//    ArrayList<User> landlords = new ArrayList<>();
//    ArrayList<ArrayList<Listing>> listings = new ArrayList<>();

//    SummaryReportView reportView = new SummaryReportView(listings, landlords);

    DBConnect db = new DBConnect();


    public SummaryReportController(Listing listingmodel, Manager manager, SummaryReportView view, DisplayUsersManagerView view2)
    {
        this.listigModel = listingmodel;
        this.manager = manager;
        this.allUsers = view2;
        this.reportView = view;
        
        // reportView.SummaryReportPerformed(new ReportButtonListener());
        reportView.TimePeriodPerformed(new ReportButtonListener());
        fillUsertable();
        
        reportView.SummaryReportPerformed(new ReportButtonListener());
        reportView.EditFeesPerformed(new EditFee());
        reportView.renterLandlordPerformed(new RenterLandlords());
        reportView.ListingsPerformed(new Listings());
        reportView.EditFeesPerformed(new timePeriodButton());
        
        allUsers.SummaryReportPerformed(new ReportButtonListener());
        allUsers.EditFeesPerformed(new EditFee());
        allUsers.renterLandlordPerformed(new RenterLandlords());
        allUsers.ListingsPerformed(new Listings());
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
        	// setView(true, false);
        	System.out.println("SR- Summary Report button pressed");

            // total listing - need to double check
            int totalListing = listigModel.totalListings(db.getAllListings());
            // System.out.println("Total Listings: " + totalListing);
            reportView.setNumHousesListedField(totalListing);


            // landlord and listing arraylists
            ArrayList<User> landlords = manager.getLandlords(db.getUsers());
            // System.out.println("User length: " + landlords.size());

            // retrieving all listings from db
            ArrayList<ArrayList<Listing>> listings = listigModel.getLandlordListings(landlords, db.getAllListings());


            // now filter listings based on time period
            LocalDate currDate = LocalDate.now();
            // System.out.println(currDate.toString());
            LocalDate lastDate = currDate.minusDays(reportView.getTimePeriodField());
            System.out.println(lastDate.toString());

            ArrayList<ArrayList<Listing>> filteredlist = listigModel.filterTime(listings, lastDate);



            // do setters
            reportView.setLandlords(landlords);
            reportView.setListings(filteredlist);
            // System.out.println("Listing length: " + listings.size());
            // System.out.println("First Index length: " + listings.get(0).get(1).getID());

            reportView.setTable(filteredlist, landlords);

            // houses rented
            int houseRented = 0; // listigModel.housesRented(db.getAllListings());
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
            // System.out.println("Total Houses Rented: " + houseRented);

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
            // System.out.println("Total Houses Active: " + houseActive);



            // switchView("SummaryReportView"); // need to set this later after parent controller is fixed
        }
    }

    public class timePeriodButton implements ActionListener {
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
            ArrayList<User> landlords = manager.getLandlords(db.getUsers());
            System.out.println("User length: " + landlords.size());

            ArrayList<ArrayList<Listing>> listings = listigModel.getLandlordListings(landlords, db.getAllListings());

            // now filter listings based on time period

            LocalDate currDate = LocalDate.now();
            Date cdate = new Date(currDate.getDayOfYear(), currDate.getMonthValue(), currDate.getYear());
            LocalDate lastDate = currDate.minusDays(60); // (long) reportView.getTimePeriod());
            Date ldate = new Date(lastDate.getDayOfYear(), lastDate.getMonthValue(), lastDate.getYear());

            for(int i = 0; i < landlords.size(); i++)
            {
                for(int j = 0; j < listings.get(i).size(); j++)
                {
                    String year = listings.get(i).get(j).getListingTime().substring(0, 4);
                    String month = listings.get(i).get(j).getListingTime().substring(5, 7);
                    String day = listings.get(i).get(j).getListingTime().substring(8, 10);
                    Date listDate = new Date(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));

                    if(listDate.before(ldate))
                    {
                        listings.get(i).remove(j);
                    }

                }
            }

            // do setters
            reportView.setLandlords(landlords);
            reportView.setListings(listings);
            System.out.println("Listing length: " + listings.size());
            System.out.println("First Index length: " + listings.get(0).get(1).getID());

            reportView.setTable(listings, landlords);
            

        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("HERE");
            reportView.repaint();
            // total listing - need to double check
            int totalListing = listigModel.totalListings(db.getAllListings());
            // System.out.println("Total Listings: " + totalListing);
            reportView.setNumHousesListedField(totalListing);


            // landlord and listing arraylists
            ArrayList<User> landlords = manager.getLandlords(db.getUsers());
            // System.out.println("User length: " + landlords.size());

            // retrieving all listings from db
            ArrayList<ArrayList<Listing>> listings = listigModel.getLandlordListings(landlords, db.getAllListings());


            // now filter listings based on time period
            LocalDate currDate = LocalDate.now();
            // System.out.println(currDate.toString());
            LocalDate lastDate = currDate.minusDays(reportView.getTimePeriodField());
            System.out.println(lastDate.toString());

            ArrayList<ArrayList<Listing>> filteredlist = listigModel.filterTime(listings, lastDate);



            // do setters
            reportView.setLandlords(landlords);
            reportView.setListings(filteredlist);
            // System.out.println("Listing length: " + listings.size());
            // System.out.println("First Index length: " + listings.get(0).get(1).getID());

            reportView.setTable(filteredlist, landlords);

            // houses rented
            int houseRented = 0; // listigModel.housesRented(db.getAllListings());
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
            // System.out.println("Total Houses Rented: " + houseRented);

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
            // System.out.println("Total Houses Active: " + houseActive);


            setView(false, true);
            // switchView("SummaryReportView"); // need to set this later after parent controller is fixed
        }
    }
    
    
    public class Listings implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	System.out.println("SR- Edit listing pressed");
        	switchView("ManagerEditView");
        }
    }
    
    public class EditFee implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	System.out.println("SR- edit fee clicked");
        	switchView("EditFee");
        }
    }
    
    public class RenterLandlords implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	System.out.println("SR- renter landlord list clicked");
        	
        	fillUsertable(); 
        }
    }
    
    public void setView(boolean v1, boolean v2) {
    	if (v1) {
    		reportView.draw();
    	}
		if(v2) {
			allUsers.draw();
		}	
    }

    public class FeeSubmitButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Fee Submit Button Pressed");

            int fee = feeView.getFee();
            int feePeriod = feeView.getPer();

            //Add this data to database.
            try {
                db.addFee(fee, feePeriod);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

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
    
//    public static void main(String[] args)
//    {
//        System.out.println("Summary Report controller");
//        Listing list= new Listing();
//        User user = new User();
//        Manager m = new Manager();
//        ArrayList<ArrayList<Listing>> listings = new ArrayList<>();
//        DisplayUsersManagerView x = new DisplayUsersManagerView();
//        ArrayList<User> u = new ArrayList<>();
//        SummaryReportView reportview = new SummaryReportView(listings, u);
//
//        SummaryReportController controller = new SummaryReportController (list, m, reportview, x);
//        controller.connectDB();
//    }


}


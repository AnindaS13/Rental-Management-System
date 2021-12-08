package Controller;

import java.sql.*;
import java.io.*;
import java.util.*;

import Model.Listing;

public class DBConnect {


    public final String dburl = "jdbc:mysql://127.0.0.1:3306/ensf";
    public final String username = "root";
    public final String password ="calgary1";

    private Connection connect;
    private ResultSet results;
    
    
    // Constructor
    public DBConnect(){

    }

    /** Method initializeConnection
    * Establishes database connection
    */
    public void initializeConnection(){
    	    	
        try{
            connect = DriverManager.getConnection(dburl, username, password);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<Listing> getListing() {
    	PreparedStatement p=null;
    	ResultSet rs=null;
    	initializeConnection();
    	ArrayList<Listing> allListing = new ArrayList<Listing>();
    	
    	try {
    		//Sql query
	    	String sql = "select * from listing";
	    	p= connect.prepareStatement(sql);
	    	rs = p.executeQuery();
	    	
	    	//Retrieving data
	    	while(rs.next()) {
	    		int id = rs.getInt("ID");
	    		String property = rs.getString("propertyType");
	    		System.out.println(property);
	    		int bed = rs.getInt("bedrooms");
	    		int bath = rs.getInt("bathrooms");
	    		boolean furnished = rs.getBoolean("Furnished");
	    		String time = rs.getString("listingTime");
	    		String quad = rs.getString("quadrant");
	    		String email= rs.getString("email");
	    		String status= rs.getString("status");
	    		boolean bal= rs.getBoolean("balance");
	    		
	    		allListing.add(new Listing (id,property, bed, bath, furnished, quad, time, email, status ,bal));
	    	}
	    	
    	}
    	
    	// Catch block to handle exception
        catch (SQLException e) {
 
            // Print exception pop-up on scrreen
            System.out.println(e);
        }
    	return allListing;
    }
   
}
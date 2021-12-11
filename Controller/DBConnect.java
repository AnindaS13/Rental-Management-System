package Controller;

import java.sql.*;
import java.io.*;
import java.util.*;

import Model.Listing;
import Model.User;

public class DBConnect {

    public final String dburl = "jdbc:mysql://127.0.0.1:3307/rental";
    public final String username = "root";
    public final String password ="root";

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
    
    // Method to get all active listing from database
    public ArrayList<Listing> getListing() throws SQLException {
    	PreparedStatement p=null;
    	ResultSet rs=null;
    	initializeConnection();
    	ArrayList<Listing> allListing = new ArrayList<Listing>();
    	
    	try {
    		//Sql query
	    	String sql = "select * from listing"
	    			+ " where status = ?";
	    	p= connect.prepareStatement(sql);
	    	p.setString(1, "Active");
	    	rs = p.executeQuery();
	    	
	    	//Retrieving data
	    	while(rs.next()) {
	    		int id = rs.getInt("ID");
	    		String property = rs.getString("propertyType");
	    		//System.out.println(property);
	    		int bed = rs.getInt("bedrooms");
	    		int bath = rs.getInt("bathrooms");
	    		boolean furnished = rs.getBoolean("Furnished");
	    		String time = rs.getString("listingTime");
				String address = rs.getString("address");
	    		String quad = rs.getString("quadrant");
	    		String email= rs.getString("email");
	    		String status= rs.getString("status");
	    		boolean bal= rs.getBoolean("balance");
	    		
	    		allListing.add(new Listing (id,property, bed, bath, furnished, quad, time, address, email, status ,bal));
	    	}	
    	}
    	
    	// Catch block to handle exception
        catch (SQLException e) {
 
            // Print exception pop-up on screen
            System.out.println(e);
        }
    	connect.close();
    	return allListing;
    }

    // Method to get all users (registered renters and landlord) from database
	public ArrayList<User> getUsers()
	{
		ArrayList<User> users = new ArrayList<User>();
		initializeConnection();
		try{
			Statement stmt = connect.createStatement();
			String query = "SELECT * FROM user";
			results = stmt.executeQuery(query);

			while(results.next())
			{
				users.add(new User(results.getString("email"), results.getString("password"),
						results.getString("FName"), results.getString("LName"), results.getString("Role")));
			}
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return users;
	}

    // Method to get all searches that registered renters has subscribed to from database
	 public ArrayList<String> getAllsubscribedSearches() throws SQLException {
	    	PreparedStatement p=null;
	    	ResultSet rs=null;
	    	initializeConnection();
	    	ArrayList<String> temp = new ArrayList<String>();
	    	
	    	try {
	    		//Sql query
		    	String sql = "select * from registeredrenter";
		    	p= connect.prepareStatement(sql);
		    	rs = p.executeQuery();
		    	
		    	//Retrieving data
		    	while(rs.next()) {
		    		Integer id = rs.getInt("SID");
		    		String property = rs.getString("propertyType");
		    		Integer bed = rs.getInt("bedrooms");
		    		Integer bath = rs.getInt("bathrooms");
		    		Boolean furnished = rs.getBoolean("Furnished");
		    		String quad = rs.getString("quadrant");
		    		String notify = rs.getString("notify");
		    		String email = rs.getString("r_email");
		    		
		    		temp.add(id.toString()+"\n"+property+"\n"+bed.toString()+"\n"+
    							bath.toString()+"\n"+furnished.toString()+"\n"+quad+"\n"+notify+"\n"+email);
		    	}	
	    	}
	    	
	    	// Catch block to handle exception
	        catch (SQLException e) {
	 
	            // Print exception pop-up on screen
	            System.out.println(e);
	        }
	    	connect.close();
	    	return temp;
	    }

	    // Method to get all messages for landlords.
    public ArrayList<String> getMessages() {
    	PreparedStatement p=null;
    	ResultSet rs=null;
    	initializeConnection();
    	ArrayList<String> messages = new ArrayList<String>();
    	
    	try {
    		//Sql query
	    	String sql = "select * from landlord";
	    	p= connect.prepareStatement(sql);
	    	rs = p.executeQuery();
	    	
	    	//Retrieving data
	    	while(rs.next()) {
	    		String email = rs.getString("lemail");
	    		String message = rs.getString("message");	    
	    		Integer propId = rs.getInt("PropertyID");
	    		messages.add(email+"\n"+message+"\n"+propId.toString());
	    	}	
    	}
    	
    	// Catch block to handle exception
        catch (SQLException e) {
 
            // Print exception pop-up on screen
            System.out.println(e);
        }
    	return messages;
    }


    
    // Method to get all listings from database
	public ArrayList<Listing> getAllListings()
	{
		ArrayList<Listing> list= new ArrayList<Listing>();
		initializeConnection();
		try{
			Statement stmt = connect.createStatement();
			String query = "SELECT * FROM listing";
			results = stmt.executeQuery(query);

			while(results.next())
			{
				list.add(new Listing(results.getInt("ID"), results.getString("propertyType"), results.getInt("bedrooms"),
						results.getInt("bathrooms"), results.getBoolean("Furnished"), results.getString("quadrant"),
						results.getString("listingTime"), results.getString("address"), results.getString("email"),
						results.getString("status"), results.getBoolean("balance")));
			}
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return list;
	}

    // Method to update the listing when a landlord pays for property to list
  public void updateListingDate(String pID, String date, String status)
	{
		try {
			Statement s = connect.createStatement();
			boolean bal = true;
			String query = "UPDATE listing SET listingTime =? where ID="+pID;
			String querytwo = "UPDATE listing SET status =? where ID="+pID;
			String querythree = "UPDATE listing SET balance =? where ID="+pID;
			PreparedStatement stmt = connect.prepareStatement(query);

			stmt.setString(1,date);
			stmt.execute();
			stmt.close();

			PreparedStatement stmttwo = connect.prepareStatement(querytwo);

			stmttwo.setString(1,status);
			stmttwo.execute();
			stmttwo.close();

			PreparedStatement stmtthree = connect.prepareStatement(querythree);
			stmtthree.setBoolean(1,bal);
			stmtthree.execute();
			stmtthree.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	
  // Method to update notifications in database for subscribed search
  //takes id of the subscribed search and updated status.
  
	public void updatenotify(Integer id, String status)
	{	
			initializeConnection();
			try {
				Statement s = connect.createStatement();
				String query = "UPDATE registeredrenter SET notify =? where SID=?";
	
				PreparedStatement stmt = connect.prepareStatement(query);
				stmt.setString(1,status);
				stmt.setInt(2, id);
				stmt.execute();
				stmt.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
	}

	  // Method to status of a listing
	//takes id of the listing and new status
	public void updateStatus(String id, String status)
	{
		try {
			Statement s = connect.createStatement();
			String query = "UPDATE listing SET status =? where ID="+id;

			PreparedStatement stmt = connect.prepareStatement(query);

			stmt.setString(1,status);
			stmt.execute();
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}


	public void managerUpdateStatus(String id, String status)
	{
		try {
			Statement s = connect.createStatement();
			String query = "UPDATE listing SET status =? where ID="+id;

			PreparedStatement stmt = connect.prepareStatement(query);

			stmt.setString(1,status);
			stmt.execute();
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Not a valid ID");
		}
	}


	//add new property information when landlords register property
	public void addListing(String email, String type, int bed, int bath, boolean furnish, String address, String quad, String date, String status) throws SQLException
	{

		initializeConnection();

		try {

			Statement s = connect.createStatement();
			String query = "INSERT INTO listing (email, propertyType, bedrooms, bathrooms, Furnished, quadrant, address, listingTime, status, balance) VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = connect.prepareStatement(query);

			stmt.setString(1, email);
			stmt.setString(2, type);
			stmt.setInt(3, bed);
			stmt.setInt(4, bath);
			stmt.setBoolean(5, furnish);
			stmt.setString(6, quad);
			stmt.setString(7, address);
			stmt.setString(8, date);
			stmt.setString(9, status);
			stmt.setBoolean(10, false);

			stmt.execute();
			stmt.close();

		} catch (SQLException e){
			e.printStackTrace();
		}

		System.out.println("Added new listing");
	}

	public void addFee(int feeAmount, int feePeriod) throws SQLException
	{

		initializeConnection();

		try {

			Statement s = connect.createStatement();
			String query = "INSERT INTO editfees (FeeAmount, Days) VALUES (?,?)";

			PreparedStatement stmt = connect.prepareStatement(query);

			stmt.setInt(1, feeAmount);
			stmt.setInt(2, feePeriod);

			stmt.execute();
			stmt.close();

		} catch (SQLException e){
			e.printStackTrace();
		}

		System.out.println("Added new fee");
	}


//Method to save the search criteria in database when registered renter subscribe to search
	public ArrayList<Listing> saveSearch(String email, String proptype, int bedrooms,
											int bathrooms, boolean furnished, String quadrant)
	{
		ArrayList<Listing> list= new ArrayList<Listing>();
		initializeConnection();
		try{
			Statement stmt = connect.createStatement();
			String query = " insert into registeredrenter (r_email, propertyType, bedrooms"
							+ ", bathrooms, Furnished, quadrant)"
			        + " values (?, ?, ?, ?, ?, ?)";
			
			 // sql insert preparedstatement
		      PreparedStatement preparedStmt = connect.prepareStatement(query);
		      preparedStmt.setString (1, email);
		      preparedStmt.setString (2, proptype);
		      preparedStmt.setInt   (3, bedrooms);
		      preparedStmt.setInt (4, bathrooms);
		      preparedStmt.setBoolean  (5, furnished);
		      preparedStmt.setString (6, quadrant);
		      
		      preparedStmt.execute();
		      stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return list;
	}

   //method to save messages for landlord when renter sends it.
	public ArrayList<Listing> saveMessages(String email, String message, int propID)
	{
		ArrayList<Listing> list= new ArrayList<Listing>();
		initializeConnection();
		try{
			Statement stmt = connect.createStatement();
			String query = " insert into landlord (lemail, message, propertyID)"
					+ " values (?, ?, ?)";

			// sql insert preparedstatement
			PreparedStatement preparedStmt = connect.prepareStatement(query);
			preparedStmt.setString (1, email);
			preparedStmt.setString (2, message);
			preparedStmt.setInt   (3, propID);

			preparedStmt.execute();
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		return list;
	}
}
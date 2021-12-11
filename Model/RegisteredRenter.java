package Model;

import java.util.ArrayList;

/**
 * Class RegisteredRenter is a model for all registered renter users. It extends from class User and contains data members key, propertyType,
 * numbedRooms, numbathRooms, isFurnished, quadrant and listing.
 * It contains methods subscriptionNotice() and setter and getter functions for its data members
 */

public class RegisteredRenter extends User {

    // email ask fk from user
    private int key; // pk for subscription
    private String propertyType;
    private int numbedRooms;
    private int numbathRooms;
    private boolean isFurnished;
    private String quadrant;
    private Listing listing;


    public RegisteredRenter() { // default constructor

    }

    // constructor
    public RegisteredRenter(String email, String password, String fname, String lname, String role, String propertyType, int bedrooms, int bathrooms, boolean furnished, String quadrant) {
        super(email, password, fname, lname, role);
        this.propertyType = propertyType;
        this.numbedRooms = bedrooms;
        this.numbathRooms = bathrooms;
        this.isFurnished = furnished;
        this.quadrant = quadrant;

    }

    public void subscribe() {
    	
    }

    public void unsubscribe() {

    }

    // method subscriptionNotice() handles the subscription feature for registered renter. It receives the searches, listings and the property ID
    public ArrayList<Integer> subscriptionNotice(ArrayList<String> searches, ArrayList<Listing> activeListings, String propId) {
    	
    	ArrayList<Integer> temp = new ArrayList<Integer>();
    	Listing listing = new Listing();
    	
    	//find the active listing with propID
    	for (int j=0; j<activeListings.size(); j++) {
    		if(activeListings.get(j).getID() == Integer.parseInt(propId)) {
    			listing = activeListings.get(j);
    			break;
    		}
    	}
    	
    	if(listing != null) {
    	for (int i=0; i<searches.size(); i++) {

    		String [] t = searches.get(i).split("\n");
	
    		if(t[1].equals(listing.getPropertyType()) && t[2].equals(String.valueOf(listing.getNumbedRooms())) && 
    		t[3].equals(String.valueOf(listing.getNumbathRooms())) && t[4].equals(String.valueOf(listing.getIsFurnished())) && t[5].equals(listing.getQuadrant()))  {
    			temp.add(Integer.parseInt(t[0]));
    			}
    		}
    	}
    	return temp;
    }	


    public void extractEmail(String email) {

    }


    public int getKey() {
        return this.key;
    }
    public void setKey(int key) {
        this.key = key;
    }
    

    public String getPropertyType() {
    	return this.propertyType;
    }
    public void setPropertyType(String propertyType) {
    	this.propertyType = propertyType;
    }


    public int getNumbathRooms() {
    	return this.numbathRooms;
    }

    public int getNumbedRooms() {
        return this.numbedRooms;
    }

    public void setNumbedRooms(int numbedRooms) {
        this.numbedRooms = numbedRooms;
    }


    public void setNumbathRooms(int numbathRooms) {
        this.numbathRooms = numbathRooms;
    }


    public boolean getIsFurnished() {
        return this.isFurnished;
    }

    public void setIsFurnished(boolean isFurnished) {
        this.isFurnished = isFurnished;
    }


    public String getQuadrant() {
        return this.quadrant;
    }

    public void setQuadrant(String quadrant) {
        this.quadrant = quadrant;
    }
}
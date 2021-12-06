package Model;

import Model.Landlord;

public class Listing {


    private int listingID;
    private String propertyType;
    private int numbedRooms;
    private int numbathRooms;
    private boolean isFurnished;
    private String quadrant;
    private int listingTime;
    private String landlord;

    public Listing(String propertType, int bedrooms, int bathrooms, boolean isFurnished, String quadrant, int listingTime, String landlord)
    {
        this.propertyType = propertyType;
        this.numbedRooms = bedrooms;
        this.numbathRooms = bathrooms;
        this.isFurnished = isFurnished;
        this.quadrant = quadrant;
        this.listingTime = listingTime;
        this.landlord = landlord;
    }

    public int getListingID() {
        return listingID;
    }

    public void setListingID(int listingID) {
        this.listingID = listingID;
    }
    public String getPropertyType() {
        return this.propertyType;
    }
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public int getNumbedRooms() {
    	return this.numbedRooms;
    }
    public void setNumbedRooms(int numbedRooms) {
    	this.numbedRooms = numbedRooms;
    }


    public int getNumbathRooms() {
    	return this.numbathRooms;
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


    public int getListingTime() {
    	return this.listingTime;
    }
    public void setListingTime(int listingTime) {
    	this.listingTime = listingTime;
    }


    public String getLandlord() {
    	return this.landlord;
    }
    public void setLandlord(String landlord) {
    	this.landlord = landlord;
    }

}

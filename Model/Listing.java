package Model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Class Listing is a model for each property registered in the database.
 * It consists of data members id, propertyType, numbedRooms, numbathRooms, isFurnished, quadrant, listingTime,
 * address, email, status, balance and role
 * It contains two constructors, one default constructor and the other initializes all the data members
 * It contains methods filterListings(), houseRented(), housesActive(), totalListings(), landLordIDFromListing(),
 * getLandlordListings() and filterTime() as well as getter and setter functions for all data members
 */

public class Listing {

    private int ID; // pk, ai
    // all below nn
    private String propertyType;
    private int numbedRooms;
    private int numbathRooms;
    private boolean isFurnished;
    private String quadrant;
    private String listingTime;
    private String address;
    private String email; // fk from landlord
    private String status;
    private boolean balance;
    private char role; 


    // default constructor
    public Listing () {}

    // constructor
    public Listing(int id, String propertyType, int bedrooms, int bathrooms, boolean isFurnished, String quadrant, String listingTime, String address, String email, String status, boolean balance)
    {
        this.ID = id;
        this.propertyType = propertyType;
        this.numbedRooms = bedrooms;
        this.numbathRooms = bathrooms;
        this.isFurnished = isFurnished;
        this.quadrant = quadrant;
        this.listingTime = listingTime;
        this.address = address;
        this.email = email;
        this.status = status;
        this.balance = balance;

    }

    // Getter and Setter functions below for each data member
    public int getID()
    {
        return this.ID;
    }
    public void setID(int id)
    {
        this.ID = id;
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


    public String getListingTime() {
        return this.listingTime;
    }
    public void setListingTime(String listingTime) {
        this.listingTime = listingTime;
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }


    public String email() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    public boolean getBalance() {
        return this.balance;
    }
    public void setBalance(boolean balance) {
        this.balance = balance;
    }

    public int getListingID() {
        return ID;
    }


    // This method filters the listng with specific search criteria's and returns the filtered list
    public ArrayList<Listing> filterListings (ArrayList<Listing> listings, String propType, int bedrooms, int bathrooms, boolean furnished, String quad)
    {
        ArrayList<Listing> filteredlist = new ArrayList<Listing>();
        for (int i = 0; i < listings.size(); i++)
        {	//System.out.println(furnished);
            if (listings.get(i).getPropertyType().equals(propType) && listings.get(i).getNumbedRooms() == bedrooms && listings.get(i).getNumbathRooms() == bathrooms 
            	&& listings.get(i).getQuadrant().equals(quad)  && listings.get(i).getIsFurnished() == furnished )
            {	
                filteredlist.add(listings.get(i));
            }
        }
        return filteredlist;
    }

    // This method returns the number of houses rented in the listing
    public int housesRented(ArrayList<Listing> listings)
    {
        int count = 0;
        for (int i = 0; i < listings.size(); i++)
        {
            if(listings.get(i).getStatus().equals("Rented"))
            {
                count++;
            }
        }
        return count;
    }

    // returns the total number of listings in the database
    public int totalListings(ArrayList<Listing> listings)
    {
        return listings.size();
    }


    // returns the landlord listings
    public ArrayList<ArrayList<Listing>> getLandlordListings(ArrayList<User> landlords, ArrayList<Listing> listings)
    {
        ArrayList<ArrayList<Listing>> list = new ArrayList<ArrayList<Listing>>();
        for(int i = 0; i < landlords.size(); i++)
        {
            ArrayList<Listing> miniList = new ArrayList<Listing>();
            for(int j = 0; j < listings.size(); j++)
            {
               if(landlords.get(i).getEmail().equals(listings.get(j).email))
                {
                    miniList.add(listings.get(j));
                }
            }
            list.add(miniList);
        }

        return list;
    }

    // returns the number of houses active in listings
    public int housesActive(ArrayList<Listing> listings)
    {
        int count = 0;
        for (int i = 0; i < listings.size(); i++)
        {
            if(listings.get(i).getStatus().equals("Active"))
            {
                count++;
            }
        }
        return count;
    }

    // returns landlord listings with specific property id
    public String landLordIdFromListing (ArrayList<Listing> listings, int propID)
    {
        String temp = null;
        for (int i = 0; i < listings.size(); i++)
        {	//System.out.println(furnished);
            if (listings.get(i).getID() == propID)
            {	
                temp =listings.get(i).email();
                break;
            }
        }
        return temp;
    }

    // Method filterTime() returns listings with a specified time frame
    public ArrayList<ArrayList<Listing>> filterTime (ArrayList<ArrayList<Listing>> allList, LocalDate date)
    {
        ArrayList<ArrayList<Listing>> filteredlist = new ArrayList<>();

        for(int i = 0; i < allList.size(); i++)
        {
            filteredlist.add(new ArrayList<Listing>());
            for(int j = 0; j < allList.get(i).size(); j++)
            {
                LocalDate listDate = LocalDate.parse(allList.get(i).get(j).getListingTime());

                if(listDate.isAfter(date) || listDate.isEqual(date)) {
                    filteredlist.get(i).add(allList.get(i).get(j));
                }
            }
        }

        return filteredlist;
    }
}
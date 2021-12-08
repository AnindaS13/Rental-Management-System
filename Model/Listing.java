package Model;
public class Listing {

    private int ID; // pk, ai
    // all below nn
    private String propertyType;
    private int numbedRooms;
    private int numbathRooms;
    private boolean isFurnished;
    private String quadrant;
    private String listingTime;
    private String email; // fk from landlord
    private String status;
    private boolean balance;



    public Listing () {}

    public Listing(int id, String propertyType, int bedrooms, int bathrooms, boolean isFurnished, String quadrant, String listingTime, String email, String status, boolean balance)
    {
        this.ID = id;
        this.propertyType = propertyType;
        this.numbedRooms = bedrooms;
        this.numbathRooms = bathrooms;
        this.isFurnished = isFurnished;
        this.quadrant = quadrant;
        this.listingTime = listingTime;
        this.email = email;
        this.status = status;
        this.balance = balance;

    }


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



}
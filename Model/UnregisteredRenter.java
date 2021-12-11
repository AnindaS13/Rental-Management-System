package Model;


/**
 * Class UnregisteredRenter is a model for all unregistered renter users. It enteds from class User and contains data memebrs listing.
 * It contains getter and setter methods for its data members and searchForListing()
 * It contains two constructors, one default constructor and one to initialize all the data members.
 */

public class UnregisteredRenter extends User {

    // no db
    private Listing listing;


    public UnregisteredRenter() // default constructor
    {
        
    }

    public UnregisteredRenter(Listing listing) // constructor
    {
        super();
        this.listing = listing;
    }


    public String searchForListing(String propr, int bedrooms, int bathrooms, boolean isFurnished, String quadrant)
    {
        return "";
    }

    public Listing getListing() {
	return this.listing;
    } // getter function
    public void setListing(Listing listing) {
        this.listing = listing;
    } // setter function


    
}
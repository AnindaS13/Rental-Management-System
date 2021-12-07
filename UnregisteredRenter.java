public class UnregisteredRenter extends User {

    // no db
    private Listing listing;

    UnregisteredRenter(Listing listing)
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
    }
    public void setListing(Listing listing) {
        this.listing = listing;
    }


    
}

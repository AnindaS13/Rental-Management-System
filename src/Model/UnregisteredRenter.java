package Model;

public class UnregisteredRenter {

    private Listing listing;

    UnregisteredRenter(Listing listing)
    {
        this.listing = listing;
    }


    public Listing getListing() {
	return this.listing;
    }
    public void setListing(Listing listing) {
        this.listing = listing;
    }


    
}

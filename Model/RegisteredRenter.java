package Model;

public class RegisteredRenter {

    public Listing listings;

    
    public RegisteredRenter()
    {
    }

    public RegisteredRenter(Listing listing)
    {
        this.listings = listing;
    }

    public void subscribe()
    {

    }

    public void unsubscribe()
    {
        
    }

    public Listing getListings() {
        return this.listings;
    }
    public void setListings(Listing listings) {
        this.listings = listings;
    }




    
}
public class RegisteredRenter extends User{

    // email ask fk from user
    private int key; // pk for subscription
    private String propertyType;
    private int numbedRooms;
    private int numbathRooms;
    private boolean isFurnished;
    private String quadrant;
    private Listing listing;



    


    public RegisteredRenter(String email, String password, String fname, String lname, String role, String propertyType, int bedrooms, int bathrooms, boolean furnished, String quadrant)
    {
        super(email, password, fname, lname, role);
        this.propertyType = propertyType;
        this.numbedRooms = bedrooms;
        this.numbathRooms = bathrooms;
        this.isFurnished = furnished;
        this.quadrant = quadrant;
        
    }

    public void subscribe()
    {

    }

    public void unsubscribe()
    {
        
    }

    public String searchForListing(String propr, int bedrooms, int bathrooms, boolean isFurnished, String quadrant)
    {
        return "";
    }

    public void extractEmail(String email)
    {

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

    



    
}

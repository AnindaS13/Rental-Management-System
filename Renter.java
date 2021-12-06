class Renter {

    private String propertyType;
    private int numbedRooms;
    private int numbathRooms;
    private boolean isFurnished;
    private String quadrant;


    // Constructor
    Renter(String propertyType, int bedrooms, int bathrooms, boolean isFurnished, String quadrant)
    {
        this.propertyType = propertyType;
        this.numbedRooms = bedrooms;
        this.numbathRooms = bathrooms;
        this.isFurnished = isFurnished;
        this.quadrant = quadrant;
    }


    public String searchForListing(String propr, int bedrooms, int bathrooms, boolean isFurnished, String quadrant)
    {
        return "";
    }

    public void extractEmail(String email)
    {

    }
}
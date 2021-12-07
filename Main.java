public class Main {

    
    public static void main(String[] args)
    {

        DBConnect database = new DBConnect("jdbc:mysql://localhost/rentalproperties", "ENSF409", "ensf409");
        database.initializeConnection();
        
    }
} 
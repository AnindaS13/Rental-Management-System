import java.util.ArrayList;

public class Landlord extends User {

    // inherits email from user, use email as fk

    private int messageID; // pk, nn, ai
    private String message; 

    public Landlord()
    {
        super();
    }

    public Landlord(String email, String password, String fname, String lname, String role, int id, String message)
    {
        super(email, password, fname, lname, role);
        this.messageID = id;
        this.message = message;
    }

    // public Listing addProperty()
    // {
    //     return;
    // }

    public String editStatus()
    {
        return "";
    }
    
}

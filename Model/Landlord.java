package Model;

import java.util.ArrayList;

public class Landlord extends User {

    // inherits email from user, use email as fk

    private int messageID; // pk, nn, ai
    private ArrayList<String> message; 

    public Landlord()
    {
        super();
    }

    public Landlord(String email, String password, String fname, String lname, String role, int id, String message)
    {
        super(email, password, fname, lname, role);
        this.messageID = id;
        this.message.add(message);
    }

    public void addMessage (String m)
    {
        this.message.add(m);        
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

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

    }

    public ArrayList<String> RetreiveMessage (ArrayList<String>  allMsg)
    {
        String email = super.getEmail(); 	// get the email of current user logged in
        ArrayList<String> result = new ArrayList<String>();

        for(int i=0; i<allMsg.size(); i++) {
            String [] temp = allMsg.get(i).split("\n"); //Split each String in ArrayList to get email and messages
            //if(temp[0].equals(email)) {		//check if messages belong to current user
            result.add(temp[1]);
            //}
        }
        return result;
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
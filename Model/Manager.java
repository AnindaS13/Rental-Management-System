package Model;

public class Manager extends User{

    // no db
    // add a fee variable cause manager can change fees
    // fee periods as well
    
    public Manager()
    {
        super();
    }

    public Manager(String email, String password, String fname, String lname, String role)
    {
        super(email, password, fname, lname, role);
    }

    public String compileReport()
    {
        return "";
    } 

    public String editStatus()
    {
        return "";
    }
    
    
    
}
package Model;

/**
 * Class Manager is a model that represents the Manager user. It extends from class User
 * It contains two constructors, one default constructor and the other initializes the data members
 * This class inherits variables email, password, FName, LName and role from class User
 */
public class Manager extends User{

    // no db
    // add a fee variable cause manager can change fees
    // fee periods as well
    
    public Manager() // default constructor
    {
        super();
    }

    public Manager(String email, String password, String fname, String lname, String role) // constructor
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
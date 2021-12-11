package Model;

import java.util.ArrayList;


/**
 * Class User is a model for each user of the property rental system. It has data members email, password, FName, LName and role.
 * It contains two constructors, one default constructor and one that initializes all the data members.
 * It contains methods verifyLogin(), getLandlords(), getRegisteredRenters() and setters and getters for each data members
 * Class user is the parent class of class Landlord, Manager, RegisteredRenter and UnregisteredRenter
 */

public class User {

    protected String email; // pk, nn
    protected String password; // nn
    protected String FName;
    protected String LName;

    protected String role; // nn
    


public User() // default constructor
    {
        this.email = null;
        this.password = null;
        this.FName = null;
        this.LName = null;
        this.role = null;
    }


    public User(String email, String password, String FName, String LName, String role) // constructor
    {
        this.email = email;
        this.password = password;
        this.FName = FName;
        this.LName = LName;
        this.role = role;
    }

    // Method verifyLogin() receives an array list of users and email and password to verify of the user trying to login
    // exists. It returns true if user exists and false if the user does not exist
    public boolean verifyLogin(ArrayList<User> users, String email, String password)
    {
        for (int i = 0; i < users.size(); i++)
        {
            if(users.get(i).email.equals(email) && users.get(i).password.equals(password))
            {	
            	setEmail(users.get(i).email);
            	setPassword(users.get(i).password);
            	setFName(users.get(i).FName);
            	setLName(users.get(i).LName);
            	setRole(users.get(i).role);
                return true;
            }
        }
        return false;
    }

    // Method getLandLords recieves an arraylist of users and returns an arraylist of landlords from users
    public ArrayList<User> getLandlords(ArrayList<User> users)
    {
        ArrayList<User> landlords = new ArrayList<User>();
        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getRole().equals("Landlord"))
            {
                landlords.add(users.get(i));
            }
        }
        return landlords;
    }

    // Method getRegisteredRenters recieves an arraylist of users and returns an arraylist of registered renters from users
    public ArrayList<User> getRegisteredRenters(ArrayList<User> users)
    {
        ArrayList<User> renters = new ArrayList<User>();
        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getRole().equals("RegisteredRenter"))
            {
                renters.add(users.get(i));
            }
        }
        return renters;
    }
    
    // Getter and setter functions below
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getFName() {
        return this.FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }


    public String getLName() {
        return this.LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getRole() {
    	return this.role;
    }
    public void setRole(String role) {
    	this.role = role;
    }
}


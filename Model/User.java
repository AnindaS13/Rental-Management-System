package Model;

import java.util.ArrayList;

public class User {

    protected String email; // pk, nn
    protected String password; // nn
    protected String FName;
    protected String LName;

    protected String role; // nn
    


public User()
    {
        this.email = null;
        this.password = null;
        this.FName = null;
        this.LName = null;
        this.role = null;
    }


    public User(String email, String password, String FName, String LName, String role)
    {
        this.email = email;
        this.password = password;
        this.FName = FName;
        this.LName = LName;
        this.role = role;
    }


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


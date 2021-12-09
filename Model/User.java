package Model;

import java.util.ArrayList;

public class User {

    private String email; // pk, nn
    private String password; // nn
    private String FName; 
    private String LName;

    private String role; // nn

    

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
                return true;
            }
        }
        return false;
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
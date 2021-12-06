public class User {

    private String email;
    private String password;
    private String FName;
    private String LName;



    User(String email, String password, String FName, String LName)
    {
        this.email = email;
        this.password = password;
        this.FName = FName;
        this.LName = LName;
    }


    public boolean verifyLogin()
    {
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



    


    

    


    

}

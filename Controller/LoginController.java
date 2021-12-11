package Controller;

import Gui.LoginView;
import Gui.RenterListingView;
import Model.Listing;
import Model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//controller checks for login information and call parent controller method
// to switch view according to login email whether its manager, landlord or registered renter 
// logged in 

public class LoginController extends ParentController{

    User userModel;
    LoginView loginView;
    DBConnect db = new DBConnect();

    //constructor
    public LoginController(User model, LoginView view)
    {	
    	super();
        this.userModel = model;
        this.loginView = view;

        loginView.loginButton(new LoginButtonListener());
        loginView.guestLoginButton(new guestLogin());
    }

    //database connection to get user information
    public void connectDB() {
        db.initializeConnection();
    }

    //method to appropriate view depending on email.
    public void switchView(String role, String email, String password)
    {	
    	loginView.clearFrame();
    	if(role.equals("Landlord")) {
    		super.landlord.setEmail(email);
    		super.landlord.setRole(role);
    		super.landlord.setPassword(password);
    		super.switchView("RegisterProperty");}
    	else if (role.equals("Manager")) {
    		super.manager.setEmail(email);
    		super.manager.setRole(role);
    		super.manager.setPassword(password);
    		super.switchView("ManagerEditView");
    	}
    	else if (role.equals("RegisteredRenter")){
    		super.Rrenter.setEmail(email);
    		super.Rrenter.setPassword(password);
    		super.Rrenter.setRole(role);
    		super.switchView("RegisteredRenter");
    	}
    	else super.switchView("UnregisteredRenter");
    }


    public class LoginButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean verify = userModel.verifyLogin(db.getUsers(), loginView.getUsername(), loginView.getPassword());
            if(verify)
            {
                System.out.println("Login successful");
                switchView(userModel.getRole(), loginView.getUsername(),loginView.getPassword()); // need to set this later after parent controller is fixed
            }
            else
            {
                System.out.println("User does not exist");
            }
        }
    }
    
    public class guestLogin implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	switchView("","","");
        }
    }

//    public static void main(String[] args)
//    {
//        System.out.println("Login controller");
//        User u = new User();
//        LoginView l = new LoginView();
//        LoginController controller = new LoginController (u, l);
//        controller.connectDB();
//    }


}

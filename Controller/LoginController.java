package Controller;

import Gui.LoginView;
import Gui.RenterListingView;
import Model.Listing;
import Model.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginController extends ParentController{

    User userModel;
    LoginView loginView;
    DBConnect db = new DBConnect();

    public LoginController(User model, LoginView view)
    {	
    	super();
        this.userModel = model;
        this.loginView = view;

        loginView.loginButton(new LoginButtonListener());
    }


    public void connectDB() {
        db.initializeConnection();
    }

    public void switchView(String role, String email, String password)
    {	
    	loginView.clearFrame();
    	if(role.equals("Landlord")) {
    		super.setLandlord(role, email, password);
    		super.switchView("EditProperty");}
    	else if (role.equals("Manager"))
    		super.switchView("ManagerEditView");
    	else if (role.equals("RegisteredRenter"))
    		super.switchView("RegisteredRenter");
    	else super.switchView("ListingView");
    }
      

//    public void setRole(String username, String role)
//    {
//    	super.setUserRole(username, role);
//    }

    public class LoginButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(" login button pressed");
            boolean verify = userModel.verifyLogin(db.getUsers(), loginView.getUsername(), loginView.getPassword());
            if(verify)
            {
                System.out.println("Login successful");
//                userModel.setEmail(loginView.getUsername());
//                userModel.setPassword(loginView.getPassword());
                switchView(userModel.getRole(), loginView.getUsername(),loginView.getPassword()); // need to set this later after parent controller is fixed
            }
            else
            {
                System.out.println("User does not exist");
            }
            // loginView.setOutput(db.getListing());
        }
    }


    public static void main(String[] args)
    {
        System.out.println("Login controller");
        User u = new User();
        LoginView l = new LoginView();
        LoginController controller = new LoginController (u, l);
        controller.connectDB();
    }


}

package Gui;

import java.awt.*;
import Model.Listing;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Basic login view for the user to log in to the system as a User
 * A user can be: a registered renter, landlord, or manager
 * It also gives the option to log in as a guest (unregistered renter)
 */
public class LoginView implements Component {
    // display invlaid login button
    private JButton search = new JButton("Search"); // should be deleted but deleting affects the controller
    private JButton subscribe = new JButton("Subscribe"); // should be deleted but deleting affects the controller
    private JButton unsubscribe = new JButton("UnSubscribe");// should be deleted but deleting affects the controller
    private Boolean notify = false;  // should be deleted but deleting affects the controller
    private JLabel invalidLogin = new JLabel("The Username or Password is Incorrect");
    private Boolean validLogin = true;
    Container container = frame.getContentPane();

    private JTextField username =new JTextField();
    private JPasswordField password =new JPasswordField();
    JButton loginButton=new JButton("Login");
    JButton guestLoginButton =new JButton("Guest Login");
    private JButton login = new JButton("Login");
    private Color back = new Color(25, 25, 112);
    private Color button = new Color(0,0,0);

    private JLabel title = new JLabel("Rental Property Management System");

    public LoginView() { //Constructor just adds the login page components into the frame using draw()
        draw();
    }

    /**
     * Action listeners for buttons like login and login as guest
     */
    public void loginButton(ActionListener actionListener) {
        this.loginButton.addActionListener(actionListener);
    }

    public void guestLoginButton(ActionListener actionListener) 
    	{this.guestLoginButton.addActionListener(actionListener);}
    
    @SuppressWarnings("serial")
    @Override
    public void draw() {  //Adds the gui components to the frame

        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(dim.width/2-250, dim.height/2-250);
        frame.setSize(900,900);
        frame.getContentPane().setForeground(new Color(255, 255, 255));
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.getContentPane().setLayout(null);

        JLabel userLabel=new JLabel("Username");
        JLabel passwordLabel=new JLabel("Password");

        userLabel.setBounds(400,300,100,30);
        userLabel.setForeground(Color.white);
        userLabel.setFont(new Font("Calibri", Font.PLAIN,  20));
        passwordLabel.setBounds(400,450,100,30);
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(new Font("Calibri", Font.PLAIN,  20));
        username.setBounds(350,350,200,35);
        username.setFont(new Font("Calibri", Font.PLAIN,  18));
        password.setBounds(350,500,200,35);
        password.setFont(new Font("Calibri", Font.PLAIN,  18));
        loginButton.setBounds(230,640,150,60);
        loginButton.setBackground(button);
        loginButton.setForeground(Color.white);
        guestLoginButton.setBounds(560,640,150,60);
        guestLoginButton.setForeground(Color.WHITE);
        guestLoginButton.setBackground(button);
        title.setForeground(Color.white);
        title.setFont(new Font("Calibri", Font.PLAIN,  40));
        title.setBounds(150,50,800,50);
        container.add(title);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(username);
        container.add(password);
        container.add(loginButton);
        container.add(guestLoginButton);
//        if(validLogin == true) {
//            invalidLogin.setBounds(50 + 0,100 + 0,100,30);
//
//        }
        frame.getContentPane().setBackground(back);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(dim.width/2-250, dim.height/2-250);
        frame.setSize(900,900);
        frame.setVisible(true);
    }

    /**
     * Getters and setters
     */
    public Boolean getValidLogin() {
        return validLogin;
    }

    public void setValidLogin(Boolean validLogin) {
        this.validLogin = validLogin;
    }


    public String getUsername() {
        return (String) username.getText();
    }

    public void setUsername(String username) {
        this.username.setText(username);
    }

    public String getPassword() {
        return String.valueOf(this.password.getPassword());
    }

    public void setPassword(String password) {
        this.password.setText(password);
    }
    
    public void clearFrame() {
    	frame.getContentPane().removeAll();
    }

    public static void main(String[] args) {
        LoginView u = new LoginView();
    }


}
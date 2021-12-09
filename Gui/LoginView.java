package Gui;

import Model.Listing;
import java.awt.*;
import java.util.ArrayList;

import java.awt.event.ActionListener;
import javax.swing.*;

public class LoginView implements Component {
    
    private JButton search = new JButton("Search"); // should be deleted but deleting affects the controller
    private JButton subscribe = new JButton("Subscribe"); // should be deleted but deleting affects the controller
    private JButton unsubscribe = new JButton("UnSubscribe");// should be deleted but deleting affects the controller
    private Boolean notify = false;  // should be deleted but deleting affects the controller

    Container container = frame.getContentPane();

    private JTextField username =new JTextField();
    private JPasswordField password =new JPasswordField();
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("RESET");
    private JButton login = new JButton("Login");


    public LoginView() {
        draw();
    }

    public void searchButton(ActionListener actionListener) { // should be deleted but deleting affects the controller
        this.search.addActionListener(actionListener);
    }
    public void subscribeButton(ActionListener actionListener) { // should be deleted but deleting affects the controller
        this.subscribe.addActionListener(actionListener);
    }

    public void unsubscribeButton(ActionListener actionListener) { // should be deleted but deleting affects the controller
        this.unsubscribe.addActionListener(actionListener);
    }

    public void loginButton(ActionListener actionListener) {
        this.loginButton.addActionListener(actionListener);
    }

    public void resetButton(ActionListener actionListener) {
        this.resetButton.addActionListener(actionListener);
    }
    
    @SuppressWarnings("serial")
    @Override
    public void draw() {
        Color foreGroundColor = Color.BLACK;
        Color backgroundColor = Color.lightGray;
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

        userLabel.setBounds(50 + 0,400,100,30);
        passwordLabel.setBounds(50 + 0,450,100,30);
        username.setBounds(150 + 0,400,150,30);
        password.setBounds(150 + 0,450,150,30);
        loginButton.setBounds(50 + 0,550,100,30);
        resetButton.setBounds(200 + 0,550,100,30);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(username);
        container.add(password);
        container.add(loginButton);
        container.add(resetButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(dim.width/2-250, dim.height/2-250);
        frame.setSize(900,900);
        frame.setVisible(true);
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
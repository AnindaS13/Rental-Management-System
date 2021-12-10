package Gui;

import Model.Listing;

import java.util.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RegisterPropertyView implements Component
{
    private String types [] = {"Apartment", "Detached Home", "Attached Home", "Townhouse"};
    private String furnst [] = {"Yes", "No"};
    private String q[] = {"NE", "SW", "SE", "NW"};
    private JButton RegisterBtn= new JButton("Register a Property");
    private JButton ListingsBtn= new JButton("Listings");
    private JButton MessagesBtn= new JButton("Messages");
    private JButton AddPropBtn= new JButton("Add Property");
    private JComboBox typeBox = new JComboBox(types);
    private JComboBox furn = new JComboBox(furnst);
    private JTextField bedroomnum = new JTextField("Enter in Numeric Form");
    private JTextField bathroomnum = new JTextField("Enter in Numeric Form");
    private JComboBox quadrants = new JComboBox(q);
    private Color back = new Color(25, 25, 112);
    private Color button = new Color(0,0,0);
    private Color tableBack = new Color(31,97,141);
    private Color headBack = new Color(21,67,96);

    public RegisterPropertyView()
    {
        draw();
    }

    @Override
    public void draw()
    {

    frame.setTitle("Register Properties");  //Giving frame the size set and title
    frame.setResizable(true);
    frame.setSize(900,900);

    JPanel navBarpanel = new JPanel(); //Setting navbar sizes and adding buttons to it
    navBarpanel.add(RegisterBtn);
    navBarpanel.add(ListingsBtn);
    navBarpanel.add(MessagesBtn);
    navBarpanel.setSize(frame.getWidth(),50);
    RegisterBtn.setBounds(0,0,166,50);
    ListingsBtn.setBounds(166,0,167,50);
    MessagesBtn.setBounds(333,0,167,50);
    navBarpanel.setLayout(new GridLayout());


    AddPropBtn.setBounds(380, 800, 150, 50);  //Register Prop Button implemented


    RegisterBtn.setBackground(button);
    ListingsBtn.setBackground(button);
    MessagesBtn.setBackground(button);
    RegisterBtn.setForeground(Color.WHITE);
    ListingsBtn.setForeground(Color.WHITE);
    MessagesBtn.setForeground(Color.WHITE);
    AddPropBtn.setBackground(button);
    AddPropBtn.setForeground(Color.white);


    JLabel type =  new JLabel("Type"); //Making the labels for the inputs
    type.setBounds(150, 200, 150, 20);
    type.setForeground(Color.white);
    JLabel NumBeds = new JLabel("Number of Bedrooms");
    NumBeds.setBounds(110, 450, 150, 20);
    NumBeds.setForeground(Color.white);
    JLabel furnishStat = new JLabel("Furnished");
    furnishStat.setBounds(640, 200, 150, 20);
    furnishStat.setForeground(Color.white);
    JLabel NumBath = new JLabel("Number of Bathrooms");
    NumBath.setBounds(600, 450, 150, 20);
    NumBath.setForeground(Color.white);
    JLabel quad = new JLabel("Quadrant");
    quad.setBounds(420, 600, 150, 50);
    quad.setForeground(Color.white);


    typeBox.setBounds(70, 230, 200, 40); //added input for types
    typeBox.setBackground(tableBack);
    typeBox.setForeground(Color.white);
    furn.setBounds(560, 230, 200, 40); //added input for furnished status
    furn.setBackground(tableBack);
    furn.setForeground(Color.white);
    bedroomnum.setBounds(70, 480, 200, 40); //added input for bedroom number
    bedroomnum.setBackground(tableBack);
    bedroomnum.setForeground(Color.white);
    bathroomnum.setBounds(560,480, 200,40); //added input for number of bathrooms
    bathroomnum.setBackground(tableBack);
    bathroomnum.setForeground(Color.white);
    quadrants.setBounds(340, 640, 200, 40); //added quadrant input
    quadrants.setBackground(tableBack);
    quadrants.setForeground(Color.white);

    frame.add(AddPropBtn); //adding add property button to frame
    frame.add(type); //adding type label to frame
    frame.add(furnishStat); //adding furnish label to frame
    frame.add(NumBeds); //adding numbeds label to frame
    frame.add(NumBath); //adding bathroom label to frame
    frame.add(quadrants); //adding quadrants input to frame
    frame.add(bathroomnum); // added bathroom num input to frame
    frame.add(bedroomnum); //added bedroom num input to frame
    frame.add(quad); //adding quadrant label to frame
    frame.add(navBarpanel); //adding navbar to frame to frame
    frame.getContentPane().setBackground(back);

    frame.add(typeBox); //adding the type selector input to frame
    frame.add(furn);
    frame.setLayout(null);
    frame.setResizable(true);
    frame.setVisible(true);
    }


    public static void main(String[] args) {
        RegisterPropertyView x = new RegisterPropertyView();

    }
    

    public void RegisterPerformed(ActionListener a) //For register property navbar redirect
    {
        this.RegisterBtn.addActionListener(a);
    }

    public void ListingsPerformed(ActionListener a) // For Listings navbar redirect
    {
        this.ListingsBtn.addActionListener(a);
    }

    public void MessagesPerformed(ActionListener a) //For messages navbar redirect
    {
        this.MessagesBtn.addActionListener(a);
    }

    public void AddPropPerformed(ActionListener a) //To submit the form and register a property
    {
        this.AddPropBtn.addActionListener(a);
    }

    public String getTypeInput()
    {
        return (String)typeBox.getSelectedItem();
    }

    public boolean getFurn()
    {
        return Boolean.parseBoolean((String)furn.getSelectedItem());
    }
    
    public String getQuadrant()
    {
        return (String)quadrants.getSelectedItem();
    }

    public int getBathNum() {
    	return Integer.parseInt(bathroomnum.getText());
    	}

    public int getBedNum() {return Integer.parseInt(bedroomnum.getText());}

	public void clearFrame() {
	frame.getContentPane().removeAll();
	}
}
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
    private JButton RegisterBtn= new JButton("Register a Property");
    private JButton ListingsBtn= new JButton("Listings");
    private JButton MessagesBtn= new JButton("Messages");
    private JButton AddPropBtn= new JButton("Add Property");

    RegisterPropertyView()
    {
        draw();
    }

    @Override
    public void draw()
    {
    JFrame mainFrame = new JFrame();
    mainFrame.setTitle("Register Properties");  //Giving frame the size set and title
    mainFrame.setResizable(true);
    mainFrame.setSize(900,900);

    JPanel navBarpanel = new JPanel(); //Setting navbar sizes and adding buttons to it
    navBarpanel.add(RegisterBtn);
    navBarpanel.add(ListingsBtn);
    navBarpanel.add(MessagesBtn);
    navBarpanel.setSize(mainFrame.getWidth(),50);
    RegisterBtn.setBounds(0,0,166,50);
    ListingsBtn.setBounds(166,0,167,50);
    MessagesBtn.setBounds(333,0,167,50);
    navBarpanel.setLayout(new GridLayout());


    AddPropBtn.setBounds(380, 800, 150, 50);  //Register Prop Button implemented
    AddPropBtn.setBackground(Color.GRAY);


    JLabel type =  new JLabel("Type"); //Making the labels for the inputs
    type.setBounds(150, 200, 150, 20);
    JLabel NumBeds = new JLabel("Number of Bedrooms");
    NumBeds.setBounds(150, 450, 150, 20);
    JLabel furnishStat = new JLabel("Furnished");
    furnishStat.setBounds(640, 200, 150, 20);
    JLabel NumBath = new JLabel("Number of Bathrooms");
    NumBath.setBounds(640, 450, 150, 20);
    JLabel quad = new JLabel("Quadrant");
    quad.setBounds(420, 600, 150, 50);






    mainFrame.add(AddPropBtn); //adding add property button to frame
    mainFrame.add(type); //adding type label to frame
    mainFrame.add(furnishStat); //adding furnish label to frame
    mainFrame.add(NumBeds); //adding numbeds label to frame
    mainFrame.add(NumBath); //adding bathroom label to frame
    mainFrame.add(quad); //adding quadrant label to frame
    mainFrame.add(navBarpanel); //adding navbar to frame to frame
    mainFrame.setLayout(null);
    mainFrame.setResizable(true);
    mainFrame.setVisible(true);
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
}

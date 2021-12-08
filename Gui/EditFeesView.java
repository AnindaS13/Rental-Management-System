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

public class EditFeesView implements Component{

    private JButton RenterLandlordBtn = new JButton("Renter/Landlord List");
    private JButton ListingsBtn= new JButton("Listings");
    private JButton SumRepBtn = new JButton("Summary Report");
    private JButton editFeeBtn = new JButton("Edit Fees");
    private JLabel editFeeLabel = new JLabel("Enter the new fee ($):");
    private JLabel editPeriodLabel = new JLabel("Enter the new period (days):");
    private JTextField fee= new JTextField(10);
    private JTextField per = new JTextField(10);
    private JButton subChanges = new JButton("Submit");

    public EditFeesView()
    {

        draw();
    }

    @Override
    public void draw()
    {
        frame.setTitle("Edit Fee and Period");  //Giving frame the size set and title
        frame.setResizable(true);
        frame.setSize(900,900);

        JPanel navBarpanel = new JPanel(); //Setting navbar sizes and adding buttons to it
        navBarpanel.add(RenterLandlordBtn);
        navBarpanel.add(ListingsBtn);
        navBarpanel.add(SumRepBtn);
        navBarpanel.add(editFeeBtn);
        navBarpanel.setSize(frame.getWidth(),50);
        navBarpanel.setLayout(new GridLayout());

        editFeeLabel.setBounds(200,200,300,30);
        editFeeLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        editPeriodLabel.setBounds(200, 400, 300, 30);
        editPeriodLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        fee.setBounds(450,200,300,50);
        per.setBounds(500,400,300,50);
        fee.setFont(new Font("Serif", Font.PLAIN, 20));
        per.setFont(new Font("Serif", Font.PLAIN, 20));

        subChanges.setBounds(300, 600,300,50);

        frame.add(navBarpanel);
        frame.add(editPeriodLabel);
        frame.add(subChanges);
        frame.add(editFeeLabel);
        frame.add(fee);
        frame.add(per);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String []args)
    {
    EditFeesView x = new EditFeesView();
    }
}

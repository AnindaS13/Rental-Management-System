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

    private Color back = new Color(25, 25, 112);
    private Color button = new Color(0,0,0);


    public EditFeesView()
    {

        draw();
    }

    @Override
    public void draw()
    {

        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

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
        editFeeLabel.setForeground(Color.white);
        editPeriodLabel.setForeground(Color.white);

        RenterLandlordBtn.setBackground(button);
        ListingsBtn.setBackground(button);
        SumRepBtn.setBackground(button);
        editFeeBtn.setBackground(button);
        RenterLandlordBtn.setForeground(Color.WHITE);
        ListingsBtn.setForeground(Color.WHITE);
        SumRepBtn.setForeground(Color.WHITE);
        editFeeBtn.setForeground(Color.WHITE);
        subChanges.setForeground(Color.white);
        subChanges.setBackground(button);

        subChanges.setBounds(300, 600,300,50);

        frame.getContentPane().setBackground(back);
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

    public void renterLandlordPerformed(ActionListener a) //For register property navbar redirect
    {
        this.RenterLandlordBtn.addActionListener(a);
    }

    public void ListingsPerformed(ActionListener a) // For Listings navbar redirect
    {
        this.ListingsBtn.addActionListener(a);
    }

    public void SummaryReportPerformed(ActionListener a) //For messages navbar redirect
    {
        this.SumRepBtn.addActionListener(a);
    }

    public void EditFeesPerformed (ActionListener a)
    {
        this.editFeeBtn.addActionListener(a);
    }

    public void updateStatus (ActionListener a)
    {
        this.subChanges.addActionListener(a);
    }
}

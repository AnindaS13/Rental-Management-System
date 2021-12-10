package Gui;

import Model.Landlord;
import Model.RegisteredRenter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class DisplayUsersManagerView implements Component{
    private JButton RenterLandlordBtn = new JButton("Renter/Landlord List");
    private JButton ListingsBtn= new JButton("Listings");
    private JButton SumRepBtn = new JButton("Summary Report");
    private JButton editFeeBtn = new JButton("Edit Fees");

    private JLabel landlordHeader = new JLabel("Here is the list of all landlords:");
    private JLabel renterHeader = new JLabel("Here is the list of all renters:");
    private JTable landlordTable = new JTable();
    private JTable renterTable = new JTable();

    private JScrollPane RenterscrollPane = new JScrollPane();
    private JScrollPane LandlordscrollPane = new JScrollPane();

    private Color back = new Color(25, 25, 112);
    private Color bord = new Color(106,164,216);
    private Color button = new Color(0,0,0);
    private Color tableBack = new Color(31,97,141);
    private Color headBack = new Color(21,67,96);
    
    public DisplayUsersManagerView() {}
    
    public DisplayUsersManagerView(ArrayList<Landlord> landinput, ArrayList<RegisteredRenter> rentinput)
    {
        setLandlordTable(landinput);
        setRenterTable(rentinput);
        //draw();
    }


    @Override
    public void draw()
    {


        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

        frame.setTitle("List of Landlords and Renters");  //Giving frame the size set and title
        frame.setResizable(true);
        frame.setSize(900,900);

        JPanel navBarpanel = new JPanel();
        navBarpanel.setOpaque(false);
        navBarpanel.add(RenterLandlordBtn);
        navBarpanel.add(ListingsBtn);
        navBarpanel.add(SumRepBtn);
        navBarpanel.add(editFeeBtn);
        navBarpanel.setSize(frame.getWidth(),50);
        navBarpanel.setLayout(new GridLayout());

        RenterLandlordBtn.setBackground(button);
        ListingsBtn.setBackground(button);
        SumRepBtn.setBackground(button);
        editFeeBtn.setBackground(button);
        RenterLandlordBtn.setForeground(Color.WHITE);
        ListingsBtn.setForeground(Color.WHITE);
        SumRepBtn.setForeground(Color.WHITE);
        editFeeBtn.setForeground(Color.WHITE);

        landlordTable.setBounds(220,200,500,200);
        renterTable.setBounds(220,100,500,200);
        landlordTable.setRowHeight(20);
        renterTable.setRowHeight(20);
        RenterscrollPane.setViewportView(renterTable);
        RenterscrollPane.setBounds(200,500,500,200);
        LandlordscrollPane.setViewportView(landlordTable);
        LandlordscrollPane.setBounds(200,200,500,200);



        landlordTable.setBackground(tableBack);
        renterTable.setBackground(tableBack);
        landlordTable.setForeground(Color.white);
        renterTable.setForeground(Color.white);
        landlordTable.getTableHeader().setBackground(headBack);
        renterTable.getTableHeader().setBackground(headBack);
        landlordTable.getTableHeader().setForeground(Color.white);
        renterTable.getTableHeader().setForeground(Color.white);

        landlordHeader.setForeground(Color.white);
        renterHeader.setForeground(Color.white);
        landlordHeader.setBounds(200,170,200,30);
        renterHeader.setBounds(200,470,200,30);

        frame.getContentPane().setBackground(back);
        frame.getContentPane().add(RenterscrollPane);
        frame.getContentPane().add(LandlordscrollPane);
        frame.add(landlordHeader);
        frame.add(renterHeader);
        frame.add(navBarpanel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void setLandlordTable(ArrayList<Landlord> landinput)
    {
        Object columnNames[] = {"Email", "First Name", "Last Name"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for(int i = 0; i < landinput.size(); i++)
        {
            Object rowData [] = {landinput.get(i).getEmail(),landinput.get(i).getFName(),landinput.get(i).getLName()};
            model.addRow(rowData);
        }
        landlordTable.setModel(model);
    }

    public void setRenterTable(ArrayList<RegisteredRenter> rentinput)
    {
        Object columnNames[] = {"Email", "First Name", "Last Name"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for(int i = 0; i < rentinput.size(); i++)
        {
            Object rowData [] = {rentinput.get(i).getEmail(),rentinput.get(i).getFName(),rentinput.get(i).getLName()};
            model.addRow(rowData);
        }
        renterTable.setModel(model);
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

    public void renterLandlordPerformed(ActionListener a) //For register property navbar redirect
    {
        this.RenterLandlordBtn.addActionListener(a);
    }

//    public static void main(String []args)
//    {
//        ArrayList<Landlord> x = new ArrayList<Landlord>();
//        x.add(new Landlord("bob@gmail.com", "123456", "Bob", "Miller","Landlord", 123, "Hi"));
//        x.add(new Landlord("jane@gmail.com", "23232", "Jane", "Doe","Landlord", 323, "Eee"));
//        ArrayList<RegisteredRenter> r = new ArrayList<RegisteredRenter>();
//        r.add(new RegisteredRenter("john@gmail.com", "434343", "John", "Doe", "Renter", "apt", 3,5,true, "NE"));
//        r.add(new RegisteredRenter("ralph@gmail.com", "76745", "Ralph", "Griffin", "Renter", "apt", 3,5,true, "SW"));
//
//        DisplayUsersManagerView item = new DisplayUsersManagerView(x,r);
//    }


}

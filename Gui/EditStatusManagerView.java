package Gui;

import Model.Listing;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EditStatusManagerView implements Component{
    private ArrayList<Listing> listings = new ArrayList<Listing>();
    List<String[]> values = new ArrayList<String[]>();
    private JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane();
    private JButton RenterLandlordBtn = new JButton("Renter/Landlord List");
    private JButton ListingsBtn= new JButton("Listings");
    private JButton SumRepBtn = new JButton("Summary Report");
    private JButton editFeeBtn = new JButton("Edit Fees");
    private JTextField idVal= new JTextField();
    private JLabel idOfProp = new JLabel("Enter the the ID of the property you wish to edit the status for:");
    private JButton submitChange = new JButton("Submit");
    private JLabel changedStatus = new JLabel("Enter the new status for the property:");
    private JTextField statusVal = new JTextField();
    private Color back = new Color(25, 25, 112);
    private Color button = new Color(0,0,0);
    private Color tableBack = new Color(31,97,141);
    private Color headBack = new Color(21,67,96);

    
    public EditStatusManagerView()
    {
    }

    public EditStatusManagerView(ArrayList<Listing> input)
    {
        setTable(input);
        //draw();
    }
	
    public void clearFrame() {
    	frame.getContentPane().removeAll();
    }
    
    public void setTable(ArrayList<Listing> input)
    {
        Object columnNames[] = { "Property ID", "Type", "Bedrooms", "Bathrooms", "Furnished", "Quadrant", "Status", "Balance"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for(int i=0; i< input.size(); i++) {
            Object rowData[] = {input.get(i).getListingID(), input.get(i).getPropertyType(),
                    input.get(i).getNumbedRooms(), input.get(i).getNumbathRooms(),
                    input.get(i).getIsFurnished(), input.get(i).getQuadrant(), input.get(i).getStatus(),
                    input.get(i).getBalance()};
            model.addRow(rowData);
        }
        table.setModel(model);
        System.out.println("here");
        System.out.println("here");
    }

    @Override
    public void draw()
    {	
    	frame.getContentPane().removeAll();
        frame.setTitle("Listings and Edit Manager");  //Giving frame the size set and title
        frame.setResizable(true);
        frame.setSize(900,900);

        JPanel navBarpanel = new JPanel(); //Setting navbar sizes and adding buttons to it
        navBarpanel.add(RenterLandlordBtn);
        navBarpanel.add(ListingsBtn);
        navBarpanel.add(SumRepBtn);
        navBarpanel.add(editFeeBtn);
        navBarpanel.setSize(frame.getWidth(),50);
        navBarpanel.setLayout(new GridLayout());

        idOfProp.setBounds(50,600,400,20);
        idVal.setBounds(50,620,400,30);
        changedStatus.setBounds(50,660,400,20);
        statusVal.setBounds(50,680,400,30);
        submitChange.setBounds(50, 730,400,30);

        idOfProp.setForeground(Color.white);
        changedStatus.setForeground(Color.white);

        RenterLandlordBtn.setBackground(button);
        ListingsBtn.setBackground(button);
        SumRepBtn.setBackground(button);
        editFeeBtn.setBackground(button);
        RenterLandlordBtn.setForeground(Color.WHITE);
        ListingsBtn.setForeground(Color.WHITE);
        SumRepBtn.setForeground(Color.WHITE);
        editFeeBtn.setForeground(Color.WHITE);
        submitChange.setBackground(button);
        submitChange.setForeground(Color.white);

        table.setBounds(30,200,500,300);
        table.setBackground(tableBack);
        table.setForeground(Color.white);
        table.getTableHeader().setBackground(headBack);
        table.getTableHeader().setForeground(Color.white);
        table.setRowHeight(20);
        scrollPane.setViewportView(table);
        scrollPane.setBounds(30, 238, 800, 300);
        frame.getContentPane().add(scrollPane);
        frame.getContentPane().setBackground(back);
        frame.add(navBarpanel);
        frame.add(idOfProp);
        frame.add(statusVal);
        frame.add(idVal);
        frame.add(changedStatus);
        frame.add(submitChange);
        frame.setLayout(null);
       //frame.setVisible(true);
    }

    public static void main(String []args)
    {
        ArrayList <Listing> in = new ArrayList<Listing>();
        in.add(new Listing(1, "Apartment", 4, 5, true, "NE", "10:10", "10 5th Ave",  "johndoe@gmail.com", "Active", true));
        in.add(new Listing(2, "Apartment", 2, 2, true, "SW", "10:10", "20 9th Ave", "johndoe@gmail.com", "Active", true));
        EditStatusManagerView x = new EditStatusManagerView(in);
        Listing obj = new Listing(2, "Apartment", 2, 2, true, "SW", "10:10", "206 9th Ave", "johndoe@gmail.com", "Active", true);
        System.out.println(obj.getID());
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


    public void updateStatus(ActionListener a)
    {
        this.submitChange.addActionListener(a);
    }

}

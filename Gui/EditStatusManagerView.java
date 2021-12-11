package Gui;

import Model.Listing;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * This class is responsible for the edit status manager view.
 * This view contains a table which contains all the properties in the database that are registered
 * and displays them to the manager. The manager can edit the status of the listings as they see fit.
 */
public class EditStatusManagerView implements Component{
    private ArrayList<Listing> listings = new ArrayList<Listing>();  //Most of these variables are for the GUI components being added to the frame
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

    private String[] statuses = {"Active", "Canceled", "Suspended", "Rented"};
    private JComboBox StatusList = new JComboBox(statuses);
    
    public EditStatusManagerView()
    {
    }

    public EditStatusManagerView(ArrayList<Listing> input) //The constructor gets an arraylist of all registered properties to pass it to et a table with it for the view
    {
        setTable(input);
        draw();
    }
	
    public void clearFrame() {
    	frame.getContentPane().removeAll();
    }
    
    public void setTable(ArrayList<Listing> input) //This function is setting the table with the value of the arraylist of all properties
    {
        Object columnNames[] = { "Property ID", "Type", "Bedrooms", "Bathrooms", "Furnished", "Quadrant", "Status", "Balance"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table.setModel(model);
        for(int i=0; i< input.size(); i++) {
            Object rowData[] = {input.get(i).getListingID(), input.get(i).getPropertyType(),
                    input.get(i).getNumbedRooms(), input.get(i).getNumbathRooms(),
                    input.get(i).getIsFurnished(), input.get(i).getQuadrant(), input.get(i).getStatus(),
                    input.get(i).getBalance()};
            model.addRow(rowData);
        }
        table.setModel(model);
    }

    @Override
    public void draw() //This function is adding all the GUI compoenents to the frame
    {


        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

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
        StatusList.setBounds(50,680,400,30);
        //statusVal.setBounds(50,680,400,30);
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
        //frame.add(statusVal);
        frame.add(idVal);
        frame.add(changedStatus);
        frame.add(StatusList);
        frame.add(submitChange);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    /**
     * Below are a few action listeners for the navbars and for the submit changes button for the status change
     */
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

    /**
     * Below are some getters used by the controller and DB to get the values in the input fields and used them to update
     */
    public String getEnteredStatus()
    {
        return (String)StatusList.getSelectedItem();
    }

    public String getIdEntered()
    {
        return idVal.getText();
    }
}

package Gui;
import Model.Listing;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.User;

/**
 * The summary report view is for the manager.
 * In this view the manager can see all the total number of listings pertainin to a certain period.
 * Furthermore, they get the total number of active listings and rented houses in a period
 */
public class SummaryReportView implements Component{ 
    List<String[]> values = new ArrayList<String[]>();
    private JTable table = new JTable();                    //Below are a lot of the gui components which are instantiated here
    private JScrollPane scrollPane = new JScrollPane();

    private JTextField numHousesListedField = new JTextField("listed");
    private JTextField numHousesRentedField = new JTextField("rented");
    private JTextField numActiveListingsField = new JTextField("active");

    private JComboBox timePeriodField = new JComboBox();

    private ArrayList<User> landlords;
    private ArrayList<ArrayList<Listing>> listings;

    private int totalNumHousesListed;
    private int totalNumHousesRented;
    private int totalNumActiveListings;

    private int timePeriod;

    private JButton timePeriodBtn= new JButton("Submit");
    private JButton RenterLandlordBtn = new JButton("Renter/Landlord List");
    private JButton ListingsBtn= new JButton("Listings");
    private JButton SumRepBtn = new JButton("Summary Report");
    private JButton editFeeBtn = new JButton("Edit Fees");
    private Color button = new Color(0,0,0);
    private Color back = new Color(25, 25, 112);


    public SummaryReportView() {}
    
    public SummaryReportView(ArrayList<ArrayList<Listing>> listings, ArrayList<User> landlords ) //The report is passed an array of landlords and listings to display appropriate  data on the report and table 
    {
//        setLandlords(landlords);
//        setListings(listings);
//        setNumActiveListingsField(5);
//        setNumHousesRentedField(8);
//        setNumHousesListedField(5);
        setTable(listings, landlords);
        draw();
    }

    public void setTable(ArrayList<ArrayList<Listing>> listings, ArrayList<User> landlords) //This sets the table to display the landlords and the listings according to them for the report
    {
        Object columnNames[] = { "Property ID", "Landlord", "Address", "Status", "Period"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for(int i=0; i < landlords.size(); i++) {
            for(int j = 0; j < listings.get(i).size(); j++) {
                Object rowData[] = { listings.get(i).get(j).getListingID(), landlords.get(i).getFName() + " " + landlords.get(i).getLName(), listings.get(i).get(j).getAddress(),listings.get(i).get(j).getStatus(), listings.get(i).get(j).getListingTime() };
                model.addRow(rowData);
            }
        }
        table.setModel(model);
    }

    @Override
    public void draw() { //Adds all the gui components to the frame
    	
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
        
        frame.setTitle("Edit Status");  //Giving frame the size set and title
        frame.setResizable(true);
        frame.setSize(900,900);

        JPanel navBarpanel = new JPanel(); //Setting navbar sizes and adding buttons to it
        navBarpanel.add(RenterLandlordBtn);
        navBarpanel.add(ListingsBtn);
        navBarpanel.add(SumRepBtn);
        navBarpanel.add(editFeeBtn);
        navBarpanel.setSize(frame.getWidth(),50);
        navBarpanel.setLayout(new GridLayout());

        JLabel totalHousesRented = new JLabel("Total Number of Houses Rented:");
        JLabel totalHouseListedLabel = new JLabel("Total Number of Houses Listed:");
        JLabel totalActiveListingsLabel = new JLabel("Total Number of active listings");
        JLabel selectTimePeriodLabel = new JLabel("Choose Time Period(Days)");

        selectTimePeriodLabel.setForeground(Color.WHITE);
        selectTimePeriodLabel.setForeground(Color.WHITE);
        selectTimePeriodLabel.setBounds(50,85,200,20);
        frame.getContentPane().add(selectTimePeriodLabel);


        totalHousesRented.setForeground(Color.WHITE);
        totalHouseListedLabel.setForeground(Color.white);
        totalActiveListingsLabel.setForeground(Color.white);
        totalHouseListedLabel.setBounds(50,460,400,20);
        numHousesListedField.setBounds(50,480,400,30);
        totalHousesRented.setBounds(50,530,400,20);
        numHousesRentedField.setBounds(50,550,400,30);

        totalActiveListingsLabel.setBounds(540,460,300,20);
        numActiveListingsField.setBounds(540,490,300,30);

        timePeriodField.setModel(new DefaultComboBoxModel(new String[] {"60", "120", "180"}));
        timePeriodField.setBackground(button);
        timePeriodField.setFont(new Font("SansSerif", Font.PLAIN, 15));
        timePeriodField.setBounds(240, 80, 130, 40);
        timePeriodField.setForeground(Color.WHITE);
        frame.getContentPane().add(timePeriodField);

        numActiveListingsField.setEditable(false);
        numHousesListedField.setEditable(false);
        numHousesRentedField.setEditable(false);

        RenterLandlordBtn.setBackground(button);
        ListingsBtn.setBackground(button);
        SumRepBtn.setBackground(button);
        editFeeBtn.setBackground(button);
        RenterLandlordBtn.setForeground(Color.WHITE);
        ListingsBtn.setForeground(Color.WHITE);
        SumRepBtn.setForeground(Color.WHITE);
        editFeeBtn.setForeground(Color.WHITE);

        table.setBounds(30,100,500,300);
        table.setRowHeight(20);
        scrollPane.setViewportView(table);
        scrollPane.setBounds(30, 150, 800, 300);
        frame.getContentPane().add(scrollPane);
        frame.add(navBarpanel);
        frame.add(numActiveListingsField);
        frame.add(totalActiveListingsLabel);
        frame.add(totalHouseListedLabel);
        frame.add(numHousesRentedField);
        frame.add(numHousesListedField);
        frame.getContentPane().setBackground(back);

        frame.add(totalHousesRented);
        frame.setLayout(null);
        frame.setVisible(true);

        timePeriodBtn.setBackground(button);
        timePeriodBtn.setBounds(400, 80, 130, 40);
        timePeriodField.setForeground(Color.WHITE);
        // frame.add(timePeriodBtn);
        System.out.println("in draw");
    }

    /**
     * Below are many action liseneters for the various events going on in the page
     */
    public void ListingsPerformed(ActionListener a) // For Listings navbar redirect
    {
        this.ListingsBtn.addActionListener(a);
    }

    public void timePeriodPerformed(ActionListener a) //For messages navbar redirect
    {
        this.timePeriodBtn.addActionListener(a);
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

    public void TimePeriodPerformed (ActionListener a)
    {
        this.timePeriodField.addActionListener(a);
    }

    /**
     * Getters and setters are below for the database and controllers to use to edit and update info
     */
    public int getTotalNumHousesListed() {
        return totalNumHousesListed;
    }

    public void setTotalNumHousesListed(int totalNumHousesListed) {
        this.totalNumHousesListed = totalNumHousesListed;
    }

    public int getTotalNumHousesRented() {
        return totalNumHousesRented;
    }

    public void setTotalNumHousesRented(int totalNumHousesRented) {
        this.totalNumHousesRented = totalNumHousesRented;
    }

    public int getTotalNumActiveListings() {
        return totalNumActiveListings;
    }

    public void setTotalNumActiveListings(int totalNumActiveListings) {
        this.totalNumActiveListings = totalNumActiveListings;
    }


    public String getNumHousesListedField() {
        return (String) this.numHousesListedField.getText();
    }

    public void setNumHousesListedField(int numHousesListedField) {
        this.numHousesListedField.setText(Integer.toString(numHousesListedField));
    }

    public int getNumHousesRentedField() {
        return Integer.parseInt(this.numHousesRentedField.getText());
    }

    public void setNumHousesRentedField(int numHousesRentedField) {
        this.numHousesRentedField.setText(Integer.toString(numHousesRentedField));
    }

    public int getNumActiveListingsField() {
        return Integer.parseInt((String) this.numActiveListingsField.getText());
    }

    public void setNumActiveListingsField(int numActiveListingsField) {
        this.numActiveListingsField.setText(Integer.toString(numActiveListingsField));
    }

    public ArrayList<User> getLandlords() {
        return landlords;
    }

    public void setLandlords(ArrayList<User> landlords) {
        this.landlords = landlords;
    }

    public ArrayList<ArrayList<Listing>> getListings() {
        return listings;
    }

    public void setListings(ArrayList<ArrayList<Listing>> listings) {
        this.listings = listings;
    }

    public int getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }

    public int getTimePeriodField() {
        return Integer.parseInt((String) timePeriodField.getSelectedItem());
    }

    public void setTimePeriodField(int timePeriodField) {
        this.timePeriodField.setSelectedItem(timePeriodField);
    }

    public void repaint() {
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

    }

}

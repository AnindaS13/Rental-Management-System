package Gui;
import Model.Listing;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.User;

public class SummaryReportView implements Component{
    List<String[]> values = new ArrayList<String[]>();
    private JTable table = new JTable();
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

    private JButton RenterLandlordBtn = new JButton("Renter/Landlord List");
    private JButton ListingsBtn= new JButton("Listings");
    private JButton SumRepBtn = new JButton("Summary Report");
    private JButton editFeeBtn = new JButton("Edit Fees");
    private Color button = new Color(0,0,0);
    private Color back = new Color(25, 25, 112);


    public SummaryReportView(ArrayList<ArrayList<Listing>> listings, ArrayList<User> landlords )
    {
//        setLandlords(landlords);
//        setListings(listings);
//        setNumActiveListingsField(5);
//        setNumHousesRentedField(8);
//        setNumHousesListedField(5);
        setTable(listings, landlords);
        draw();
    }

    public void setTable(ArrayList<ArrayList<Listing>> listings, ArrayList<User> landlords)
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
    public void draw() {
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
        System.out.println("in draw");
    }

    public static void main(String []args)
    {
        ArrayList<ArrayList<Listing>> listings = new ArrayList<>();
        ArrayList<User> landlords = new ArrayList<>();
        ArrayList<Listing> a = new ArrayList<>();
        ArrayList<Listing> b = new ArrayList<>();

        a.add(new Listing(1, "Apartment", 4, 5, true, "NE", "10:10", "house1", "johndoe@gmail.com", "Active", true));
        a.add(new Listing(2, "Dupplex", 6, 2, false, "NE", "10:10","house1", "jeff@gmail.com", "Active", true));
        b.add(new Listing(3, "Dupplex", 8, 3, false, "NW", "10:10","house1", "bob@gmail.com", "Active", true));


        listings.add(a);
        listings.add(b);

        landlords.add(new User("email", "pass", "john", "doe", "landlord"));
        landlords.add(new User("jeff@gmail.com", "jeff", "Jeff", "B", "Renter"));

        SummaryReportView x = new SummaryReportView(listings, landlords);
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

    public void renterLandlordPerformed(ActionListener a) //For register property navbar redirect
    {
        this.RenterLandlordBtn.addActionListener(a);
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

}
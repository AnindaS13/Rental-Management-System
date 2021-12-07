package Gui;

import Model.Listing;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// move code from functions to class level for access (variables and functions that need to be accesed
// make getters and setters for those variables
// make actionlisteners too

public class RenterListingView implements Component {
    private ArrayList<Listing> listings = new ArrayList<Listing>();
    List<String[]> values = new ArrayList<String[]>();

    private JComboBox PropertyType = new JComboBox();
    private JComboBox bedrooms = new JComboBox();
    private JComboBox bathrooms = new JComboBox();
    private JComboBox quadrant = new JComboBox();
    private JComboBox furnished = new JComboBox();
    private JButton search = new JButton("Search");

    public RenterListingView() {
        listings.add(new Listing("Apartment", 4,4, true, "ne", 10, "Landlord"));
        listings.add(new Listing("House", 4,4, true, "ne", 10, "Landlord"));
        for(int row = 0; row < listings.size(); row++) {
                String id = Integer.toString(listings.get(row).getListingID());
                String type = listings.get(row).getPropertyType();
                String bedrooms =  Integer.toString(listings.get(row).getNumbedRooms());
                String bathrooms =  Integer.toString(listings.get(row).getNumbathRooms());
                String furnished = Boolean.toString(listings.get(row).getIsFurnished());
                String quadrant = listings.get(row).getQuadrant();
                values.add(new String[] { id, type, bedrooms,  bathrooms, furnished,   quadrant});
        }
        draw();
    }

    public void returnSearch(ActionListener actionListener) {
        this.search.addActionListener(actionListener);
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
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when u close, makes the default close operation to exit the frame
        frame.setLocation(dim.width/2-250, dim.height/2-250); //setting location of where the applicatio
        frame.setSize(900,900);
        frame.getContentPane().setForeground(new Color(255, 255, 255));
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 238, 466, 215);
        frame.getContentPane().add(scrollPane);

        JTable table = new JTable();
        table.setBackground(new Color(255, 255, 255));
        table.setModel(new DefaultTableModel(values.toArray(new Object[][] {}),
                new String[] {
                        "Property ID", "Type", "Bedrooms", "Bathrooms", "Furnished", "Quadrant"
                }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(65);
        table.getColumnModel().getColumn(1).setPreferredWidth(90);
        table.getColumnModel().getColumn(2).setPreferredWidth(63);
        table.getColumnModel().getColumn(3).setPreferredWidth(66);
        table.getColumnModel().getColumn(4).setPreferredWidth(55);
        table.getColumnModel().getColumn(5).setPreferredWidth(52);
        scrollPane.setViewportView(table);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(255, 255, 255));
        titlePanel.setBounds(0, 0, 486, 82);
        frame.getContentPane().add(titlePanel);
        titlePanel.setLayout(null);

        JLabel Title = new JLabel("Browse Properties");
        Title.setBounds(135, 20, 100, 100);
        Title.setForeground(new Color(255, 255, 255));
        titlePanel.add(Title);
        Title.setFont(new Font("SansSerif", Font.BOLD, 24));

        PropertyType.setModel(new DefaultComboBoxModel(new String[] {"Apartment", "Townhouse", "Duplex", "Condo", "Studio", "Basement"}));
        PropertyType.setBackground(backgroundColor);
        PropertyType.setFont(new Font("SansSerif", Font.PLAIN, 12));
        PropertyType.setBounds(10, 192, 73, 21);
        PropertyType.setForeground(foreGroundColor);
        frame.getContentPane().add(PropertyType);

        bedrooms.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,7,8}));
        bedrooms.setFont(new Font("SansSerif", Font.PLAIN, 12));
        bedrooms.setBackground(backgroundColor);
        bedrooms.setBounds(108, 192, 67, 21);
        bedrooms.setForeground(foreGroundColor);
        frame.getContentPane().add(bedrooms);

        bathrooms.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8}));
        bathrooms.setFont(new Font("SansSerif", Font.PLAIN, 12));
        bathrooms.setBackground(backgroundColor);
        bathrooms.setBounds(196, 192, 60, 21);
        bathrooms.setForeground(foreGroundColor);
        frame.getContentPane().add(bathrooms);

        quadrant.setModel(new DefaultComboBoxModel(new String[] {"NW", "SW", "NE", "SE"}));
        quadrant.setFont(new Font("SansSerif", Font.PLAIN, 12));
        quadrant.setBackground(backgroundColor);
        quadrant.setBounds(374, 193, 88, 21);
        quadrant.setForeground(foreGroundColor);
        frame.getContentPane().add(quadrant);

        furnished.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
        furnished.setFont(new Font("SansSerif", Font.PLAIN, 12));
        furnished.setBounds(280, 193, 88, 21);
        furnished.setBackground(backgroundColor);
        furnished.setForeground(foreGroundColor);
        frame.getContentPane().add(furnished);

        JLabel label1 = new JLabel("PropertyType");
        label1.setBounds(10, 168, 79, 13);
        frame.getContentPane().add(label1);

        JLabel label2 = new JLabel("Bedrooms");
        label2.setBounds(108, 168, 67, 13);
        frame.getContentPane().add(label2);

        JLabel label3 = new JLabel("Bathrooms");
        label3.setBounds(200, 168, 73, 13);
        frame.getContentPane().add(label3);

        JLabel label4 = new JLabel("Furnished");
        label4.setBounds(293, 168, 67, 13);
        frame.getContentPane().add(label4);

        JLabel label5 = new JLabel("Quadrant");
        label5.setBounds(388, 168, 88, 13);
        frame.getContentPane().add(label5);

        search.setBackground(backgroundColor);
        search.setFont(new Font("SansSerif", Font.BOLD, 12));
        search.setBounds(135, 92, 80, 30);
        search.setForeground(foreGroundColor);
        frame.getContentPane().add(search);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(dim.width/2-250, dim.height/2-250);
        frame.setSize(900,900);
        frame.setVisible(true);
    }
    
    public void searchButton(ActionListener actionListener) {
        this.search.addActionListener(actionListener);	
    }

    public ArrayList<Listing> getListings() {
        return listings;
    }

    public void setListings(ArrayList<Listing> listings) {
        this.listings = listings;
    }

    public List<String[]> getValues() {
        return values;
    }

    public void setValues(List<String[]> values) {
        this.values = values;
    }

    public String getPropertyType() {
        return (String) PropertyType.getSelectedItem();
    }

    public void setPropertyType(String propertyType) {
        PropertyType.setSelectedItem(propertyType);
    }

    public int getBedrooms() {
        return (int) bedrooms.getSelectedItem();
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms.setSelectedItem(bedrooms);
    }

    public int getBathrooms() {
        return (int)this.bathrooms.getSelectedItem();
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms.setSelectedItem(bathrooms);
    }

    public String getQuadrant() {
        return (String) quadrant.getSelectedItem();
    }

    public void setQuadrant(String quadrant) {
        this.quadrant.setSelectedItem(quadrant);
    }

    public boolean getFurnished() {
        return  Boolean.parseBoolean((String) furnished.getSelectedItem()) ;
    }

    public void setFurnished(boolean furnished) {
        if(furnished == true) {
            this.furnished.setSelectedItem("Yes");

        } else {
            this.furnished.setSelectedItem("No");

        }
    }

    public static void main(String[] args) {
        RenterListingView u = new RenterListingView();
    }
}
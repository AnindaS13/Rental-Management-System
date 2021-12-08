package Gui;

import Model.Listing;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RenterListingView implements Component {
	private ArrayList<Listing> listings = new ArrayList<Listing>();
    List<String[]> values = new ArrayList<String[]>();

    private JComboBox PropertyType = new JComboBox();
    private JComboBox bedrooms = new JComboBox();
    private JComboBox bathrooms = new JComboBox();
    private JComboBox quadrant = new JComboBox();
    private JComboBox furnished = new JComboBox();
    private JButton search = new JButton("Search");

    private JButton subscribe = new JButton("Subscribe");
    private JButton unsubscribe = new JButton("UnSubscribe");
    private JTextField message = new JTextField("Enter Message",2);
    private JTextField propertyID = new JTextField("PropertyID",2);
    private JButton sendMessageBtn = new JButton("Send");
    private JButton logOutBtn = new JButton("Log Out");
    private JButton notfiyBtn = new JButton("Found Listings");

    private String role = "";
    private Boolean notify = false;

    JTable table = new JTable();

    public RenterListingView() {
        draw();
        //setOutput();
    }
    
    public void setOutput(ArrayList<Listing> input) {
    	Object columnNames[] = { "Property ID", "Type", "Bedrooms", "Bathrooms", "Furnished", "Quadrant"};
    	DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    	
    	for(int i=0; i< input.size(); i++) {
	    	Object rowData[] = {input.get(i).getID(), input.get(i).getPropertyType(), 
	    						input.get(i).getNumbedRooms(), input.get(i).getNumbathRooms(), 
	    						input.get(i).getIsFurnished(), input.get(i).getQuadrant()};
	    	model.addRow(rowData);
    	}
    	table.setModel(model);
    }


    public void searchButton(ActionListener actionListener) {
        this.search.addActionListener(actionListener);
    }
    public void subscribeButton(ActionListener actionListener) {
        this.subscribe.addActionListener(actionListener);
    }

    public void unsubscribeButton(ActionListener actionListener) {
        this.unsubscribe.addActionListener(actionListener);
    }
    public void returnMessage(ActionListener actionListener) {
        this.sendMessageBtn.addActionListener(actionListener);
    }

    public void notifyBtn(ActionListener actionListener) {
        this.notfiyBtn.addActionListener(actionListener);
    }

    public void returnLogout(ActionListener actionListener) {
        this.logOutBtn.addActionListener(actionListener);
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

        JPanel navBarpanel = new JPanel(); //Setting navbar sizes and adding buttons to it
        navBarpanel.setSize(frame.getWidth(),50);
        logOutBtn.setBounds(800,0,100,50);
        navBarpanel.setLayout(new GridLayout());
        frame.getContentPane().add(logOutBtn);

        JLabel title = new JLabel("View Listings");
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        navBarpanel.add(title);

        frame.getContentPane().add(navBarpanel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 238, 600, 300);
        frame.getContentPane().add(scrollPane);

        //JTable table = new JTable();
        table.setBackground(new Color(255, 255, 255));
        table.setModel(new DefaultTableModel(values.toArray(new Object[][] {}),
                new String[] {
                        "Property ID", "Type", "Bedrooms", "Bathrooms", "Furnished", "Quadrant"
                }
        ));
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        scrollPane.setBounds(150, 225, 600, 300);
        scrollPane.setViewportView(table);

        PropertyType.setModel(new DefaultComboBoxModel(new String[] {"Apartment", "Townhouse", "Duplex", "Condo", "Studio", "Basement"}));
        PropertyType.setBackground(backgroundColor);
        PropertyType.setFont(new Font("SansSerif", Font.PLAIN, 15));
        PropertyType.setBounds(100, 100, 100, 40);
        PropertyType.setForeground(foreGroundColor);
        frame.getContentPane().add(PropertyType);

        bedrooms.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,7,8}));
        bedrooms.setFont(new Font("SansSerif", Font.PLAIN, 12));
        bedrooms.setBackground(backgroundColor);
        bedrooms.setBounds(250, 100, 100, 40);
        bedrooms.setForeground(foreGroundColor);
        frame.getContentPane().add(bedrooms);

        bathrooms.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8}));
        bathrooms.setFont(new Font("SansSerif", Font.PLAIN, 12));
        bathrooms.setBackground(backgroundColor);
        bathrooms.setBounds(400, 100, 100, 40);
        bathrooms.setForeground(foreGroundColor);
        frame.getContentPane().add(bathrooms);

        quadrant.setModel(new DefaultComboBoxModel(new String[] {"NE", "NW", "SE", "SW"}));
        quadrant.setFont(new Font("SansSerif", Font.PLAIN, 12));
        quadrant.setBackground(backgroundColor);
        quadrant.setBounds(550, 100, 100, 40);
        quadrant.setForeground(foreGroundColor);
        frame.getContentPane().add(quadrant);

        furnished.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
        furnished.setFont(new Font("SansSerif", Font.PLAIN, 12));
        furnished.setBounds(700, 100, 100, 40);
        furnished.setBackground(backgroundColor);
        furnished.setForeground(foreGroundColor);
        frame.getContentPane().add(furnished);

        message.setBounds(400, 600,100,80);
        message.setForeground(Color.black);
        message.setBackground(Color.lightGray);
        frame.getContentPane().add(message);

        propertyID.setBounds(250, 600,100,80);
        propertyID.setForeground(Color.black);
        propertyID.setBackground(Color.lightGray);
        frame.getContentPane().add(propertyID);

        sendMessageBtn.setBounds(600, 620,80,40);
        sendMessageBtn.setFont(new Font("SansSerif", Font.BOLD, 12));
        sendMessageBtn.setForeground(Color.black);
        sendMessageBtn.setBackground(Color.lightGray);
        frame.getContentPane().add(sendMessageBtn);

        if(getRole() == "RegisteredRenter") { // checks if renter is logged
            subscribe.setBackground(backgroundColor);
            subscribe.setFont(new Font("SansSerif", Font.BOLD, 12));
            subscribe.setBounds(250, 150, 100, 40);
            subscribe.setForeground(foreGroundColor);
            frame.getContentPane().add(subscribe);

            if(getNotify()) {   // if true shows a button that means that listings matching search criteria are found
                notfiyBtn.setBackground(backgroundColor);
                notfiyBtn.setFont(new Font("SansSerif", Font.BOLD, 12));
                notfiyBtn.setBounds(400, 150, 150, 40);
                notfiyBtn.setForeground(foreGroundColor);
                frame.getContentPane().add(notfiyBtn);

            }
        }

        JLabel label1 = new JLabel("PropertyType");
        label1.setBounds(100, 70, 80, 30);
        frame.getContentPane().add(label1);

        JLabel label2 = new JLabel("Bedrooms");
        label2.setBounds(250, 70, 80, 30);
        frame.getContentPane().add(label2);

        JLabel label3 = new JLabel("Bathrooms");
        label3.setBounds(400, 70, 80, 30);
        frame.getContentPane().add(label3);

        JLabel label4 = new JLabel("Furnished");
        label4.setBounds(550, 70, 80, 30);
        frame.getContentPane().add(label4);

        JLabel label5 = new JLabel("Quadrant");
        label5.setBounds(700, 70, 80, 30);
        frame.getContentPane().add(label5);

        JLabel label6 = new JLabel("Message Landlord");
        label6.setFont(new Font("SansSerif", Font.BOLD, 16));
        label6.setBounds(340, 550, 150, 20);
        frame.getContentPane().add(label6);

        search.setBackground(backgroundColor);
        search.setFont(new Font("SansSerif", Font.BOLD, 12));
        search.setBounds(100, 150, 100, 40);
        search.setForeground(foreGroundColor);
        frame.getContentPane().add(search);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(dim.width/2-250, dim.height/2-250);
        frame.setSize(900,900);
        frame.setVisible(true);
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

    public String getMessage() {
        return (String) message.getText();
    }

    public void setMessage(String message) {
        this.message.setText(message);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPropertyID() {
        return Integer.parseInt((String) this.propertyID.getText());
    }

    public void setPropertyID(int propertyID) {
        this.propertyID.setText(Integer.toString(propertyID));
    }

    public Boolean getNotify() {
        return notify;
    }

    public void setNotify(Boolean notify) {
        this.notify = notify;
    }

    public static void main(String[] args) {
        LoginView u = new LoginView();
    }
}
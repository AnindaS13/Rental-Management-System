package Gui;

import Model.Listing;

import java.util.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JFrame;

public class RenterListingView implements Component {
    private ArrayList<Listing> listings = new ArrayList<Listing>();
    List<String[]> values = new ArrayList<String[]>();

    RenterListingView() {
        listings.add(new Listing("Apartment", 4,4, true, "ne", 10, "Landlord"));
        listings.add(new Listing("House", 4,4, true, "ne", 10, "Landlord"));
        for(int row = 0; row < Listing.size(); row++) {
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

    @SuppressWarnings("serial")
    @Override
    public void draw() {
        // TODO Auto-generated method stub
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//This gets your screensize
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when u close, makes the default close operation to exit the frame
        frame.setLocation(dim.width/2-250, dim.height/2-250); //setting location of where the applicatio
        frame.setSize(500,500);
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
                        "Property ID", "Property Type", "Bedrooms", "Bathrooms", "Furnished", "Quadrant"
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

        JButton returnButton = new JButton("Main Menu");
        returnButton.setFont(new Font("SansSerif", Font.BOLD, 10));
        returnButton.setBackground(new Color(0, 191, 255));
        returnButton.setBounds(10, 123, 115, 21);
        returnButton.setForeground(new Color(255, 255, 255));
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                Component c = new MainMenu();
            }
        });
        frame.getContentPane().add(returnButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when u close, makes the default close operation to exit the frame
        frame.setLocation(dim.width/2-250, dim.height/2-250); //setting location of where the applicatio
        frame.setSize(500,500);
        frame.setVisible(true); //making frame actually visible
    }

    public static void main(String[] args) {
        RenterListingView u = new RenterListingView();
//        u.setVisible(true);
    }
}
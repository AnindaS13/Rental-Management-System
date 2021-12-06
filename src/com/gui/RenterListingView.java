package com.gui;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;


interface Component {
    public JFrame frame = new JFrame();
    public void draw();
}


public class RenterListingView implements Component{
    private ArrayList<Propertie> properties;
    RenterListingView() {
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
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {1, "Furnished",4 , 5, true, "NE"},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                },
                new String[] {
                        "PropertyID", "Property Type", "#Bedrooms", "#Bathrooms", "Furnished", "Quadrant"
                }
        ) {
            Class[] columnTypes = new Class[] {
                    Integer.class, String.class, Integer.class, Integer.class, Boolean.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(65);
        table.getColumnModel().getColumn(1).setPreferredWidth(90);
        table.getColumnModel().getColumn(2).setPreferredWidth(63);
        table.getColumnModel().getColumn(3).setPreferredWidth(66);
        table.getColumnModel().getColumn(4).setPreferredWidth(55);
        table.getColumnModel().getColumn(5).setPreferredWidth(52);
        scrollPane.setViewportView(table);


        JPanel titlePanel = new JPanel();
//        titlePanel.setBackground(new Color(0, 191, 255));
//        titlePanel.setBounds(0, 0, 486, 82);
//        frame.getContentPane().add(titlePanel);
//        titlePanel.setLayout(null);

        JComboBox PropertyType = new JComboBox();
        PropertyType.setModel(new DefaultComboBoxModel(new String[] {"Apartment", "Townhouse", "Duplex", "Condo", "Studio", "Basement"}));
        PropertyType.setBackground(new Color(0, 191, 255));
        PropertyType.setFont(new Font("SansSerif", Font.PLAIN, 12));
        PropertyType.setBounds(10, 192, 73, 21);
        PropertyType.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(PropertyType);

        JComboBox NumBedrooms = new JComboBox();
        NumBedrooms.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,7,8}));
        NumBedrooms.setFont(new Font("SansSerif", Font.PLAIN, 12));
        NumBedrooms.setBackground(new Color(0, 191, 255));
        NumBedrooms.setBounds(108, 192, 67, 21);
        NumBedrooms.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(NumBedrooms);

        JComboBox NumBathrooms = new JComboBox();
        NumBathrooms.setModel(new DefaultComboBoxModel(new Integer[] {1,2,3,4,5,6,7,8}));
        NumBathrooms.setFont(new Font("SansSerif", Font.PLAIN, 12));
        NumBathrooms.setBackground(new Color(0, 191, 255));
        NumBathrooms.setBounds(196, 192, 60, 21);
        NumBathrooms.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(NumBathrooms);

        JComboBox Quadrant = new JComboBox();
        Quadrant.setModel(new DefaultComboBoxModel(new String[] {"NW", "SW", "NE", "SE"}));
        Quadrant.setFont(new Font("SansSerif", Font.PLAIN, 12));
        Quadrant.setBackground(new Color(0, 191, 255));
        Quadrant.setBounds(374, 193, 88, 21);
        Quadrant.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(Quadrant);

        JRadioButton Furnished = new JRadioButton("Furnished");
        Furnished.setBounds(280, 193, 88, 21);
        Furnished.setBackground(new Color(0, 191, 255));
        Furnished.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(Furnished);

        JLabel label1 = new JLabel("PropertyType");
        label1.setBounds(10, 168, 79, 13);
        frame.getContentPane().add(label1);

        JLabel label2 = new JLabel("#Bedrooms");
        label2.setBounds(108, 168, 67, 13);
        frame.getContentPane().add(label2);

        JLabel label3 = new JLabel("#Bathrooms");
        label3.setBounds(200, 168, 73, 13);
        frame.getContentPane().add(label3);

        JLabel label4 = new JLabel("Furnished?");
        label4.setBounds(293, 168, 67, 13);
        frame.getContentPane().add(label4);

        JLabel label5 = new JLabel("Quadrant");
        label5.setBounds(388, 168, 88, 13);
        frame.getContentPane().add(label5);

        JButton Search = new JButton("Search");
        Search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        Search.setBackground(new Color(0, 191, 255));
        Search.setFont(new Font("Arial", Font.BOLD, 18));
        Search.setBounds(135, 92, 198, 52);
        Search.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(Search);

        JButton Unsubscribe = new JButton("Unsubscribe");
        Unsubscribe.setFont(new Font("SansSerif", Font.BOLD, 10));
        Unsubscribe.setBackground(new Color(0, 191, 255));
        Unsubscribe.setBounds(359, 92, 117, 21);
        Unsubscribe.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(Unsubscribe);


        JButton emailButton = new JButton("Email Landlord");
        emailButton.setBackground(new Color(0, 191, 255));
        emailButton.setFont(new Font("SansSerif", Font.BOLD, 10));
        emailButton.setBounds(358, 123, 118, 21);
        emailButton.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(emailButton);
        emailButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                Component c = new EmailSystemScreen();
            }
        });

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
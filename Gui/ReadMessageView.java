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
import java.util.*;

public class ReadMessageView implements Component{
    private ArrayList<Listing> listings = new ArrayList<Listing>();
    List<String[]> values = new ArrayList<String[]>();
    private JButton RegisterBtn= new JButton("Register a Property");
    private JButton ListingsBtn= new JButton("Listings");
    private JButton MessagesBtn= new JButton("Messages");
    private ArrayList<String> data = new ArrayList<String>();
//    private String  [][] data = {{"1", "I would like this listing."},
//            {"2", "This listing of yours interests me."},
//            {"3", "Can i get in contact with you in regards to this listing."}};
//    private String [] column = {"mID", "Message"};
//    private JTable messageTable = new JTable(data,column);
    private JTable messageTable = new JTable();
    private JScrollPane scrollPane = new JScrollPane();
    
    public ReadMessageView() {
        draw();
    }

    public void setOutput(ArrayList<String> input) {
    	Object columnNames[] = {"Property ID", "Message"};
    	DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    	
    	for(int i=0; i< input.size(); i++) {
	    	Object rowData[] = {"", input.get(i)};
	    	model.addRow(rowData);
    	}
    	messageTable.setModel(model);
    }
    
    @Override
    public void draw()
    {
        frame.setSize(900,900);
        frame.setTitle("Messages Overview");

        JPanel navBarpanel = new JPanel(); //Setting navbar sizes and adding buttons to it
        navBarpanel.add(RegisterBtn);
        navBarpanel.add(ListingsBtn);
        navBarpanel.add(MessagesBtn);
        navBarpanel.setSize(frame.getWidth(),50);
        RegisterBtn.setBounds(0,0,166,50);
        ListingsBtn.setBounds(166,0,167,50);
        MessagesBtn.setBounds(333,0,167,50);
        navBarpanel.setLayout(new GridLayout());
        frame.add(navBarpanel);

        messageTable.setModel(new DefaultTableModel(data.toArray(new Object[][] {}),
                new String [] {
                        "Property ID", "Message"
                }
                ));
        messageTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        messageTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        messageTable.setRowHeight(100);
        messageTable.setBackground(Color.LIGHT_GRAY);
        scrollPane.setViewportView(messageTable);
        scrollPane.setBounds(200, 238, 466, 300);
        frame.getContentPane().add(scrollPane);

        frame.setLayout(null);
        frame.setResizable(true);
        frame.setVisible(true);
    }

//    public static void main(String[] args){
//        ReadMessageView x = new ReadMessageView();
//    }

    public void RegisterPerformed(ActionListener a) //For register property navbar redirect
    {
        this.RegisterBtn.addActionListener(a);
    }

    public void ListingsPerformed(ActionListener a) // For Listings navbar redirect
    {
        this.ListingsBtn.addActionListener(a);
    }

    public void MessagesPerformed(ActionListener a) //For messages navbar redirect
    {
        this.MessagesBtn.addActionListener(a);
    }
}
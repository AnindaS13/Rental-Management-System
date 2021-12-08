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

public class EditListStatusLandlordView implements Component{
    private ArrayList<Listing> listings = new ArrayList<Listing>();
    List<String[]> values = new ArrayList<String[]>();
    private JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane();

    EditListStatusLandlordView(ArrayList<Listing> input)
    {
    setTable(input);
    draw();
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
        frame.setTitle("Edit Status");  //Giving frame the size set and title
        frame.setResizable(true);
        frame.setSize(900,900);

        table.setBounds(30,200,500,300);
        table.setRowHeight(20);
        scrollPane.setViewportView(table);
        scrollPane.setBounds(30, 238, 800, 300);
        frame.getContentPane().add(scrollPane);
        frame.setLayout(null);
        frame.setVisible(true);
        System.out.println("in draw");
    }

    public static void main(String []args)
    {
        ArrayList <Listing> in = new ArrayList<Listing>();
        in.add(new Listing(1, "Apartment", 4, 5, true, "NE", "10:10", "johndoe@gmail.com", "Active", true));
        in.add(new Listing(2, "Apartment", 2, 2, true, "SW", "10:10", "johndoe@gmail.com", "Active", true));
        EditListStatusLandlordView x = new EditListStatusLandlordView(in);
    }
}

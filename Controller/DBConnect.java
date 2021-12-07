package Controller;

import java.sql.*;
import java.io.*;
import java.util.*;

public class DBConnect {


    public final String dburl = "jdbc:mysql://127.0.0.1:3306/ensf";
    public final String username = "root";
    public final String password ="calgary1";

    private Connection connect;
    private ResultSet results;
    
    
    // Constructor
    public DBConnect(){

    }

    /** Method initializeConnection
    * Establishes database connection
    */
    public void initializeConnection(){
    	    	
        try{
            connect = DriverManager.getConnection(dburl, username, password);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
   
}
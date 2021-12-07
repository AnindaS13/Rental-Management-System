import java.sql.*;
import java.io.*;
import java.util.*;

public class DBConnect {


    public final String dburl;
    public final String username;
    public final String password;

    private Connection connect;
    private ResultSet results;
    
    
    // Constructor
    public DBConnect(String dburl, String username, String password){
        this.dburl = dburl;
        this.username = username;
        this.password = password;
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

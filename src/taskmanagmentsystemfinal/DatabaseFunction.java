/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanagmentsystemfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseFunction {

    private static String original = alog.getUsern();

    public static String getOriginal() {
        return original;
    }

    public Connection getconnection() {
        Connection con = null;
        try {

            //  String url="jdbc:sqlserver://localhost:1433;databaseName=TaskManagementSystem; ";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=taskMangementsystem;";

            String username = "sa";
            String password = "sa";
            //Initialize Sqldriver instance 
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Creating the connection providing URL and username password
            con = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: " + cE.toString());
        }
        return con;
    }

    public boolean UpdateDatabaseQuery(String query) {
        boolean ret = false;
        try {
            Connection con = getconnection();
            PreparedStatement pst = con.prepareStatement(query);
            int count = pst.executeUpdate();
            if (count > 0) {
                ret = true;
            }
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            ret = false;
        }
        return ret;
    }

    public ResultSet ExecuteDatabaseQuery(String query) {
        ResultSet result = null;
        try {
            Connection con = getconnection();
            PreparedStatement pst = con.prepareStatement(query);
            result = pst.executeQuery();
        } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
            result = null;
        }
        return result;
    }
    public ResultSet combobox(String query) 
    { ResultSet rs;
        try {
          
            Connection con =getconnection();
        PreparedStatement pst = con.prepareStatement(query);
          
          rs = pst.executeQuery();
        
         } catch (Exception e) {
            System.out.println("SQL Exception: " + e.toString());
          rs = null;
        }
          return rs;
    }

}

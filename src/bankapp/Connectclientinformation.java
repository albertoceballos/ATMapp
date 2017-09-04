/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

/**
 *
 * @author aac088
 */
import java.sql.*;
import javax.swing.*;

public class Connectclientinformation {
    private static final String USERNAME="Admin";
    private static final String PASSWORD="password";
    private static final String CONN_STRING="jdbc:mysql://localhost:3306/clientinformation?allowMultiQueries=true&autoReconnect=true&useSSL=false";
    
        public static Connection ConnectDB(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            JOptionPane.showMessageDialog(null, "Connected to database");
            return conn;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        }
}

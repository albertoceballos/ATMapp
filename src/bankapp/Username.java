/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
/**
 *
 * @author aac088
 */
public class Username {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public static String username;
    public static String name;
    public static String dest;
    
    public void setname(){
        try {
            conn = Connectclientinformation.ConnectDB();
            String sql = "select username, name, last from personalinfo where username = '"+username+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String namel = rs.getString("name");
                String name2 = rs.getString("last");
                name=namel+" "+name2;
                pst.close();
                rs.close();
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Username.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setDest(String destin){
        try {
            conn = Connectclientinformation.ConnectDB();
            String sql = "select name,username from personalinfo where name='"+destin+"'";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                String namel = rs.getString("username");
                dest=namel;
                pst.close();
                rs.close();
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Username.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}

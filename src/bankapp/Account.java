/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author aac088
 */
public class Account {
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    public static String account;
    private Float balance;
    private Float amount;
    private String transaction;
    public static String password;
    public static String destination;
    
    
    public void getPassword(){
        try {
            conn = Connectclientinformation.ConnectDB();
            String Sql="Select * from clientinformation.users where username='"+Username.username+"'";
            pst=conn.prepareStatement(Sql);
            rs=pst.executeQuery();
            if(rs.next()){
                password=rs.getString("password");
                pst.close();
                rs.close();
                conn.close();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void changePass(String newpass){
        //getPassword();
        try {
            conn = Connectclientinformation.ConnectDB();
            String Sql="UPDATE clientinformation.users SET password='"+newpass+"' where username='"+Username.username+"'";
            pst=conn.prepareStatement(Sql);
            pst.execute();
       
                pst.close();
                rs.close();
                conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void transfer(String dest){
        try {
            conn = Connectclientinformation.ConnectDB();
            String Sql="insert into clientinformation."+Username.dest+"_transactions_"+account
                    +" (transaction_type,amount,balance)"
                    +"values(?,?,?)";
            pst=conn.prepareStatement(Sql);
            pst.setString(1, "Transfer");
            pst.setString(2,amount.toString());
            pst.setString(3,balance.toString());
            pst.executeUpdate();
            pst.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setTransfer(Float am){
        getValues();
        float newBalance;
        amount=am;
        newBalance = balance - am;
        balance = newBalance;
        transaction="Transfer";
        setValues();
        transfer(Username.dest);
    }
    
    public void getValues(){
        try {
            conn = Connectclientinformation.ConnectDB();
            String Sql="Select * from clientinformation."+Username.username+"_transactions_"+account;
            pst=conn.prepareStatement(Sql);
            rs=pst.executeQuery();
            if(rs.next()){
                balance=rs.getFloat("balance");
                pst.close();
                rs.close();
                conn.close();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setAccount(String as){
        account=as;
    }
    
    public void Withdraw(float am){
        getValues();
        float newBalance;
        amount=am;
        newBalance = balance - am;
        balance = newBalance;
        transaction="withdraw";
        setValues();
    }
    
    public void Deposit(float am){
        getValues();
        float newBalance;
        amount=am;
        newBalance = balance + am;
        balance = newBalance;
        transaction="deposit";
        setValues();
    }
    
    private void setValues(){
        try {
            conn = Connectclientinformation.ConnectDB();
            String Sql="insert into "+Username.username+"_transactions_"+account
                    +" (transaction_type,amount,balance)"
                    +"values(?,?,?)";
            pst=conn.prepareStatement(Sql);
            pst.setString(1, transaction);
            pst.setString(2,amount.toString());
            pst.setString(3,balance.toString());
            pst.executeUpdate();
            pst.close();
            rs.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

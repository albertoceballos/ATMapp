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
public class TableData {

    /**
     * @return the transaction_number
     */
    public int getTransaction_number() {
        return transaction_number;
    }

    /**
     * @return the transaction_type
     */
    public String getTransaction_type() {
        return transaction_type;
    }

    /**
     * @return the amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * @return the balance
     */
    public float getBalance() {
        return balance;
    }
    private int transaction_number;
    private String transaction_type;
    private float amount;
    private float balance;
    
    public TableData(int transaction_number,String transaction_type, float amount, float balance){
        this.transaction_number=transaction_number;
        this.transaction_type=transaction_type;
        this.amount=amount;
        this.balance=balance;
    }
    
}

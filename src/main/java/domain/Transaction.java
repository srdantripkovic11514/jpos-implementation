/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 *
 * @author Srdjan
 */
public class Transaction {
    
    private int transactionID;
    private BigDecimal amount;
    private ZonedDateTime dateTime;
    private Account paying;
    private Account receiving;
    
    public Transaction(int transactionID, BigDecimal amount, ZonedDateTime dateTime, Account paying, Account receiving) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.dateTime = dateTime;
        this.paying = paying;
        this.receiving = receiving;
    }

    public Transaction() {
    }
    
    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Account getPaying() {
        return paying;
    }

    public void setPaying(Account paying) {
        this.paying = paying;
    }

    public Account getReceiving() {
        return receiving;
    }

    public void setReceiving(Account receiving) {
        this.receiving = receiving;
    }

}

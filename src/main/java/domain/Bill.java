/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;

/**
 *
 * @author Srdjan
 */
public class Bill {
    
    private int billID;
    private BigDecimal amount;
    private String monthYear;
    private String type;
    private Client client;

    public Bill() {
    }

    public Bill(int billID, BigDecimal amount, String monthYear, String type, Client client) {
        this.billID = billID;
        this.amount = amount;
        this.monthYear = monthYear;
        this.type = type;
        this.client = client;
    }
    
    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
}

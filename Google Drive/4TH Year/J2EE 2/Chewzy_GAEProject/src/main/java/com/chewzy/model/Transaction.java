package com.chewzy.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by Misa on 9/11/2016.
 */

@Entity
public class Transaction {
    @Id
    private Long transaction_id; //primary key
    @Index
    private String transaction_date; //date the transaction was made
    @Index
    private double transpaymenttotal; //overall total
    @Index
    private int itemsordered; //number of dish count
    @Index
    private Long business_id;
//    Key<Business> business_id;
    @Index
    private boolean isActive;

    public Transaction(){}

    public Transaction(String transaction_date, double transpaymenttotal, int itemsordered, Long business_id, boolean isActive) {
        this.transaction_date = transaction_date;
        this.transpaymenttotal = transpaymenttotal;
        this.itemsordered = itemsordered;
        this.business_id = business_id;
        this.isActive = isActive;
    }

    public Long getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(Long business_id) {
        this.business_id = business_id;
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public double getTranspaymenttotal() {
        return transpaymenttotal;
    }

    public void setTranspaymenttotal(double transpaymenttotal) {
        this.transpaymenttotal = transpaymenttotal;
    }

    public int getItemsordered() {
        return itemsordered;
    }

    public void setItemsordered(int itemsordered) {
        this.itemsordered = itemsordered;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

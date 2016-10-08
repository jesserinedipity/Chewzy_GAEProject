package com.chewzy.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by Misa on 9/11/2016.
 */
@Entity
public class TransactionDetails {
    @Id
    Long transdetails_id;
    @Index
    private Long transaction_id;
//    Key<Transaction> transaction_id; //primary
    @Index
    private Long dish_id;
//    Key<Dish> dish_id; //primary
    @Index
    private int quantity;
    @Index
    private double totalprice;
    @Index
    private boolean isActive;

    public TransactionDetails(){}

    public TransactionDetails(Long transaction_id, Long dish_id, int quantity, double totalprice, boolean isActive) {
        this.transaction_id = transaction_id;
        this.dish_id = dish_id;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.isActive = isActive;
    }

    public Long getTransdetails_id() {
        return transdetails_id;
    }

    public void setTransdetails_id(Long transdetails_id) {
        this.transdetails_id = transdetails_id;
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Long getDish_id() {
        return dish_id;
    }

    public void setDish_id(Long dish_id) {
        this.dish_id = dish_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

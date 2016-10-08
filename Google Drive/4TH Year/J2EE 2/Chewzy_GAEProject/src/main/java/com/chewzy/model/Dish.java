package com.chewzy.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by Misa on 9/11/2016.
 */
@Entity
public class Dish {
    @Id
    private Long dish_id;
    @Index
    private String dish_name;
    @Index
    private String dish_desc; //dish description
    @Index
    private double base_price;
    @Index
    private Long business_id;
//    Key<Business> business_id;
    @Index
    private Long cuisine_id;
//    Key<Cuisine> cuisine_id;
    @Index
    private boolean isActive;
    @Index
    private Long category_id;
//    Key<Category> category_id;
    //private String category_id; //dish category id

    public Dish(){}

    public Dish(String dish_name, String dish_desc, double base_price, Long business_id, Long cuisine_id, boolean isActive, Long category_id) {
        this.dish_name = dish_name;
        this.dish_desc = dish_desc;
        this.base_price = base_price;
        this.business_id = business_id;
        this.cuisine_id = cuisine_id;
        this.isActive = isActive;
        this.category_id = category_id;
    }

    public Long getDish_id() {
        return dish_id;
    }

    public void setDish_id(Long dish_id) {
        this.dish_id = dish_id;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getDish_desc() {
        return dish_desc;
    }

    public void setDish_desc(String dish_desc) {
        this.dish_desc = dish_desc;
    }

    public double getBase_price() {
        return base_price;
    }

    public void setBase_price(double base_price) {
        this.base_price = base_price;
    }

    public Long getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(Long business_id) {
        this.business_id = business_id;
    }

    public Long getCuisine_id() {
        return cuisine_id;
    }

    public void setCuisine_id(Long cuisine_id) {
        this.cuisine_id = cuisine_id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}

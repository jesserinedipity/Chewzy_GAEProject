package com.chewzy.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by Misa on 9/10/2016.
 */

@Entity
public class BusinessCuisine {
    @Id
    Long businesscuisine_id;

    @Index
    private Long business_id;
//    Key<Business> business_id;
    @Index
    private Long cuisine_id;
//    Key<Cuisine> cuisine_id;
    @Index
    private boolean isActive;

    public BusinessCuisine(){}

    public BusinessCuisine(Long business_id, Long cuisine_id, boolean isActive) {
        this.business_id = business_id;
        this.cuisine_id = cuisine_id;
        this.isActive = isActive;
    }

    public Long getBusinesscuisine_id() {
        return businesscuisine_id;
    }

    public void setBusinesscuising_id(Long businesscuisine_id) {
        this.businesscuisine_id = businesscuisine_id;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

package com.chewzy.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by Misa on 9/10/2016.
 */
@Entity
public class Cuisine {
    @Id
    private Long cuisine_id;
    @Index
    private String cuisine_name;
    @Index
    private boolean isActive;

    public Cuisine(){}

    public Cuisine(String cuisine_name, boolean isActive) {
        this.cuisine_name = cuisine_name;
        this.isActive = isActive;
    }

    public Long getCuisine_id() {
        return cuisine_id;
    }

    public void setCuisine_id(Long cuisine_id) {
        this.cuisine_id = cuisine_id;
    }

    public String getCuisine_name() {
        return cuisine_name;
    }

    public void setCuisine_name(String cuisine_name) {
        this.cuisine_name = cuisine_name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}

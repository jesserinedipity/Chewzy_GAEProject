package com.chewzy.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by Misa on 9/11/2016.
 */
@Entity
public class DishCategory {
    @Id
    private Long category_id;
    @Index
    private String category_name;
    @Index
    private boolean isActive;

    public DishCategory(){}

    public DishCategory(String category_name, boolean isActive) {
        this.category_name = category_name;
        this.isActive = isActive;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

package com.chewzy.model;

import com.google.appengine.api.datastore.Text;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by Misa on 9/11/2016.
 */
@Entity
public class Foodtrip {
    @Id
    private Long foodtrip_id;
    @Index
    private String date;
    @Index
    private Long transaction_id;
//    Key<Transaction> transaction_id;
    @Index
    private Long user_id;
//    Key<User> user_id;
    @Index
    private Long business_id;
//    Key<Business> business_id;
//    @Index
//    private String review_content;
    @Index
    private Text review_content;
    @Index
    private float ambiance_rating;
    @Index
    private float food_rating;
    @Index
    private float cost_rating;
    @Index
    private float service_rating;
    @Index
    private float hygiene_rating;
    @Index
    private boolean isActive;

    public Foodtrip(){}

    public Foodtrip(String date, Long transaction_id, Long user_id, Long business_id, Text review_content, float ambiance_rating, float food_rating, float cost_rating, float service_rating, float hygiene_rating, boolean isActive) {
        this.date = date;
        this.transaction_id = transaction_id;
        this.user_id = user_id;
        this.business_id = business_id;
        this.review_content = review_content;
        this.ambiance_rating = ambiance_rating;
        this.food_rating = food_rating;
        this.cost_rating = cost_rating;
        this.service_rating = service_rating;
        this.hygiene_rating = hygiene_rating;
        this.isActive = isActive;
    }

    public Long getFoodtrip_id() {
        return foodtrip_id;
    }

    public void setFoodtrip_id(Long foodtrip_id) {
        this.foodtrip_id = foodtrip_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(Long business_id) {
        this.business_id = business_id;
    }

    public Text getReview_content() {
        return review_content;
    }

    public void setReview_content(Text review_content) {
        this.review_content = review_content;
    }

    public float getAmbiance_rating() {
        return ambiance_rating;
    }

    public void setAmbiance_rating(float ambiance_rating) {
        this.ambiance_rating = ambiance_rating;
    }

    public float getFood_rating() {
        return food_rating;
    }

    public void setFood_rating(float food_rating) {
        this.food_rating = food_rating;
    }

    public float getCost_rating() {
        return cost_rating;
    }

    public void setCost_rating(float cost_rating) {
        this.cost_rating = cost_rating;
    }

    public float getService_rating() {
        return service_rating;
    }

    public void setService_rating(float service_rating) {
        this.service_rating = service_rating;
    }

    public float getHygiene_rating() {
        return hygiene_rating;
    }

    public void setHygiene_rating(float hygiene_rating) {
        this.hygiene_rating = hygiene_rating;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

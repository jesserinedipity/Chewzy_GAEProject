package com.chewzy.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by Misa on 9/10/2016.
 */
@Entity
public class Business {
    @Id
    private Long business_id;
    @Index
    private String business_name;
    @Index
    private String full_address;
    @Index
    private String city;
    @Index
    private String state;
    @Index
    private double stars;
    @Index
    private double longitude;
    @Index
    private double latitude;
    @Index
    private int review_count;
    @Index
    private int open;
    @Index
    private String photo_url;
    @Index
    private String website;
    @Index
    private boolean isActive;

    public Business(){}

    public Business(String business_name, String full_address, String city, String state, double stars, double longitude, double latitude, int review_count, int open, String photo_url, String website, boolean isActive) {
        this.business_name = business_name;
        this.full_address = full_address;
        this.city = city;
        this.state = state;
        this.stars = stars;
        this.longitude = longitude;
        this.latitude = latitude;
        this.review_count = review_count;
        this.open = open;
        this.photo_url = photo_url;
        this.website = website;
        this.isActive = isActive;
    }

    public Long getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(Long business_id) {
        this.business_id = business_id;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getFull_address() {
        return full_address;
    }

    public void setFull_address(String full_address) {
        this.full_address = full_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

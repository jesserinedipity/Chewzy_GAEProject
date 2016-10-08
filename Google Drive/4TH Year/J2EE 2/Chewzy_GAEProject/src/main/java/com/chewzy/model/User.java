package com.chewzy.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    private Long user_id;
    @Index
    private String firstname;
    @Index
    private String lastname;
    @Index
    private String gender;
    @Index
    private String email;
    @Index
    private String contact_number;
    @Index
    private String username;
    @Index
    private String password;
    @Index
    private String date_created;
    @Index
    private String address;
    @Index
    private int foodtrip_count;
    @Index
    private Long badge_id;
//    Key<Badge> badge_id;
    @Index
    private double latitude;
    @Index
    private double longitude;
    @Index
    private boolean isActive;
    @Index
    private String birthdate;

    public User(){}

//    public User(String username, String password) {
//        this.username = username;
//        this.password = password;
//    }

    public User(String firstname, String lastname, String gender, String email, String contact_number, String username, String password, String date_created, String address, int foodtrip_count, Long badge_id, double latitude, double longitude, boolean isActive, String birthdate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
        this.contact_number = contact_number;
        this.username = username;
        this.password = password;
        this.date_created = date_created;
        this.address = address;
        this.foodtrip_count = foodtrip_count;
        this.badge_id = badge_id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isActive = isActive;
        this.birthdate = birthdate;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFoodtrip_count() {
        return foodtrip_count;
    }

    public void setFoodtrip_count(int foodtrip_count) {
        this.foodtrip_count = foodtrip_count;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getBadge_id() {
        return badge_id;
    }

    public void setBadge_id(Long badge_id) {
        this.badge_id = badge_id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
    

}

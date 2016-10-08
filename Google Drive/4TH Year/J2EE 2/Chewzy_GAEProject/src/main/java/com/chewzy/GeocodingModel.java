package com.chewzy;

/**
 * Created by Misa on 9/17/2016.
 */
public class GeocodingModel {
    private String formattedAddr;
    private double longitude;
    private double latitude;

    public GeocodingModel() {
    }

    public GeocodingModel(String formattedAddr, double longitude, double latitude) {
        this.formattedAddr = formattedAddr;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getFormattedAddr() {
        return formattedAddr;
    }

    public void setFormattedAddr(String formattedAddr) {
        this.formattedAddr = formattedAddr;
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
}

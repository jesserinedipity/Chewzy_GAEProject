package com.chewzy;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;

import java.io.IOException;
import java.util.List;

/**
 * Created by Misa on 9/15/2016.
 */
public class Geocoding {

    public static GeocodingModel getLongLat(String address){
        GeocodingModel geomodel = null;

        Geocoder geocoder = new Geocoder();
        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(address).getGeocoderRequest();

        double latitude=0, longitude=0;
        String formattedAddress="";
        try {
            GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);

            if (!geocoderResponse.getResults().isEmpty()) {
                List<GeocoderResult> results = geocoderResponse.getResults();

                for(GeocoderResult res : results){
                    System.out.println(res.getGeometry().getLocation().getLat());
                    System.out.println(res.getGeometry().getLocation().getLng());
                }

//                System.out.println("Geocoder result is not empty");
//                latitude = geocoderResponse.getResults().get(0).getGeometry().getLocation()
//                        .getLat().doubleValue();
//                longitude = geocoderResponse.getResults().get(0).getGeometry().getLocation()
//                        .getLng().doubleValue();
//                formattedAddress = geocoderResponse.getResults().get(0).getFormattedAddress();
            } else {
                latitude = -1.0;
                longitude = -1.0;
                formattedAddress = "N/A";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Formatted address: " + formattedAddress + ", Location coordinates: (" +
                    latitude + ", " + longitude + ")");

        geomodel = new GeocodingModel(formattedAddress,longitude,latitude);

        return geomodel;

    }
}

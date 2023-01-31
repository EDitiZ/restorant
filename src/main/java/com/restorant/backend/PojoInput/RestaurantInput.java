package com.restorant.backend.PojoInput;

import com.restorant.backend.POJO.Address;
import com.restorant.backend.POJO.RestaurantType;

public class RestaurantInput {

    private String name;
    private Address address;
    private RestaurantType type;
    private boolean doDelivery;

    private double latitude;
    private double longitude;

    public RestaurantInput(String name, Address address, RestaurantType type,boolean doDelivery, double latitude, double longitude) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.doDelivery = doDelivery;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public RestaurantType getType() {
        return type;
    }

    public void setType(RestaurantType type) {
        this.type = type;
    }

    public boolean isDoDelivery() {
        return doDelivery;
    }

    public void setDoDelivery(boolean doDelivery) {
        this.doDelivery = doDelivery;
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
}

package com.example.contactbook.models;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String pincode;

    public Address() {
    }

    public Address(String streetAddress, String city, String state, String country, String pincode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String addressLine) {
        this.streetAddress = addressLine;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}

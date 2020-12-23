package com.canalplus.project.canalplusproject.models;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetAddress;
    private String country;
    private String zipCode;
    public  Address(){

    }

    public Address( String streetAddress, String country, String zipCode) {
        this.streetAddress = streetAddress;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

   public String toString(){
       return (this.streetAddress.toString() + " " +this.country.toString() + " " + this.zipCode.toString());
   }

}

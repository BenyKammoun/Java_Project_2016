package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.enums.Cities;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.enums.Countries;

/**
 * Created by Binyamin Kamoun on 11/12/2016.
 */

public class Address {
    private Countries country;
    private Cities city;
    private String street;

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
}

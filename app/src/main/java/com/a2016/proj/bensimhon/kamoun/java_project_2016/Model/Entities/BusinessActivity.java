package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities;

import android.text.format.DateFormat;



import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Binyamin Kamoun on 08/12/2016.
 */

public class BusinessActivity {
    private String description;
    private String country;
    CharSequence startDate;
    CharSequence endDate;
    private int price;
    private String details;
    private int id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String  country) {
        this.country = country;
    }

    public CharSequence getStartDate() {
        return startDate;
    }

    public void setStartDate(CharSequence startDate) {
        this.startDate = startDate;
    }

    public CharSequence getEndDate() {
        return endDate;
    }

    public void setEndDate(CharSequence endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

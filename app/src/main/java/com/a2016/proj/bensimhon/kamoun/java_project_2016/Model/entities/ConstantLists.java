package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities;

import java.util.ArrayList;

/**
 * Created by Binyamin Kamoun on 14/12/2016.
 */

public class ConstantLists {
    /*
    * These lists are containing the businesses an businesses' activities of this specific app.
    * */
    static final ArrayList<String> businesses = new ArrayList<String>();
    static final ArrayList<String> hotelActivities = new ArrayList<String>();
    static final ArrayList<String> flightCompanyActivities = new ArrayList<String>();
    static final ArrayList<String> tourismAgencyActivities = new ArrayList<String>();

    public ConstantLists() {
        businesses.add("Tourism Agency");
        businesses.add("Hotel");
        businesses.add("Flight Company");

        hotelActivities.add("Full Board");
        hotelActivities.add("Half Board");
        hotelActivities.add("Bed & Breakfast");

        flightCompanyActivities.add("One-way flights");
        flightCompanyActivities.add("Round-trip flights");

        tourismAgencyActivities.add("Flights");
        tourismAgencyActivities.add("Flights + Hotels");
        tourismAgencyActivities.add("Flights + Hotels + Cars");
    }

    /*
    * Lists getters.
    * */
    public static ArrayList<String> getBusinesses() {
        return businesses;
    }

    public static ArrayList<String> getHotelActivities() {
        return hotelActivities;
    }

    public static ArrayList<String> getFlightCompanyActivities() {
        return flightCompanyActivities;
    }

    public static ArrayList<String> getTourismAgencyActivities() {
        return tourismAgencyActivities;
    }
}

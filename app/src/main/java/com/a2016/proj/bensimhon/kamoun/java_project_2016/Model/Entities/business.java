package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities;

import java.net.URL;

/**
 * Created by Binyamin Kamoun on 08/12/2016.
 */

public class Business {
    /*
    * Business class fields.
    * */
    private int ID;
    private String name;
    private Address address;
    private String phoneNumb;
    private String email;
    private URL website;

    /*
    * Business class methods (getters, setters).
    * */
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public String getPhoneNumb() {
        return phoneNumb;
    }
    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public URL getWebsite() {
        return website;
    }
    public void setWebsite(URL website) {
        this.website = website;
    }
}

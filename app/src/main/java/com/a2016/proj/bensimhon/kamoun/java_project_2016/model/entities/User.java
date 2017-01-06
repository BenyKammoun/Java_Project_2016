package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities;

import android.provider.ContactsContract;

/**
 * Created by Binyamin Kamoun on 11/12/2016.
 */

public class User {
    /*
    * This static number enables the setID() method set the User's ID.
    * */
    private static int idHelper = 1;

    /*
    * User class fields
    * */
    private int ID;
    private String name;
    private String userName;
    private String password;

    /*
    * User class methods (getters, setters).
    * */
    public int getID() {
        return ID;
    }
    public void setID() {
        this.ID = idHelper;
        idHelper +=1;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}

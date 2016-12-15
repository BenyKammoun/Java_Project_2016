package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.datasource.List_Business;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.datasource.List_BusinessActivity;

/**
 * Created by mailo on 28/11/2016.
 */

public class DBManagerFactory {

    static List_Business businessDB = null;
    static List_BusinessActivity businessActDB = null;

    public static List_Business getBusinessManager() {
        if (businessDB == null)
            businessDB = new List_Business();
        return businessDB;
    }
    public static List_BusinessActivity getBusinessActManager() {
        if (businessActDB == null)
            businessActDB = new List_BusinessActivity();
        return businessActDB;
    }
}

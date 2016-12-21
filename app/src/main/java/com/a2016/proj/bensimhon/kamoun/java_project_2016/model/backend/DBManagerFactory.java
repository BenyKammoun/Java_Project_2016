package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DB_manager;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.data_source.List_DBManager;

/**
 * Created by mailo on 28/11/2016.
 */

public class DBManagerFactory {

    static DB_manager manager = null;

    public static DB_manager getManager() {
        if (manager == null)
            manager = new List_DBManager();
        return manager;
    }
}

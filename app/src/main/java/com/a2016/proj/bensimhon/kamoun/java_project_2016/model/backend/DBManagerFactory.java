package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend;

import android.content.Context;
import android.database.Cursor;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.controller.MainActivity;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DB_manager;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.data_source.List_DBManager;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.data_source.MySQL_PHP_DBManager;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.data_source.SqlDb;

/**
 * Created by mailo on 28/11/2016.
 */

public class DBManagerFactory {

    static DB_manager manager = null;

    public static DB_manager getManager(Context c) {
        if (manager == null)
            manager = new MySQL_PHP_DBManager();
        return manager;
    }
}

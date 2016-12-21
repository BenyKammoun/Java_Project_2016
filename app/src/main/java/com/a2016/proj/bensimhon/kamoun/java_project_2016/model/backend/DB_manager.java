package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;


import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities.Business;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities.BusinessActivity;

import java.util.List;

/**
 * Created by Ezra Steinmetz on August 2016
 */
public interface DB_manager {


    boolean removeBusiness(long id);

    boolean removeBusinessActivity(long id);

    long addBusiness(ContentValues values);

    long addBusinessActivity(ContentValues values);

    Cursor getBusinesses();
    Cursor getBusinessesAct();

    boolean updateBusiness(long id, ContentValues values);
    boolean updateBusinessActivity(long id, ContentValues values);

    boolean isUpdate();



}

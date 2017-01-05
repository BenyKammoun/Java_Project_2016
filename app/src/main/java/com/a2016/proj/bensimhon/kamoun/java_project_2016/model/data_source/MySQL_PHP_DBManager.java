package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.data_source;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;


import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DB_manager;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by mailo on 15/12/2016.
 */

public class MySQL_PHP_DBManager implements DB_manager {
    private String WEB_URL = "http://bensimch.vlab.jct.ac.il/phpJava2016";
    private boolean isUpdate =false;
    @Override
    public boolean removeBusiness(long id) {
        isUpdate =true;
        return false;
    }

    @Override
    public boolean removeBusinessActivity(long id) {
        isUpdate =true;
        return false;
    }

    @Override
    public long addBusiness(ContentValues values) {
        try {
            PHPtools.POST(WEB_URL + "/addBusiness.php",values);
            isUpdate =true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public long addBusinessActivity(ContentValues values) {
        return 0;
    }

    @Override
    public Cursor getBusinesses() {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]
                    {
                            DBContract.BusinessC.ID,
                            DBContract.BusinessC.NAME,
                            DBContract.BusinessC.PHONE,
                            DBContract.BusinessC.Email,
                            DBContract.BusinessC.WEBSITE,
                            DBContract.BusinessC.COUNTRY,
                            DBContract.BusinessC.CITY,
                            DBContract.BusinessC.STREET,
                            DBContract.BusinessC.TYPE
                    });
            String str = PHPtools.GET(WEB_URL + "/businesses.php");
            JSONArray array = new JSONObject(str).getJSONArray("businesses");


            for (int i = 0; i < array.length(); i++) {
                JSONObject jsonObject = null;

                jsonObject = array.getJSONObject(i);

                matrixCursor.addRow(new Object[]{

                        jsonObject.getInt(DBContract.BusinessC.ID),
                        jsonObject.getString(DBContract.BusinessC.NAME),
                        jsonObject.getString(DBContract.BusinessC.PHONE),
                        jsonObject.getString(DBContract.BusinessC.Email),
                        jsonObject.getString(DBContract.BusinessC.WEBSITE),
                        jsonObject.getString(DBContract.BusinessC.COUNTRY),
                        jsonObject.getString(DBContract.BusinessC.CITY),
                        jsonObject.getString(DBContract.BusinessC.STREET),
                        jsonObject.getString(DBContract.BusinessC.TYPE),

                });
            }
            isUpdate =false;
            return matrixCursor;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;

    }

    @Override
    public Cursor getBusinessesAct() {
        return null;
    }

    @Override
    public Cursor getAllActivitiesOfBusiness() {
        return null;
    }

    @Override
    public boolean updateBusiness(long id, ContentValues values) {
        return false;
    }

    @Override
    public boolean updateBusinessActivity(long id, ContentValues values) {
        return false;
    }

    @Override
    public boolean linkActToBusiness(Integer bId, Integer aId) {
        return false;
    }

    @Override
    public boolean isUpdate() {
        return false;
    }
}

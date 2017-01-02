package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.data_source;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DB_manager;

import java.util.HashMap;

import static com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract.DATABASE_NAME;
import static com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract.DATABASE_VERSION;
import static com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract.BUSINESS_TABLE_NAME;
import static com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract.BUSINESSACTIVITY_TABLE_NAME;
import static com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract.CREATE_DB_BUSINESS_TABLE;
import static com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract.CREATE_DB_BUSINESSACTIVITY_TABLE;

public class SqlDb extends SQLiteOpenHelper implements DB_manager {


    protected SQLiteDatabase db;
    private static HashMap<String, String> PROJECTION;

    public SqlDb(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase();
    }
    private boolean isUpdate =false;
    public void setChanged() {
        isUpdate = true;
    }

    @Override
    public boolean removeBusiness(long id) {
       int count = db.delete(BUSINESS_TABLE_NAME, DBContract.BusinessC.ID + " = " + id + "", null);
        if(count!=-1)
            return true;
        return false;
    }

    @Override
    public boolean removeBusinessActivity(long id) {
        int count = db.delete(BUSINESSACTIVITY_TABLE_NAME, DBContract.BusinessC.ID + " = " + id + "", null);
        if(count!=-1)
            return true;
        return false;
    }

    @Override
    public long addBusiness(ContentValues values) {
        return db.insert(BUSINESS_TABLE_NAME, "", values);

    }

    @Override
    public long addBusinessActivity(ContentValues values) {
        return db.insert(BUSINESSACTIVITY_TABLE_NAME, "", values);
    }

    @Override
    public Cursor getBusinesses() {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(BUSINESS_TABLE_NAME);
        qb.setProjectionMap(PROJECTION);
        //set which field we want
        String[] projection = new String[]{DBContract.BusinessC.ID, DBContract.BusinessC.NAME, DBContract.BusinessC.PHONE
        ,DBContract.BusinessC.COUNTRY,DBContract.BusinessC.WEBSITE,DBContract.BusinessC.CITY,DBContract.BusinessC.Email};

        Cursor c = qb.query(db, projection, null, null, null, null, null);
        return c;
    }

    @Override
    public Cursor getBusinessesAct() {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(BUSINESSACTIVITY_TABLE_NAME);
        qb.setProjectionMap(PROJECTION);
        //set which field we want
        String[] projection = new String[]{DBContract.BusinessActivityC.ID, DBContract.BusinessActivityC.PRICE, DBContract.BusinessActivityC.DETIALES
                , DBContract.BusinessActivityC.SDATE, DBContract.BusinessActivityC.EDATE, DBContract.BusinessActivityC.COUNTRY};

        Cursor c = qb.query(db, projection,null, null, null, null, null);
        return c;

    }

    @Override
    public Cursor getAllActivitiesOfBusiness() {
        return null;
    }

    @Override
    public boolean updateBusiness(long id, ContentValues values) {
        int count = db.update(BUSINESS_TABLE_NAME,values,DBContract.BusinessC.ID + " = " + id + "", null);
        if(count!=-1)
            return true;
        return false;
    }

    @Override
    public boolean updateBusinessActivity(long id, ContentValues values) {
        int count = db.update(BUSINESSACTIVITY_TABLE_NAME,values,DBContract.BusinessC.ID + " = " + id + "", null);
        if(count!=-1)
            return true;
        return false;
    }

    @Override
    public boolean linkActToBusiness(Integer bId, Integer aId) {
        return false;
    }

    @Override
    public boolean isUpdate() {
        if(isUpdate)
        {
            isUpdate = false;
            return  true;
        }

        return  false;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB_BUSINESS_TABLE);
        db.execSQL(CREATE_DB_BUSINESSACTIVITY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  BUSINESS_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " +  BUSINESSACTIVITY_TABLE_NAME);
        onCreate(db);
    }


}

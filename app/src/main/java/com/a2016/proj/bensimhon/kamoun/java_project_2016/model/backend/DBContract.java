package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend;

import android.content.UriMatcher;
import android.net.Uri;

/**
 * Created by mailo on 08/12/2016.
 */

public class DBContract {

    /**
     * The authority for the contacts provider
     */
    public static final String BusinessAUTHORITY = "com.a2016.proj.sql/business/";
    public static final String BusinessActivityAUTHORITY = "com.a2016.proj.sql/businessActivity/";


    public static class BusinessC {
        /**
         * A content:// style uri to the authority for the contacts provider
         */
        public static final Uri AUTHORITY_URI = Uri.parse("content://" + BusinessAUTHORITY);

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String PHONE = "phone";
        public static final String Email = "email";
        public static final String WEBSITE = "website";
        public static final String COUNTRY = "country";
        public static final String CITY = "city";
        public static final String STREET = "street";

    }

    public static class BusinessActivityC {
        /**
         * A content:// style uri to the authority for the contacts provider
         */
        public static final Uri AUTHORITY_URI = Uri.parse("content://" + BusinessActivityAUTHORITY);

        public static final String DESCRIPTTION = "_description";
        public static final String COUNTRY = "country";
        public static final String SDATE = "startDate";
        public static final String EDATE = "endDate";
        public static final String PRICE = "price";
        public static final String DETIALES = "details";
        public static final String ID = "id";

    }

    public static final String DATABASE_NAME = "MainDB";
    public static final String BUSINESS_TABLE_NAME = "business";
    public static final String BUSINESSACTIVITY_TABLE_NAME = "businessAct";

    public static final int DATABASE_VERSION = 1;


    public  static final String CREATE_DB_BUSINESS_TABLE =
            " CREATE TABLE " + BUSINESS_TABLE_NAME +
                    " ( " +
                    ""  + BusinessC.ID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                    "," + BusinessC.CITY + " TEXT NOT NULL " +
                    "," + BusinessC.COUNTRY + " TEXT NOT NULL " +
                    "," + BusinessC.Email + " TEXT  " +
                    "," + BusinessC.NAME + " TEXT NOT NULL " +
                    "," + BusinessC.PHONE + " TEXT NOT NULL " +
                    "," + BusinessC.STREET + " TEXT NOT NULL " +
                    "," + BusinessC.WEBSITE + " TEXT " +
                    " ) ";
    public  static final String CREATE_DB_BUSINESSACTIVITY_TABLE =
            " CREATE TABLE " + BUSINESSACTIVITY_TABLE_NAME +
                    " ( " +
                    ""  + BusinessActivityC.ID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                    "," + BusinessActivityC.DESCRIPTTION + " TEXT " +
                    "," + BusinessActivityC.COUNTRY + " TEXT " +
                    "," + BusinessActivityC.DETIALES + " TEXT " +
                    "," + BusinessActivityC.SDATE + " TEXT " +
                    "," + BusinessActivityC.EDATE + " TEXT " +
                    "," + BusinessActivityC.PRICE + " TEXT " +
                    " ) ";

}

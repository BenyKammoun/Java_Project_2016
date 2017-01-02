package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.data_source.SqlDb;
import static com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract.BUSINESS_TABLE_NAME;
import static com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract.BUSINESSACTIVITY_TABLE_NAME;


import java.util.HashMap;



public class SqlProvider extends ContentProvider {

    SqlDb SqlDbManger = null;
    protected SQLiteDatabase db;
    private static HashMap<String, String> PROJECTION;

    final String businessCase = "business";
    final String businessActivityCase = "businessActivity";

    @Override
    public boolean onCreate() {
        //-- Create DataBase Helper: (create database: DATABASE_NAME)
        Context context = getContext();
        SqlDbManger = new SqlDb(context);

        //-- Open DataBase Connection
        db = SqlDbManger.getWritableDatabase();
        return (db == null)? false:true;

    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String tableName = uri.getPathSegments().get(0);
        switch (tableName) {
            case businessCase:
                qb.setTables(BUSINESS_TABLE_NAME);
                switch (uri.getPathSegments().get(1)) {
                    case "ALL":
                        qb.setProjectionMap(PROJECTION);
                        break;

                    case "SINGLE":
                        qb.appendWhere(DBContract.BusinessC.ID + "=" + uri.getPathSegments().get(2));
                        break;
                    default:
                        break;
                }
                break;
            case businessActivityCase:
                qb.setTables(BUSINESSACTIVITY_TABLE_NAME);
                switch (uri.getPathSegments().get(1)) {
                    case "ALL":
                        qb.setProjectionMap(PROJECTION);
                        break;
                    case "SINGLE":
                        qb.appendWhere(DBContract.BusinessActivityC.ID + "=" + uri.getPathSegments().get(2));
                        break;
                    default:
                        break;

                }
                break;
            default:
                break;
        }
        Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, null);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }
    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
        }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String tableName = uri.getPathSegments().get(0);
        long rowID=0;
        switch (tableName) {
            case businessCase:
                rowID = db.insert(BUSINESS_TABLE_NAME, "", values);
                break;
            case businessActivityCase:
                rowID = db.insert(BUSINESSACTIVITY_TABLE_NAME, "", values);
                break;
            default:
                break;
        }
        if (rowID > 0) {
            Uri _uri = ContentUris.withAppendedId(uri.parse("content://com.a2016.proj.sql"), rowID);
            getContext().getContentResolver().notifyChange(_uri, null);
            SqlDbManger.setChanged();
            return _uri;
        }
return null;
       // throw new SQLException("Failed to add a record into " + uri);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        int count = 0;
        String tableName = uri.getPathSegments().get(0);
        switch (tableName) {
            case businessCase:
                switch (uri.getPathSegments().get(1)) {
                    case "ALL":
                        count = db.delete(BUSINESS_TABLE_NAME, selection, selectionArgs);
                        break;

                    case "SINGLE":
                        String id = uri.getPathSegments().get(1);
                        count = db.delete(BUSINESS_TABLE_NAME, DBContract.BusinessC.ID + " = " + id +
                                (!TextUtils.isEmpty(selection) ? "  AND (" + selection + ')' : ""), selectionArgs);
                        break;
                    default:
                        break;
                }
                break;
            case businessActivityCase:
                switch (uri.getPathSegments().get(1)) {
                    case "ALL":
                        count = db.delete(BUSINESSACTIVITY_TABLE_NAME, selection, selectionArgs);
                        break;

                    case "SINGLE":
                        String id = uri.getPathSegments().get(1);
                        count = db.delete(BUSINESSACTIVITY_TABLE_NAME, DBContract.BusinessC.ID + " = " + id +
                                (!TextUtils.isEmpty(selection) ? "  AND (" + selection + ')' : ""), selectionArgs);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        SqlDbManger.setChanged();
        return count;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        int count = 0;
        String tableName = uri.getPathSegments().get(0);
        switch (tableName) {
            case businessCase:
                count = db.update(BUSINESS_TABLE_NAME, values,
                        DBContract.BusinessC.ID + " = " + uri.getPathSegments().get(1) +
                                (!TextUtils.isEmpty(selection) ? " AND (" +selection + ')' : ""), selectionArgs);
                break;
            case businessActivityCase:
                count = db.update(BUSINESSACTIVITY_TABLE_NAME, values,
                        DBContract.BusinessC.ID + " = " + uri.getPathSegments().get(1) +
                                (!TextUtils.isEmpty(selection) ? " AND (" +selection + ')' : ""), selectionArgs);
                break;
            default:
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        SqlDbManger.setChanged();
        return count;
    }
}

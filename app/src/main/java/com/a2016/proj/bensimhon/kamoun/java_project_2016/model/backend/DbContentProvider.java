package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class DbContentProvider extends ContentProvider {

    Context context;
    DB_manager manager;
    final String TAG = "ContentProvider";
    final String businessCase = "business";
    final String businessActivityCase = "businessActivity";

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        Log.d(TAG, "delete " + uri.toString());

        String listName = uri.getPathSegments().get(0);
        long id = Long.parseLong(uri.getPathSegments().get(1));
        switch (listName) {
            case businessCase:
                if (manager.removeBusiness(id))
                    return 1;
                break;

            case businessActivityCase:
                if (manager.removeBusinessActivity(id))
                    return 1;
                break;
        }
        return 0;
    }

    @Override
    public String getType(Uri uri) {

        Log.d(TAG, "getType " + uri.toString());
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        Log.d(TAG, "insert " + uri.toString());

        String listName = uri.getPathSegments().get(0);
        long id = -1;
        switch (listName) {
            case businessCase:
                id = manager.addBusiness(values);
                return ContentUris.withAppendedId(uri, id);


            case businessActivityCase:
                id = manager.addBusinessActivity(values);
                return ContentUris.withAppendedId(uri, id);

        }
        return null;
    }

    @Override
    public boolean onCreate() {
        Log.d(TAG, "onCreate");
         context = getContext();
         manager = DBManagerFactory.getManager(context);

        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        Log.d(TAG, "query " + uri.toString());

        String listName = uri.getPathSegments().get(0);
        switch (listName) {
            case businessCase:
                return manager.getBusinesses();//

            case businessActivityCase:
                return manager.getBusinessesAct();//

        }
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        Log.d(TAG, "update " + uri.toString());

        String listName = uri.getPathSegments().get(0);
        long id = Long.parseLong(uri.getPathSegments().get(1));
        int indexToUpdate = -1;
        switch (listName) {
            case businessCase:
                if (manager.updateBusiness(id, values))
                    return 1;
                break;

            case businessActivityCase:
                if (manager.updateBusinessActivity(id, values))
                    return 1;
                break;
        }

        return 0;
    }
}

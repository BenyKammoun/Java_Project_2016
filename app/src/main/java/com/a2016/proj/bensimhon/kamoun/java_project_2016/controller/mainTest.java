package com.a2016.proj.bensimhon.kamoun.java_project_2016.controller;

import android.content.ContentValues;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.R;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract;

public class mainTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);
    }


    private void addBusiness() {
        final Uri uri = DBContract.BusinessC.AUTHORITY_URI;
        final ContentValues contentValues = new ContentValues();
        contentValues.put(DBContract.BusinessC.PHONE, "0501234657");
        contentValues.put(DBContract.BusinessC.NAME, "mybusn");
        contentValues.put(DBContract.BusinessC.CITY, "aaaaa");
        contentValues.put(DBContract.BusinessC.STREET, "street");
        contentValues.put(DBContract.BusinessC.COUNTRY, "country");
        contentValues.put(DBContract.BusinessC.Email, "yosef@test.com");
        contentValues.put(DBContract.BusinessC.WEBSITE, "aaaa.co.il");

        new AsyncTask<Void,Void,Void>()
        {
            @Override
            protected Void doInBackground(Void... params) {
                getContentResolver().insert(uri,contentValues);
                return null;
            }
        }.execute();
    }

    public void testClick(View view) {
        addBusiness();
    }
}

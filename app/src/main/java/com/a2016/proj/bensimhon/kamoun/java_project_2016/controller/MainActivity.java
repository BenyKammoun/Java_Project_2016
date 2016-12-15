package com.a2016.proj.bensimhon.kamoun.java_project_2016.controller;

import android.content.ContentValues;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.datasource.List_Business;

public class MainActivity extends AppCompatActivity  {

    List_Business LB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.a2016.proj.bensimhon.kamoun.java_project_2016.R.layout.activity_main);
        LB= new List_Business();

    }

    public void goButtonClicked(View v) {
        addBusiness();
    }


    private void readFromCP()
    {


    }

    private void addBusiness() {
        final Uri uri = Uri.parse("content://com.a2016.proj.Business");
        final ContentValues contentValues = new ContentValues();
        contentValues.put(DBContract.BusinessC.ID, Integer.valueOf(123));
        contentValues.put(DBContract.BusinessC.NAME,"mybusn");
        contentValues.put(DBContract.BusinessC.CITY, "aaaaa");
        contentValues.put(DBContract.BusinessC.STREET, "street");
        contentValues.put(DBContract.BusinessC.COUNTRY, "country");

        getContentResolver().insert(uri,contentValues);




        LB.equals(null);
    }


}

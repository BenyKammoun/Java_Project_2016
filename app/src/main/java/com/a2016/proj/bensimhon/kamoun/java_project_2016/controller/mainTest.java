package com.a2016.proj.bensimhon.kamoun.java_project_2016.controller;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.R;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities.Business;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.enums.BusinessType;

import java.net.URI;

public class mainTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_test);

        View view = findViewById(R.id.activity_main_test);
        RelativeLayout rl=(RelativeLayout)view;
        rl.addView(new Button(rl.getContext()));
        View v = LayoutInflater.from(rl.getContext()).inflate(R.layout.buiseness_item_view, null);
        rl.addView(v);
    }

    static int i=10;
    private void addBusiness() {

        final Uri uri = DBContract.BusinessC.AUTHORITY_URI;
        final ContentValues contentValues = new ContentValues();
        contentValues.put(DBContract.BusinessC.ID, i++);
        contentValues.put(DBContract.BusinessC.PHONE, "0501234657");
        contentValues.put(DBContract.BusinessC.NAME, "mybusn");
        contentValues.put(DBContract.BusinessC.CITY, "aaaaa");
        contentValues.put(DBContract.BusinessC.STREET, "street");
        contentValues.put(DBContract.BusinessC.COUNTRY, "country");
        contentValues.put(DBContract.BusinessC.Email, "yosef@test.com");
        contentValues.put(DBContract.BusinessC.WEBSITE, "aaaa.co.il");
        contentValues.put(DBContract.BusinessC.TYPE, BusinessType.Tourism_Agency.toString());

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

    public void testRead(View view) {

        new AsyncTask<Void, Void, Cursor>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Cursor doInBackground(Void... params) {
                return getContentResolver().query(DBContract.BusinessC.AUTHORITY_URI,
                        null,
                        null,
                        null,
                        null);
                // return null;
            }

            @Override
            protected void onPostExecute(Cursor cursor) {
                super.onPostExecute(cursor);
                if (cursor.moveToFirst()) {
                    do {

                        long id = cursor.getLong(cursor.getColumnIndex(DBContract.BusinessC.ID));
                        String name = cursor.getString(cursor.getColumnIndex(DBContract.BusinessC.NAME));
                        String phone = cursor.getString(cursor.getColumnIndex(DBContract.BusinessC.PHONE));

                    } while (cursor.moveToNext());
                }
            }

        }.execute();

    }
}

package com.a2016.proj.bensimhon.kamoun.java_project_2016.controller;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.R;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBManagerFactory;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateItemList(this);
    }

    private void updateItemList(final Context context) {


        new AsyncTask<Void, Void, Cursor>() {
            ListView itemListView= (ListView) findViewById(R.id.bsness_lst);
            @Override
            protected void onPreExecute() {
             return;
            }

            @Override
            protected Cursor doInBackground(Void... params) {
                return DBManagerFactory.getManager(context).getBusinesses();
                // return null;
            }

            @Override
            protected void onPostExecute(Cursor cursor) {
                super.onPostExecute(cursor);
                CursorAdapter adapter = new CursorAdapter(context, cursor) {
                    @Override
                    public View newView(Context context, Cursor cursor, ViewGroup parent) {
                        TextView tv = new TextView(context);

                        return tv;
                    }

                    @Override
                    public void bindView(View view, Context context, Cursor cursor) {
                        TextView tv = (TextView) view;
                        tv.setText("[" + cursor.getString(0) + "]  " + cursor.getString(1));
                    }

                };

                itemListView.setAdapter(adapter);

            }
        }.execute();

    }
}

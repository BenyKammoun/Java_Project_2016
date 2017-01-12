package com.a2016.proj.bensimhon.kamoun.java_project_2016.controller;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.R;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBManagerFactory;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.enums.BusinessType;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final Uri uri = DBContract.BusinessC.AUTHORITY_URI;
        updateItemList(this,uri);

    }


    private void updateItemList(final Context context, final Uri uri) {


        new AsyncTask<Void, Void, Cursor>() {
            ListView itemListView= (ListView) findViewById(R.id.bsness_lst);
            @Override
            protected void onPreExecute() {
                return;
            }

            @Override
            protected Cursor doInBackground(Void... params) {
                return   getContentResolver().query(uri,null,null,null,null);
                // return null;
            }

            @Override
            protected void onPostExecute(Cursor cursor) {
                CursorAdapter adapter = new CursorAdapter(context, cursor) {
                    @Override
                    public View newView(Context context, Cursor cursor, ViewGroup parent) {
                        try {
                            Context c = findViewById(R.id.add_bttn).getContext();
                            View v = LayoutInflater.from(context).inflate(R.layout.buiseness_item_view, parent,false);

                            TextView tv = new TextView(context);
                            return v;

                        } catch (final Throwable aaa) {
                            String str=aaa.getMessage();
                            return  null;
                        }

                    }
                    @Override
                    public void bindView(View view, Context context, Cursor cursor) {
                        /*TextView tv = (TextView) view;
                        tv.setText("[" + cursor.getString(0) + "]  " + cursor.getString(1));
                        return;*/
                        try {
                            if (view == null)
                                return;

                            TextView tv = (TextView) view.findViewById(R.id.biv_name);
                            tv.setText(cursor.getString(cursor.getColumnIndexOrThrow("name")));
                            tv = (TextView) view.findViewById(R.id.biv_mail);
                            tv.setText(cursor.getString(cursor.getColumnIndexOrThrow("email")));
                            ImageView img = (ImageView) view.findViewById(R.id.biv_image);

                            BusinessType curBt= BusinessType.valueOf((cursor.getString(cursor.getColumnIndexOrThrow("type"))));
                            switch (curBt) {
                                case Flight:
                                    img.setImageDrawable(getResources().getDrawable(R.drawable.flight));
                                    break;

                                case Tourism_Agency:
                                    img.setImageDrawable(getResources().getDrawable(R.drawable.tourism_agency));
                                    break;

                                case Hotel:
                                    img.setImageDrawable(getResources().getDrawable(R.drawable.hotel));
                                default:

                                    break;
                            }

                        } catch (final Throwable aaa) {
                            String str = aaa.getMessage();

                        }
                    }

                };

                itemListView.setAdapter(adapter);

            }
        }.execute();

    }

    public void addBttnClick(View view) {
        try {
            Intent regIntent = new Intent(this, AddBusinessActivity.class);
            startActivity(regIntent);
        }
        catch (Throwable ex){
            String str =ex.getMessage();
        }
    }
}

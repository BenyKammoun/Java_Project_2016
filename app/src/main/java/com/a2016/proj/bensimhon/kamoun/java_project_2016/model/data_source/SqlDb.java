package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.data_source;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract.DATABASE_NAME;
import static com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract.DATABASE_VERSION;
import static com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract.BUSINESS_TABLE_NAME;
import static com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract.BUSINESSACTIVITY_TABLE_NAME;
import static com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract.CREATE_DB_BUSINESS_TABLE;
import static com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract.CREATE_DB_BUSINESSACTIVITY_TABLE;

public class SqlDb extends SQLiteOpenHelper {

    public SqlDb(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    private boolean isChanged =false;
    public void setChanged() {
        isChanged = true;
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

    public boolean haveUpdate() {

        if(isChanged)
        {
            isChanged = false;
            return  true;
        }

        return false;
    }

}

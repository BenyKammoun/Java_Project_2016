package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend;

import android.content.ContentValues;
import android.database.Cursor;

/**
 * Created by yosef on 12/21/2016.
 */

public interface BusinessActivityDB {
    public boolean removeBusinessActivity(long id);
    public long addBusinessActivity(ContentValues values);
    public Cursor getBusinessActivty();
    public boolean updateBusinessActivty(int id, ContentValues values);

}

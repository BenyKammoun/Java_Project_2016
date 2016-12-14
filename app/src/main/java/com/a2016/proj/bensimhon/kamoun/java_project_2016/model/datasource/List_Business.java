package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.datasource;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.provider.ContactsContract;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities.Address;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities.Business;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yosef on 12/11/2016.
 */

public class List_Business {

    static List<Business> businessDb;

    public List_Business() {
        businessDb = new ArrayList<Business>();
        init();
    }

    public boolean removeBusiness(long id) {
        Business businessToRemove = null;
        for (Business item : businessDb)
            if (item.getID() == id) {
                businessToRemove = item;
                break;
            }
        return businessDb.remove(businessToRemove);
    }

    public long addBusiness(ContentValues values) {

        Business business = ContentValuesToBusiness(values);
        businessDb.add(business);
        return business.getID();
    }

    public Cursor getBusiness() {
        String[] columns = new String[]
                {
                        DBContract.Business.ID,
                        DBContract.Business.NAME,
                        DBContract.Business.ADRESS
                };

        MatrixCursor matrixCursor = new MatrixCursor(columns);

        for (Business s : businessDb) {
            matrixCursor.addRow(new Object[]{s.getID(), s.getName(), s.getAddress()});
        }

        return matrixCursor;
    }

    public boolean updateBusiness(int id, ContentValues values) {
        Business business = ContentValuesToBusiness(values);
        for (int i = 0; i < businessDb.size(); i++)
            if (businessDb.get(i).getID() == id) {
                businessDb.get(i).setName(business.getName());
                businessDb.get(i).setAddress(business.getAddress());
                return true;
            }
        return false;
    }

    private Business ContentValuesToBusiness(ContentValues contentValues) {

        Business business = new Business();
        business.setID(contentValues.getAsInteger(DBContract.Business.ID));
        business.setName(contentValues.getAsString(DBContract.Business.NAME));
        business.setPhoneNumb(contentValues.getAsLong(DBContract.Business.PHONE));

        Address busAddr = new Address();
        busAddr.setCity(contentValues.getAsString(DBContract.Business.CITY));
        busAddr.setCountry(contentValues.getAsString(DBContract.Business.COUNTRY));
        busAddr.setStreet(contentValues.getAsString(DBContract.Business.STREET));
        business.setAddress(busAddr);

        return business;
    }

    private void init()
    {
        Business temp;
        for (int i =0 ; i<5;i++)
        {
             temp = new Business();
            temp.setID(i);
            temp.setName("name"+Integer.toString(i));
            temp.setPhoneNumb((long)(50000000+i));
            businessDb.add(temp);
        }
    }
}

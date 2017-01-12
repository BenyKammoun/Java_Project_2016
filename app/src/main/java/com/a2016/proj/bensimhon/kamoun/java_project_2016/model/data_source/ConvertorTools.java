package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.data_source;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DBContract;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities.Address;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities.Business;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities.BusinessActivity;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.enums.BusinessType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


/**
 * Created by mailo on 26/11/2016.
 */

public class ConvertorTools {

    public static ContentValues BusinessToContentValues(Business business) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBContract.BusinessC.ID, business.getID());
        contentValues.put(DBContract.BusinessC.NAME, business.getName());
        contentValues.put(DBContract.BusinessC.WEBSITE, business.getWebsite().toString());
        contentValues.put(DBContract.BusinessC.Email, business.getEmail());
        contentValues.put(DBContract.BusinessC.PHONE, business.getPhoneNumb());
        contentValues.put(DBContract.BusinessC.COUNTRY, business.getAddress().getCountry().toString());
        contentValues.put(DBContract.BusinessC.CITY, business.getAddress().getCity().toString());
        contentValues.put(DBContract.BusinessC.STREET, business.getAddress().getStreet());
        contentValues.put(DBContract.BusinessC.STREET, business.getType().toString());
        return contentValues;
    }

    public static ContentValues BusinessActivityToContentValues(BusinessActivity businessActivity) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBContract.BusinessActivityC.ID, businessActivity.getId());
        contentValues.put(DBContract.BusinessActivityC.COUNTRY, businessActivity.getCountry());
        contentValues.put(DBContract.BusinessActivityC.PRICE, businessActivity.getPrice());
        contentValues.put(DBContract.BusinessActivityC.EDATE, businessActivity.getEndDate().toString());
        contentValues.put(DBContract.BusinessActivityC.SDATE, businessActivity.getStartDate().toString());
        contentValues.put(DBContract.BusinessActivityC.DESCRIPTTION, businessActivity.getDescription());
        contentValues.put(DBContract.BusinessActivityC.DETIALES, businessActivity.getDetails());
        contentValues.put(DBContract.BusinessActivityC.BID, businessActivity.getBusinessId());
        return contentValues;
    }

    public static Business ContentValuesToBusiness(ContentValues contentValues) {

        Business business = new Business();
        business.setID(contentValues.getAsInteger(DBContract.BusinessC.ID));
        business.setName(contentValues.getAsString(DBContract.BusinessC.NAME));
        business.setPhoneNumb(contentValues.getAsString(DBContract.BusinessC.PHONE));
        business.setEmail(contentValues.getAsString(DBContract.BusinessC.Email));
        try {
            business.setWebsite( new URL(contentValues.getAsString(DBContract.BusinessC.WEBSITE)));
        } catch (MalformedURLException e) {
            business.setWebsite(null);
        }

        Address busAddr = new Address();
        busAddr.setCity(contentValues.getAsString(DBContract.BusinessC.CITY));
        busAddr.setCountry(contentValues.getAsString(DBContract.BusinessC.COUNTRY));
        busAddr.setStreet(contentValues.getAsString(DBContract.BusinessC.STREET));
        business.setAddress(busAddr);
        business.setType(BusinessType.valueOf(contentValues.getAsString(DBContract.BusinessC.TYPE)));

        return business;
    }

    public static BusinessActivity ContentValuesToBusinessActivity(ContentValues contentValues) {

        BusinessActivity businessAct = new BusinessActivity();
        businessAct.setCountry(contentValues.getAsString(DBContract.BusinessActivityC.COUNTRY));
        businessAct.setDescription(contentValues.getAsString(DBContract.BusinessActivityC.DESCRIPTTION));
        businessAct.setDetails(contentValues.getAsString(DBContract.BusinessActivityC.DETIALES));
        businessAct.setEndDate(contentValues.getAsString(DBContract.BusinessActivityC.EDATE));
        businessAct.setStartDate(contentValues.getAsString(DBContract.BusinessActivityC.SDATE));
        businessAct.setId(contentValues.getAsInteger(DBContract.BusinessActivityC.ID));
        businessAct.setPrice(contentValues.getAsInteger(DBContract.BusinessActivityC.PRICE));
        businessAct.setBusinessId(contentValues.getAsInteger(DBContract.BusinessActivityC.BID));
        return businessAct;
    }

    public static Cursor BusinessListToCursor(List<Business> businesses) {
        String[] columns = new String[]
                {
                        DBContract.BusinessC.ID,
                        DBContract.BusinessC.NAME,
                        DBContract.BusinessC.COUNTRY
                };

        MatrixCursor matrixCursor = new MatrixCursor(columns);

        for (Business b : businesses) {
            matrixCursor.addRow(new Object[]{b.getID(), b.getName(), b.getAddress().getCountry()});
        }
        return matrixCursor;
    }

    public static Cursor BusinessActivityListToCursor(List<BusinessActivity> BusinessAct) {
        String[] columns = new String[]
                {

                };

        MatrixCursor matrixCursor = new MatrixCursor(columns);

        for (BusinessActivity ba : BusinessAct) {
            matrixCursor.addRow(new Object[]{});
        }

        return matrixCursor;
    }
}

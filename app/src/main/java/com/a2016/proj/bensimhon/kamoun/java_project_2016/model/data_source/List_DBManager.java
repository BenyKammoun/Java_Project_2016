package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.data_source;
import android.content.ContentValues;
import android.database.Cursor;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend.DB_manager;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities.Business;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities.BusinessActivity;

import java.security.KeyPair;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ezra Steinmetz on August 2016
 */
public class List_DBManager implements DB_manager {

    static List<Business> businessList;
    static List<BusinessActivity> businessActivityList;
    static List<AbstractMap.SimpleEntry<Integer,Integer>> activityToBusiness;

boolean isUpdate = false;


    static {
        businessList = new ArrayList<>();
        businessActivityList = new ArrayList<>();
        activityToBusiness = new ArrayList<AbstractMap.SimpleEntry<Integer, Integer>>();
    }


    @Override
    public boolean removeBusiness(long id) {
        Business businessToRemove = null;
        for (Business item : businessList)
            if (item.getID()== id) {
                businessToRemove = item;
                isUpdate = true;
                break;
            }

        return businessList.remove(businessToRemove);

    }

    @Override
    public boolean removeBusinessActivity(long id) {
        BusinessActivity businessActivityToRemove = null;
        for (BusinessActivity item : businessActivityList)
            if (item.getId() == id) {
                businessActivityToRemove = item;
                isUpdate = true;
                break;
            }
        return businessActivityList.remove(businessActivityToRemove);
    }

    @Override
    public long addBusiness(ContentValues values) {

        Business business = ConvertorTools.ContentValuesToBusiness(values);
        businessList.add(business);
        isUpdate=true;
        return business.getID();
    }

    @Override
    public long addBusinessActivity(ContentValues values) {

        BusinessActivity businessActivity = ConvertorTools.ContentValuesToBusinessActivity(values);
        businessActivityList.add(businessActivity);
        isUpdate=true;
        return businessActivity.getId();
    }

    @Override
    public Cursor getBusinesses() {
        return ConvertorTools.BusinessListToCursor(businessList);
    }

    @Override
    public Cursor getBusinessesAct() {
        return ConvertorTools.BusinessActivityListToCursor(businessActivityList);
    }

    @Override
    public Cursor getAllActivitiesOfBusiness() {
        return null;
    }

    @Override
    public boolean updateBusiness(long id, ContentValues values) {
        Business business = ConvertorTools.ContentValuesToBusiness(values);
        for (int i = 0; i < businessList.size(); i++)
            if (businessList.get(i).getID() == id) {
                businessList.get(i).setName(business.getName());
                isUpdate=true;
                return true;
            }
        return false;
    }

    @Override
    public boolean updateBusinessActivity(long id, ContentValues values) {
        BusinessActivity businessActivity = ConvertorTools.ContentValuesToBusinessActivity(values);
        for (int i = 0; i < businessActivityList.size(); i++)
            if (businessActivityList.get(i).getId() == id) {
                businessActivityList.get(i).setDescription(businessActivity.getDescription());
                isUpdate=true;
                return true;
            }
        return false;
    }

    @Override
    public boolean linkActToBusiness(Integer bId, Integer aId) {
        for (AbstractMap.SimpleEntry<Integer, Integer> pair:activityToBusiness
             ) {
            if((pair.getKey()==bId)&&(pair.getValue()==aId))
                return false;
        }
        activityToBusiness.add(new AbstractMap.SimpleEntry<Integer, Integer>(bId,aId) {
        });
        return true;
    }

    @Override
    public boolean isUpdate() {

        if(isUpdate)
        {
            isUpdate = false;
            return  true;
        }

        return  false;
    }
}
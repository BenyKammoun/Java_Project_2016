package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.datasource;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.model.entities.BusinessActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yosef on 12/14/2016.
 */

public class List_BusinessActivity {

        static List<BusinessActivity> businessActDb;

        public List_BusinessActivity() {
            businessActDb = new ArrayList<BusinessActivity>();
            init();
        }

        public boolean removeBusiness(long id) {
            BusinessActivity businessToRemove = null;
            for (BusinessActivity item : businessActDb){}
               // if (item.getID() == id) {
                 //   businessToRemove = item;
                   // break;
                //}

                return true;
            //return businessActDb.remove(businessToRemove);

        }

        public long addBusiness(ContentValues values) {

            BusinessActivity businessActivity = ContentValuesToBusinessActivity(values);
            businessActDb.add(businessActivity);
            return 1;//// TODO: 12/14/2016
        }

        public Cursor getBusinessActivty() {
            String[] columns = new String[]
                    {
                        //// TODO: 12/14/2016
                    };

            MatrixCursor matrixCursor = new MatrixCursor(columns);

            for (BusinessActivity s : businessActDb) {
                matrixCursor.addRow(new Object[]{});
            }

            return matrixCursor;
        }

        public boolean updateBusiness(int id, ContentValues values) {
            BusinessActivity business = ContentValuesToBusinessActivity(values);
            for (int i = 0; i < businessActDb.size(); i++){
                    return true;
                //// TODO: 12/14/2016
                }
            return false;
        }

        private BusinessActivity ContentValuesToBusinessActivity(ContentValues contentValues) {

            BusinessActivity businessAct = new BusinessActivity();

            return businessAct;
        }

        private void init()
        {
            BusinessActivity temp;
            for (int i =0 ; i<5;i++)
            {
                temp = new BusinessActivity();
            }
        }
    }

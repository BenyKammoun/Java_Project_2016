package com.a2016.proj.bensimhon.kamoun.java_project_2016.model.backend;

import android.net.Uri;


/**
 * Created by mailo on 08/12/2016.
 */

public class DBContract {

    /**
     * The authority for the contacts provider
     */
    public static final String BusinessAUTHORITY = "com.a2016.proj.Business";
    public static final String BusinessActivityAUTHORITY = "com.a2016.proj.BusinessActivity";


    public static class BusinessC {
        /**
         * A content:// style uri to the authority for the contacts provider
         */
        public static final Uri AUTHORITY_URI = Uri.parse("content://" + BusinessAUTHORITY);

        public static final String ID = "_id";
        public static final String NAME = "name";
        public static final String ADRESS = "adress";
        public static final String PHONE = "phone";
        public static final String Email = "email";
        public static final String WEBSITE = "website";
        public static final String COUNTRY = "country";
        public static final String CITY = "city";
        public static final String STREET = "street";

        /**
         * The content:// style URI for this table
         */
        public static final Uri STUDENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "business");
    }

    public static class BusinessActivityC {
        /**
         * A content:// style uri to the authority for the contacts provider
         */
        public static final Uri AUTHORITY_URI = Uri.parse("content://" + BusinessActivityAUTHORITY);

        public static final String BUSINESSActivity_ID = "_id";

        /**
         * The content:// style URI for this table
         */
        public static final Uri COURSE_URI = Uri.withAppendedPath(AUTHORITY_URI, "courses");
    }

}

package com.a2016.proj.bensimhon.kamoun.java_project_2016.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.a2016.proj.bensimhon.kamoun.java_project_2016.R;

/**
 * Created by Binyamin Kamoun on 14/12/2016.
 */

public class LogInActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /*
    * Events
    * */
    public void signUpClick(View view){
        //IF(User doesn't exist)
        //    then GO TO SIGN-UP ACTIVITY
        //ELSE
        //    GO TO MAIN ACTIVITY
        Intent regIntent = new Intent(this, SignUpActivity.class);
        startActivity(regIntent);
    }
}

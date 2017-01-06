package com.a2016.proj.bensimhon.kamoun.java_project_2016.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.R;

public class LogInActivity extends Activity {

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        sharedpreferences = getSharedPreferences(getResources().getString(R.string.SpAppShPref), Context.MODE_PRIVATE);

        if (sharedpreferences.contains(getResources().getString(R.string.SpUserName))) {
            Intent regIntent = new Intent(this, MainActivity.class);
            startActivity(regIntent);
        }
    }

    /*
    * Events
    * */
    public void signUpClick(View view){
        Intent regIntent = new Intent(this, SignUpActivity.class);
        startActivity(regIntent);
    }

    public void signInClick(){
        //IF(User doesn't exist)
        //    ERROR: "You have to be registered"
        //ELSE
        //  Intent goToMain = new Intent(this, MainActivity.class);
        //  startActivity(goToMain);
    }
}

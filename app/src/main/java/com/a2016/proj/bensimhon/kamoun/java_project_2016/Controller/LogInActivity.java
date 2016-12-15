package com.a2016.proj.bensimhon.kamoun.java_project_2016.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.R;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
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

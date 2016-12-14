package com.a2016.proj.bensimhon.kamoun.java_project_2016.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.R;

/**
 * Created by Binyamin Kamoun on 14/12/2016.
 */

public class LogInActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void signUpClick(){
        Intent regIntent = new Intent(this, LogInActivity.class);
        startActivity(regIntent);
    }
}

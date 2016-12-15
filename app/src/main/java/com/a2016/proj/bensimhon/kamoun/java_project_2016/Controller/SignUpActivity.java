package com.a2016.proj.bensimhon.kamoun.java_project_2016.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void onCheckBoxClick(View view){
        CheckBox shwPsswdChcbx = (CheckBox)view;
        shwPsswdChcbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                EditText password = (EditText)findViewById(R.id.passwd_input);
                if(!isChecked)
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                else
                    password.setInputType(129);
            }
        });
    }

    public void signUpClick(View view){
        Intent regIntent = new Intent(this, MainActivity.class);
        startActivity(regIntent);
    }
}

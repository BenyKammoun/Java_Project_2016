package com.a2016.proj.bensimhon.kamoun.java_project_2016.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.a2016.proj.bensimhon.kamoun.java_project_2016.R;

public class SignUpActivity extends Activity {
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void onCheckBoxClick(View view){
        CheckBox shwPsswdChcbx = (CheckBox)view;
        EditText password = (EditText) findViewById(R.id.pswd);
        EditText cnfrmPassword = (EditText) findViewById(R.id.cnfrm_pswd);

        if(shwPsswdChcbx.isChecked()){
            password.setInputType(InputType.TYPE_CLASS_TEXT);
            cnfrmPassword.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        if(!shwPsswdChcbx.isChecked()){
            password.setInputType(129);
            cnfrmPassword.setInputType(129);
        }
    }

    public void signUpClick(View view){
        EditText password = (EditText) findViewById(R.id.pswd);
        EditText cnfPassword = (EditText) findViewById(R.id.cnfrm_pswd);

        if(!password.getText().toString().equals(cnfPassword.getText().toString()))
        {
            passErrorAlert();
            return;
        }

        sharedpreferences = getSharedPreferences( getResources().getString(R.string.SpAppShPref), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString( getResources().getString(R.string.SpUserName), findViewById(R.id.new_usn).toString());
        editor.putString(getResources().getString(R.string.SpUserPassword), findViewById(R.id.pswd).toString());
        editor.commit();

        Intent regIntent = new Intent(this, MainActivity.class);
        startActivity(regIntent);
    }

    private void passErrorAlert() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Password Error")
                .setMessage("Passwords don't match")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                        dialoginterface.cancel();
                    }
                }).show();
    }

    private void savePreferences()
    {

    }
}

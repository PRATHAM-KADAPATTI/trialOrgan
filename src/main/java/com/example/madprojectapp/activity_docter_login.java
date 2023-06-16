package com.example.madprojectapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageButton;

public class activity_docter_login extends AppCompatActivity {

    EditText editDocUser, editDocPass;
    ImageButton btnSignin;
    ImageButton btnSingup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docter_login);

        editDocUser = (EditText)findViewById(R.id.edit_docUser);
        editDocPass = (EditText)findViewById(R.id.edit_docPass);
        btnSignin = (ImageButton) findViewById(R.id.btn_signin);
        btnSingup = (ImageButton) findViewById(R.id.btn_signup);

        btnSignin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String msg1 = editDocUser.getText().toString();
                String msg2 = editDocPass.getText().toString();
                Intent it = new Intent(activity_docter_login.this,activity_dashboard.class);
                it.putExtra("message", msg1);
                it.putExtra("message", msg2);
                startActivity(it);
            }
        });
        btnSingup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent it = new Intent(activity_docter_login.this,activity_docter_register.class);
                startActivity(it);
            }
        });
    }




}
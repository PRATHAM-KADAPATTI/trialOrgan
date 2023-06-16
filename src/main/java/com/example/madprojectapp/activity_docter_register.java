package com.example.madprojectapp;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.Collections;


public class activity_docter_register extends AppCompatActivity {

    Spinner specilization, hospitalName;
    EditText docName, docUsername, docPass, docConfPass;
    ImageButton signup, signin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docter_register);

        docName = findViewById(R.id.edit_docName);
        specilization = findViewById(R.id.spinner_docSpecilization);
        hospitalName = findViewById(R.id.spinner_hospName);
        docUsername = findViewById(R.id.edit_docUsername);
        docPass = findViewById(R.id.edit_docPass);
        docConfPass = findViewById(R.id.edit_docConfPass);
        signup = findViewById(R.id.btn_signup);
        signin = findViewById(R.id.btn_signin);

        String Spec = String.valueOf(getResources().getStringArray(R.array.doc_spec));
        String hosN = String.valueOf(getResources().getStringArray(R.array.doc_hospitalName));

        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Collections.singletonList(Spec));
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Collections.singletonList(hosN));

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        specilization.setAdapter(adapter1);
        hospitalName.setAdapter(adapter2);

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String msg1 = docName.getText().toString();
                String msg2 = docUsername.getText().toString();
                String msg3 = docPass.getText().toString();
                String msg4 = docConfPass.getText().toString();
                String msg5 = specilization.getSelectedItem().toString();
                String msg6 = hospitalName.getSelectedItem().toString();

                Intent it = new Intent(activity_docter_register.this,activity_dashboard.class);
                it.putExtra("message1", msg1);
                it.putExtra("message2", msg2);
                it.putExtra("message3", msg3);
                it.putExtra("message4", msg4);
                it.putExtra("message5", msg5);
                it.putExtra("message6", msg6);


                startActivity(it);
            }
        });
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent it = new Intent(activity_docter_register.this,activity_docter_login.class);
                startActivity(it);
            }
        });

    }

}
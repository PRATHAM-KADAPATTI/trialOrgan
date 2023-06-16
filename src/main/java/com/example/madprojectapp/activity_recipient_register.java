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

public class activity_recipient_register extends AppCompatActivity {

    Spinner recGender, recOrgReq;
    EditText recName, recBloodGrp, recAge, recEmail, recPhNo, reportCard;
    ImageButton signup, signin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_register);

        recName = findViewById(R.id.edit_docName);
        recGender = findViewById(R.id.spinner_docSpecilization);
        recOrgReq = findViewById(R.id.spinner_hospName);
        recBloodGrp = findViewById(R.id.edit_docUsername);
        recAge = findViewById(R.id.edit_docPass);
        recEmail = findViewById(R.id.edit_docConfPass);
        recPhNo = findViewById(R.id.edit_docConfPass);

        reportCard = findViewById(R.id.edit_reportCard);

        signup = findViewById(R.id.btn_signup);
        signin = findViewById(R.id.btn_signin);


        String gender = String.valueOf(getResources().getStringArray(R.array.rec_gender));
        String orgReq = String.valueOf(getResources().getStringArray(R.array.rec_orgon));

        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Collections.singletonList(gender));
        ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Collections.singletonList(orgReq));

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        recGender.setAdapter(adapter1);
        recOrgReq.setAdapter(adapter2);

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String msg1 = recName.getText().toString();
                String msg2 = recBloodGrp.getText().toString();
                String msg3 = recAge.getText().toString();
                String msg4 = recEmail.getText().toString();
                String msg5 = recPhNo.getText().toString();

                String msg6 = reportCard.getText().toString();

                String msg7 = recGender.getSelectedItem().toString();
                String msg8 = recOrgReq.getSelectedItem().toString();

                Intent it = new Intent(activity_recipient_register.this,activity_recipient_profile.class);
                it.putExtra("message1", msg1);
                it.putExtra("message2", msg2);
                it.putExtra("message3", msg3);
                it.putExtra("message4", msg4);
                it.putExtra("message5", msg5);
                it.putExtra("message6", msg6);
                it.putExtra("message7", msg7);
                it.putExtra("message8", msg8);

                startActivity(it);

                Intent i = new Intent(activity_recipient_register.this,WebActivity.class);
                i.putExtra("message6",msg6);
                startActivity(i);
            }
        });
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
    }




}
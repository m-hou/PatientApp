package com.example.michael.patientapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class PatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");

        TextView userName = (TextView)findViewById(R.id.patient_name);
        userName.setText(title);
    }

}

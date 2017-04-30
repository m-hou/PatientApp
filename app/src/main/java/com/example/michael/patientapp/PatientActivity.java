package com.example.michael.patientapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.michael.patientapp.Util.PatientJsonReadWrite;

import java.io.InputStream;

public class PatientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String id = bundle.getString("id");

        TextView nameView = (TextView)findViewById(R.id.patient_name);
        nameView.setText(name);
        TextView idView = (TextView)findViewById(R.id.patient_id);
        idView.setText(id);

        InputStream is = getResources().openRawResource(R.raw.patients);
        PatientJsonReadWrite.Read(is);
        try {
            is.close();
        } catch (Exception e) {

        }

    }

}

package com.example.michael.patientapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.michael.patientapp.Model.Patient;
import com.example.michael.patientapp.Util.PatientJsonReadWrite;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Patient> patients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream is = getResources().openRawResource(R.raw.patients);
        patients = PatientJsonReadWrite.Read(is);

        ArrayAdapter adapter = new PatientAdapter(this, patients);
        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent intent = new Intent(MainActivity.this, PatientActivity.class);
                intent.putExtra("id", patients.get(position).id);
                intent.putExtra("name", patients.get(position).name);
                startActivity(intent);
            }
        });
    }
}

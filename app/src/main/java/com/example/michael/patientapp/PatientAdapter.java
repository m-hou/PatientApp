package com.example.michael.patientapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.michael.patientapp.Model.Patient;

import java.util.ArrayList;

/**
 * Created by Michael on 2017-04-29.
 */

public class PatientAdapter extends ArrayAdapter<Patient> {
    public PatientAdapter(Context context, ArrayList<Patient> patients) {
        super(context, 0, patients);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Patient patient = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_patient, parent, false);
        }
        // Lookup view for data population
        TextView title = (TextView) convertView.findViewById(R.id.title);
        // Populate the data into the template view using the data object
        title.setText(patient.name);
        // Return the completed view to render on screen
        return convertView;
    }
}

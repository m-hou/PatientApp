package com.example.michael.patientapp.Util;

import com.example.michael.patientapp.Model.Patient;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Michael on 2017-04-29.
 */

public class PatientJsonReadWrite {

    private static final String LOGTAG = PatientJsonReadWrite.class.getSimpleName();
    private static Gson gson = new Gson();

    public static ArrayList<Patient> Read(InputStream is) {

        Patient[] patients = new Patient[0];
        try {
            Reader reader = new InputStreamReader(is, "UTF-8");
            patients = gson.fromJson(reader, Patient[].class);
        } catch (Exception e) {

        }
        ArrayList<Patient> patientList = new ArrayList<Patient>(Arrays.asList(patients));
        return patientList;
    }
}

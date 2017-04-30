package com.example.michael.patientapp.Util;

import android.support.annotation.NonNull;

import com.example.michael.patientapp.Model.Patient;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.michael.patientapp.R.raw.patients;

/**
 * Created by Michael on 2017-04-29.
 */

public class PatientJsonReadWrite {

    private static final String LOGTAG = PatientJsonReadWrite.class.getSimpleName();
    private static Gson gson = new Gson();

    public static ArrayList<Patient> Read(InputStream is) {

        ArrayList<Patient> patientList;
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://159.203.62.239:3000")
                    .build();

            PatientService patientService = retrofit.create(PatientService.class);
            Call<ArrayList<Patient>> call = patientService.getPatients();
            patientList = call.execute().body();
        } catch (Exception e) {
            patientList = patientsFromMockJson(is);
        }
        return patientList;
    }

    private static ArrayList<Patient> patientsFromMockJson(InputStream is) {
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

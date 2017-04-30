package com.example.michael.patientapp.Util;

import com.example.michael.patientapp.Model.Patient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Michael on 2017-04-29.
 */

public interface PatientService {
    // Synchronous declaration
    @GET("/patients.json")
    Call<ArrayList<Patient>> getPatients();

    // Asynchronous declaration
    @GET("/patients.json")
    void getPatients(Callback<ArrayList<Patient>> callback);
}

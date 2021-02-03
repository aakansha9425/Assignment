package com.example.miskaaassignment;

import com.example.miskaaassignment.modelClass.CountryData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("rest/v2/region/asia")
    Call<List<CountryData>> getCountryJSON();
}

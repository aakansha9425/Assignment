package com.example.miskaaassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.miskaaassignment.Adapter.CountryDataAdapter;
import com.example.miskaaassignment.modelClass.CountryData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ArrayList<CountryData> countryData=new ArrayList<>();
    private CountryDataAdapter countryDataAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getCountryResponse();
    }

    private void getCountryResponse() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface requestInterface=retrofit.create(RequestInterface.class);
        Call<List<CountryData>> call=requestInterface.getCountryJSON();
        call.enqueue(new Callback<List<CountryData>>() {
            @Override
            public void onResponse(Call<List<CountryData>> call, Response<List<CountryData>> response) {
                countryData= new ArrayList<>(response.body());
                countryDataAdapter=new CountryDataAdapter(MainActivity.this,countryData);
                recyclerView.setAdapter(countryDataAdapter);
                //Toast.makeText(MainActivity.this, "Success!!!"+countryData.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<CountryData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failure!!!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
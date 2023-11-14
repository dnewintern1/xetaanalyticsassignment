package com.base.xetaanalyticsassignment;


import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://52.25.229.242:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getposts();

        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "No response", Toast.LENGTH_SHORT).show();
                    return;
                }

                ApiResponse apiResponse = response.body();

                if (apiResponse != null && apiResponse.isSuccess()) {
                    Data data = apiResponse.getData();
                    if (data != null) {
                        Section1 section1 = data.getSection1();
                        if (section1 != null) {
                            String planName = section1.getPlanName();
                            String progress = section1.getProgress();
                            // Do something with planName and progress
                        }
                        // Similarly for other sections
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Request failed", Toast.LENGTH_SHORT).show();
            }
        });









    }
}



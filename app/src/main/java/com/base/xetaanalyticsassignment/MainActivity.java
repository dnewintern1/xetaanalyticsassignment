package com.base.xetaanalyticsassignment;
import android.os.Bundle;


import android.util.Log;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText Searchbox;
    private Switch switch1;

    private TextView textView6,accuracyID,WorkoutDuration,RepsId,calories_burned,TONEDtext,level,
    txtToned2,level1,dummybicep,biceplevel,dummychest,chesstlevel;
    private SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekbar = findViewById(R.id.seekbar);

        switch1 = findViewById(R.id.switch1);

        Searchbox = findViewById(R.id.Searchbox);
        textView6 = findViewById(R.id.textView6);
        accuracyID = findViewById(R.id.accuracyID);
       WorkoutDuration = findViewById(R.id.WorkoutDuration);
        RepsId = findViewById(R.id.RepsId);
        calories_burned = findViewById(R.id.calories_burned);
        TONEDtext = findViewById(R.id.TONEDtext);
        level = findViewById(R.id.level);
        level1 = findViewById(R.id.level1);
        txtToned2 = findViewById(R.id.txtToned2);
        dummybicep = findViewById(R.id.dummybicep);
        biceplevel = findViewById(R.id.biceplevel);
        dummychest = findViewById(R.id.dummychest);
        chesstlevel = findViewById(R.id.chesstlevel);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://52.25.229.242:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<Post> call = jsonPlaceHolderApi.getposts();


        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "No response"+response.code(), Toast.LENGTH_SHORT).show();
                    Log.i("theError", response.code()+"");
                    return;
                }


               Post posts = response.body();

                Post.Data data = posts.getData();
                Post.Section1 section1 = data.getSection_1();

                String planName = section1.getPlan_name();
                String progress = section1.getProgress();
                int intValue = Integer.parseInt(progress.replaceAll("[^0-9]", ""));

               textView6.setText(planName);
                seekbar.setProgress(intValue);

                Post.Section2 section2 = data.getSection_2();


                accuracyID.setText(section2.getAccuracy());
                WorkoutDuration.setText(section2.getWorkout_duration());
                RepsId.setText(section2.getReps());
                calories_burned.setText(section2.getCalories_burned());

                Post.Section3 s3 = data.getSection_3();

                TONEDtext.setText(s3.getPlan_1().getPlan_name());
                level.setText(s3.getPlan_1().getDifficulty());

                txtToned2.setText(s3.getPlan_2().getPlan_name());
                level1.setText(s3.getPlan_2().getDifficulty());

                Post.Section4 sf= data.getSection_4();
                dummybicep.setText(sf.getCategory_1().getCategory_name());
                biceplevel.setText(sf.getCategory_1().getNo_of_exercises());
                dummychest.setText(sf.getCategory_2().getCategory_name());
                chesstlevel.setText(sf.getCategory_2().getNo_of_exercises());


            }


            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                Searchbox.setText(t+"");

            }




        });


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled, enable dark mode
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    // The toggle is disabled, disable dark mode
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });





    }
}



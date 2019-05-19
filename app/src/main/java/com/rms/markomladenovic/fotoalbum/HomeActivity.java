package com.rms.markomladenovic.fotoalbum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {

    // ArrayList for image names

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Create a list of image names from string resource
        String[] imageNames = getResources().getStringArray(R.array.images_array);
        ArrayList<String> arrayListImageNames = new ArrayList<>(Arrays.asList(imageNames).subList(0, imageNames.length));

        // Create a list of image resource ids using image names
        ArrayList<Integer> imageIds = new ArrayList<Integer>();
        for (int i = 0; i < imageNames.length; i++)
            imageIds.add(i, getResources().getIdentifier(imageNames[i], "drawable", getPackageName()));


        // get the reference of RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        // set a GridLayoutManager with 2 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(arrayListImageNames, imageIds);
        // set the Adapter to RecyclerView
        recyclerView.setAdapter(customAdapter);

        Button buttonToTravel = findViewById(R.id.buttonHome);
        buttonToTravel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent homeToTravel = new Intent(HomeActivity.this, TravelActivity.class);
                startActivity(homeToTravel);
            }
        });
    }
}

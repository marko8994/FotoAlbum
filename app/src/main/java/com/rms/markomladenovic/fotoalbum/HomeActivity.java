package com.rms.markomladenovic.fotoalbum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {
    // ArrayList for person names
    ArrayList names = new ArrayList<>(Arrays.asList("image_001", "Image 2", "Image 3", "Image 4", "Image 5", "Image 4", "Image 4","Person 8", "Person 9", "Person 10", "Person 11", "Person 12", "Person 13", "Person 14", "image_015",
            "image_015", "image_015", "image_015", "image_015", "image_015", "image_015", "image_015", "image_015", "image_015", "image_015", "image_015"));
    ArrayList images = new ArrayList<>(Arrays.asList(R.drawable.image_001, R.drawable.image_002, R.drawable.image_003, R.drawable.image_004, R.drawable.image_005, R.drawable.image_006, R.drawable.image_007,R.drawable.image_008, R.drawable.image_009, R.drawable.image_010,
            R.drawable.image_011, R.drawable.image_012, R.drawable.image_012, R.drawable.image_013, R.drawable.image_014, R.drawable.image_015, R.drawable.image_016, R.drawable.image_017, R.drawable.image_018,
            R.drawable.image_019, R.drawable.image_020, R.drawable.image_021, R.drawable.image_022, R.drawable.image_023, R.drawable.image_024, R.drawable.image_025));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // get the reference of RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(HomeActivity.this, names, images);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }
}

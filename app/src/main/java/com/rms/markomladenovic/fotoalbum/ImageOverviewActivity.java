//package com.rms.markomladenovic.fotoalbum;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.ImageView;
//
//import static com.rms.markomladenovic.fotoalbum.HomeActivity.bundle_extra_image;
//
//public class ImageOverviewActivity extends AppCompatActivity {
//    ImageView selectedImage;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_image_overview);
//        selectedImage = findViewById(R.id.selectedImage); // init a ImageView
//        Intent intent = getIntent(); // get Intent which was set from adapter of Previous Activity
//        selectedImage.setImageResource(intent.getIntExtra(bundle_extra_image, 0)); // get image from Intent and set it in ImageView
//    }
//}
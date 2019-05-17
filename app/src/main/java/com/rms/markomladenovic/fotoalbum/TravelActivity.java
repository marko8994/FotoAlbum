package com.rms.markomladenovic.fotoalbum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class TravelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        LinearLayout linearLayoutTravel = (LinearLayout) findViewById(R.id.linearLayoutTravel);
        linearLayoutTravel.setShowDividers(LinearLayout.SHOW_DIVIDER_BEGINNING |
                LinearLayout.SHOW_DIVIDER_MIDDLE);

        Button buttonToTravel = findViewById(R.id.buttonSave);
        buttonToTravel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent toOverview = new Intent(TravelActivity.this, OverviewActivity.class);
                startActivity(toOverview);
            }
        });

        ImageButton buttonToHome = findViewById(R.id.buttonBack);
        buttonToHome.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }
}

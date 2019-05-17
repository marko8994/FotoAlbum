package com.rms.markomladenovic.fotoalbum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class OverviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        LinearLayout linearLayoutOverview = (LinearLayout) findViewById(R.id.linearLayoutOverview);
        linearLayoutOverview.setShowDividers(LinearLayout.SHOW_DIVIDER_BEGINNING |
                LinearLayout.SHOW_DIVIDER_MIDDLE |
                LinearLayout.SHOW_DIVIDER_END);

        ImageButton buttonToHome = (ImageButton) findViewById(R.id.buttonToHome);
        buttonToHome.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent overviewToHome = new Intent(OverviewActivity.this, HomeActivity.class);
                startActivity(overviewToHome);
            }
        });



    }
}

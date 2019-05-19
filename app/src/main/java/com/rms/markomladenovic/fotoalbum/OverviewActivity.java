package com.rms.markomladenovic.fotoalbum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.rms.markomladenovic.fotoalbum.TravelActivity.bundle_extra;

public class OverviewActivity extends AppCompatActivity {

    private TextView textViewGeneralData;
    private TextView textViewTimeData;
    private TextView textViewFriendsData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        // Initiliaze screen components
        textViewGeneralData = findViewById(R.id.textViewGeneralData);
        textViewTimeData = findViewById(R.id.textViewTimeData);
        textViewFriendsData = findViewById(R.id.textViewFriendsData);

        fillContent();

        // Set onCLickListener on button to home
        ImageButton buttonToHome = findViewById(R.id.buttonToHome);
        buttonToHome.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent overviewToHome = new Intent(OverviewActivity.this, HomeActivity.class);
                startActivity(overviewToHome);
            }
        });
        setupComponents();
    }

    private void setupComponents() {
        // Setup of dividers between linear layout components
        LinearLayout linearLayoutOverview = findViewById(R.id.linearLayoutOverview);
        linearLayoutOverview.setShowDividers(LinearLayout.SHOW_DIVIDER_BEGINNING |
                LinearLayout.SHOW_DIVIDER_MIDDLE |
                LinearLayout.SHOW_DIVIDER_END);
    }

    private void fillContent() {
        Travel travel = getIntent().getExtras().getParcelable(bundle_extra);

        if (travel!=null) {
            if ((travel.getCountry().matches("")) || (travel.getPlace().matches(""))) {
                textViewGeneralData.setText(getString(R.string.text_view_general_data_invalid_entry));
            } else {
                String generalData = (getString(R.string.text_view_general_data_prefix)) + " " +
                        travel.getPlace() + ", " +
                        travel.getCountry() + ", " +
                        travel.getContinent();
                textViewGeneralData.setText(generalData);
            }

            String timeData = getString(R.string.text_view_time_data_prefix) + " " +
                    travel.getDateStart() + " " + getString(R.string.text_view_time_data_inner_sufix) +
                    " " + travel.getDateEnd();
            textViewTimeData.setText(timeData);

            StringBuilder friendsData = new StringBuilder(getString(R.string.text_view_friends_sufix));
            friendsData.append(" ").append(travel.getTravelType()).append(" ");
            if (!(travel.getFriends().matches(""))) {
                friendsData.append(getString((R.string.text_view_friends_inner_sufix))).append(": ");
                friendsData.append(travel.getFriends());
            } else {
                friendsData.append(getString(R.string.text_view_friend_sufix));
            }
            textViewFriendsData.setText(friendsData);
        }
    }
}

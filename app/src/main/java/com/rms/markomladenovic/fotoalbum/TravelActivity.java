package com.rms.markomladenovic.fotoalbum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class TravelActivity extends AppCompatActivity {

    public static final String bundle_extra = "com.rms.markomladenovic";

    private Spinner spinnerContinent;
    private EditText editTextCountry;
    private EditText editTextPlace;
    private DatePicker datePickerStartDate;
    private DatePicker datePickerEndDate;
    private Spinner spinnerTravelType;
    private EditText editTextFriends;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        setupComponents();

        // Initialization of commponents
        ImageButton imageButtonBack = findViewById(R.id.buttonBack);
        spinnerContinent = findViewById(R.id.spinnerContinent);
        editTextCountry = findViewById(R.id.editTextCountry);
        editTextPlace = findViewById(R.id.editTextPlace);
        datePickerStartDate = findViewById(R.id.datePickerTravelStart);
        datePickerEndDate = findViewById(R.id.datePickerTravelEnd);
        spinnerTravelType = findViewById(R.id.spinnerTravelType);
        editTextFriends = findViewById(R.id.editTextFriends);
        Button buttonSave = findViewById(R.id.buttonSave);

        // OnClick listeners
        buttonSave.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Bundle extra = new Bundle();
                extra.putParcelable(bundle_extra, createTravel());
                Intent toOverview = new Intent(TravelActivity.this, OverviewActivity.class);
                toOverview.putExtras(extra);
                startActivity(toOverview);
            }
        });

        imageButtonBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }

    public void setupComponents(){
        LinearLayout linearLayoutTravel = findViewById(R.id.linearLayoutTravel);
        Spinner spinnerContinent = findViewById(R.id.spinnerContinent);
        Spinner spinnerTravelType = findViewById(R.id.spinnerTravelType);

        // Setup of dividers between linear layout components
        linearLayoutTravel.setShowDividers(LinearLayout.SHOW_DIVIDER_BEGINNING |
                LinearLayout.SHOW_DIVIDER_MIDDLE);

        // Filling spinners with content
        String[] continents = getResources().getStringArray(R.array.continent_array);
        ArrayList<String> continentArray = new ArrayList<>(Arrays.asList(continents).subList(0, continents.length));
        String[] travelTypes = getResources().getStringArray(R.array.travel_type_array);
        ArrayList<String> travelTypeArray = new ArrayList<>(Arrays.asList(travelTypes).subList(0, travelTypes.length));
        ArrayAdapter<String> adapterContitent = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, continentArray);
        ArrayAdapter<String> adapterTravelType = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, travelTypeArray);
        spinnerContinent.setAdapter(adapterContitent);
        spinnerTravelType.setAdapter(adapterTravelType);
    }

    private Travel createTravel() {
        Travel travel = new Travel();
        String dateStart = datePickerStartDate.getDayOfMonth() + "." +
                datePickerStartDate.getMonth() + "." +
                datePickerStartDate.getYear() + ".";
        String dateEnd = datePickerEndDate.getDayOfMonth() + "." +
                datePickerEndDate.getMonth() + "." +
                datePickerEndDate.getYear() + ".";
        travel.setContinent(spinnerContinent.getSelectedItem().toString());
        travel.setCountry(editTextCountry.getText().toString());
        travel.setPlace(editTextPlace.getText().toString());
        travel.setDateStart(dateStart);
        travel.setDateEnd(dateEnd);
        travel.setTravelType(spinnerTravelType.getSelectedItem().toString());
        travel.setFriends(editTextFriends.getText().toString());
        return travel;
    }
}

package com.example.pandemictracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private int positionCountry;
    TextView tvCountry,tvCases,tvTodayCases,tvDeaths,tvTodayDeaths,tvRecovered,tvActive,tvCritical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);

        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvDeaths = findViewById(R.id.tvDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvActive = findViewById(R.id.tvActive);
        tvCritical = findViewById(R.id.tvCritical);

        tvCountry.setText(affectedCountries.countryModelList.get(positionCountry).getCountry());
        tvCases.setText(affectedCountries.countryModelList.get(positionCountry).getCases());
        tvTodayCases.setText(affectedCountries.countryModelList.get(positionCountry).getTodayCases());
        tvDeaths.setText(affectedCountries.countryModelList.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(affectedCountries.countryModelList.get(positionCountry).getTodayDeaths());
        tvRecovered.setText(affectedCountries.countryModelList.get(positionCountry).getRecovered());
        tvActive.setText(affectedCountries.countryModelList.get(positionCountry).getActive());
        tvCritical.setText(affectedCountries.countryModelList.get(positionCountry).getCritical());
    }
}

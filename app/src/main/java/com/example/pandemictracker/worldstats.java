package com.example.pandemictracker;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class worldstats extends AppCompatActivity {
    TextView infected,recovered,death;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worldstats);

        infected = (TextView) findViewById(R.id.infecteddata);
        recovered = (TextView) findViewById(R.id.recovereddata);
        death = (TextView) findViewById(R.id.deathdata);
        pieChart = (PieChart)findViewById(R.id.piechart);
        if(haveNetwork())
        {
            //proceed with my app functionality
        }
        else if(!haveNetwork())
        {
            Toast.makeText(worldstats.this , "Network unavailable!Try again" , Toast.LENGTH_SHORT).show();
        }

        fetchData();

    }
    private boolean haveNetwork()
    {
        boolean have_WIFI = false;
        boolean have_MobileData = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo[] networkInfos = connectivityManager.getAllNetworkInfo();

        for (NetworkInfo info:networkInfos)
        {
            if(info.getTypeName().equalsIgnoreCase("WIFI"))
                if(info.isConnected())
                    have_WIFI = true;
            if(info.getTypeName().equalsIgnoreCase("Mobile"))
                if(info.isConnected())
                    have_MobileData = true;
        }
        return have_MobileData||have_WIFI;
    }

    private void fetchData() {
        String url = "https://corona.lmao.ninja/v2/all/";

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            infected.setText(jsonObject.getString("cases"));
                            recovered.setText(jsonObject.getString("recovered"));
                            death.setText(jsonObject.getString("deaths"));

                            pieChart.addPieSlice(new PieModel("Cases",Integer.parseInt(infected.getText().toString()), Color.parseColor("#FF6200EE")));
                            pieChart.addPieSlice(new PieModel("Recovered",Integer.parseInt(recovered.getText().toString()), Color.parseColor("#FFC8BBDA")));
                            pieChart.addPieSlice(new PieModel("Deaths",Integer.parseInt(death.getText().toString()), Color.parseColor("#FF03DAC5")));
                            pieChart.startAnimation();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(worldstats.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void goTrackCountries(View view) {
        startActivity(new Intent(getApplicationContext(),affectedCountries.class));
    }
}

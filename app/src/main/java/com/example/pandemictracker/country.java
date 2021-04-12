package com.example.pandemictracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class country extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
    }
    public class Country {
        String name = null;

        public Country(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}

package com.example.pandemictracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class symptoms extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[],s2[];
    int images[] = {R.drawable.fever1 , R.drawable.drycough , R.drawable.tiredness , R.drawable.shortness , R.drawable.chills , R.drawable.bodyache , R.drawable.nausea , R.drawable.diarrhea};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.Symptoms);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(this,s1,s2,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}

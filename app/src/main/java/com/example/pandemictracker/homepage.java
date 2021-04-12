package com.example.pandemictracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import static com.example.pandemictracker.App.CHANNEL_1_ID;

public class homepage extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;

    private LinearLayout disease,lockdown,profile,symptoms,testyourself,precautions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        disease = findViewById(R.id.disease);
        lockdown = findViewById(R.id.lockdown);
        profile = findViewById(R.id.profile);
        symptoms = findViewById(R.id.symptoms);
        testyourself = findViewById(R.id.testyourself);
        precautions = findViewById(R.id.precautions);
        testyourself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this,testYourself.class);
                startActivity(intent);
            }
        });
        lockdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this,countdownPage.class);
                startActivity(intent);
            }
        });
        disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this,worldstats.class);
                startActivity(intent);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this,profile.class);
                startActivity(intent);
            }
        });
        precautions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this,precautionsPage.class);
                startActivity(intent);
            }
        });
        symptoms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homepage.this,symptoms.class);
                startActivity(intent);
            }
        });

        notificationManager = NotificationManagerCompat.from(this);
    }

    public void sendOnChannel1(View v){
        String title = "PANDEMIC TRACKER";
        String message = "STAY HOME. STAY SAFE";

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_local_hospital)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManager.notify(1,notification);
    }
}

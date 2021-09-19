package com.skull1.hackathon1.Front;



import android.content.Intent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.skull1.hackathon1.R;

public class ServiceActivity extends AppCompatActivity {

    public static TextView tvShakeService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Intent intent = new Intent(this, ShakeService.class);
        //Start Service
        startService(intent);

        tvShakeService = findViewById(R.id.tvShakeService);

    }
}
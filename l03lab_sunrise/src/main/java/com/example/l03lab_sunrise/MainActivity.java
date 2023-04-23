package com.example.l03lab_sunrise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView sunlmageView = (ImageView) findViewById(R.id.sun);
        android.view.animation.Animation sunRiseAnimation = AnimationUtils.loadAnimation(this, R.anim.sun_rise);
        sunlmageView.startAnimation(sunRiseAnimation);
    }
}
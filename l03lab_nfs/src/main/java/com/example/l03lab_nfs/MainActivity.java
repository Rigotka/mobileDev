package com.example.l03lab_nfs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewFlipper flippyFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        Animation animFlipIn = AnimationUtils.loadAnimation(this, R.anim.flip_in);
        Animation animFlipOut = AnimationUtils.loadAnimation(this, R.anim.flip_out);
        flippyFlipper.setInAnimation(animFlipIn);
        flippyFlipper.setOutAnimation(animFlipOut);
        flippyFlipper.setFlipInterval(3000);
        flippyFlipper.showNext();
    }
}
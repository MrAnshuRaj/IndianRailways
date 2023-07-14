package com.anshu.indianrailways;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class SeatAvailability extends AppCompatActivity {
TextView ac,sleeper,secondSitting;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_availability);
        ac=findViewById(R.id.ac);
        sleeper=findViewById(R.id.sleeper);
        secondSitting=findViewById(R.id.secondsitting);

        ac.setText("AC : "+MainActivity.max1);
        sleeper.setText("Sleeper : "+MainActivity.max2);
        secondSitting.setText("2S : "+MainActivity.max3);
    }
}
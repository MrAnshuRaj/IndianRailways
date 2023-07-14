package com.anshu.indianrailways;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static  public  int max1=75;//variable to store seats available in AC class
    public  static  int max2=150;//variable to store seats available in Sleeper class
    static  int max3=150;//variable store seats available in 2S class

    //Constructor to initialise the arrays and variables
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void fareCalculator(View v)
    {
       startActivity(new Intent(this,fareCalculator.class));
    }
    public void seatAvail(View v)
    {
        startActivity(new Intent(this,SeatAvailability.class));
    }
    public void bookTicket(View v)
    {
        startActivity(new Intent(this,bookTicket.class));
    }

}
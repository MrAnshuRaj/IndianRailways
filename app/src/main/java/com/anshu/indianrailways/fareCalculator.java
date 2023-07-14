package com.anshu.indianrailways;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class fareCalculator extends AppCompatActivity {
TextView fare,distanceOut;
EditText source,destination,travelClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fare_calculator);
        fare=findViewById(R.id.fare);
        distanceOut=findViewById(R.id.distance);
        source=findViewById(R.id.source);
        destination=findViewById(R.id.destination);
        travelClass=findViewById(R.id.travelClass);

    }
    @SuppressLint("SetTextI18n")
    public void findFare(View v)
    {
        int cloT=0;;
        String sstn=source.getText().toString();
        String dstn=destination.getText().toString();
        String ctr= travelClass.getText().toString();
        if(ctr.equalsIgnoreCase("AC"))
            cloT=1;
        else if(ctr.equalsIgnoreCase("Sleeper"))
            cloT=2;
        else if(ctr.equalsIgnoreCase("2S")|| ctr.equalsIgnoreCase("Second Sitting"))
            cloT=3;
        int sourceD=0,dst=0,ind1=0,ind2=0,d=0,pt1=0,pr,tot;
        //String ss,ds;
        String[] station ={"PATNA","BAKHTIVARPUR","BARH","MOKAMEH","HATHIDAH","LUCKEESARAI","JAMUI","JHAJHA","JASIDIH",
                "MADHUPUR","JAMTARA","CHITTARANJAN","ASANSOL","DURGAPUR","HOWRAH"};//array for station name
        int[] distance ={0,46,64,89,97,122,151,177,221,250,292,306,332,374,532};//array for distances
        for(int j=0;j<station.length;j++)//linear search mechanism for searching the source ad destination stations in the array
        {
            if(sstn.equalsIgnoreCase(station[j]))
                ind1=j;
        }
        for(int k=0;k<station.length;k++)
        {
            if(dstn.equalsIgnoreCase(station[k]))
                ind2=k;
        }
        if(sstn.equalsIgnoreCase("PATNA")) //this is for avoiding a logical error if user enters patna as source station
        {
            pt1++;//incrementing pt1 if patna has been found
        }

        if((pt1==0 && ind1==0) || ind2==0) {
            Toast.makeText(this,"Wrong station name! Please try again!",Toast.LENGTH_LONG).show();
        }

        if(ind1>=0 && ind2>0)
        {
            sourceD=distance[ind1];
            dst=distance[ind2];
            d=dst-sourceD;
            distanceOut.setText("Distance = "+d);

        }
        tot=0;
        if(cloT==1) //checking whether class of travel is AC
        {
            pr=d*20;//calculating fare @20/km
            tot=pr;//calculating total fare=(no of tickets*cost per ticket)
        }
        else if(cloT==2) //Checking whether class of travel is Sleeper
        {
            pr=d*15;//calculating fare @15/km
            tot=pr;
        }
        else if(cloT==3) //checking whether class of travel is 2S
        {
            pr=d*10;
            tot=pr;
        }
        fare.setText("Fare = "+tot);
    }

    public void Refresh(View V)
    {
        source.setText("");
        destination.setText("");
        travelClass.setText("");
        fare.setText("");
        distanceOut.setText("");
    }
}
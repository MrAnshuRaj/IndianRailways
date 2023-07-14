package com.anshu.indianrailways;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class showTicket extends AppCompatActivity {
private TextView name,phoneNo,dateTravel,age,distance,source,destination,travelClass,fare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_ticket);
        name=findViewById(R.id.nameShowTkt);
        phoneNo=findViewById(R.id.phoneNoShowTkt);
        dateTravel=findViewById(R.id.dateOfTravelShowTkt);
        age=findViewById(R.id.ageShowTkt);
        distance=findViewById(R.id.distanceShowTk);
        source=findViewById(R.id.sourceShowTk);
        destination=findViewById(R.id.destinationShowTk);
        travelClass=findViewById(R.id.travelClassShowTk);
        fare=findViewById(R.id.fareShowTk);
       // try {
            initialize();
        //}
      //  catch (Exception e)
       // {
        //    Toast.makeText(this,"Some error occurred",Toast.LENGTH_LONG).show();
//
       // }


    }
    public void initialize()
    {
        Intent intent=getIntent();
        String[] str =intent.getStringArrayExtra("ticket");

        name.setText(str[0]);
        phoneNo.setText(str[4]);
        dateTravel.setText(str[3]);
        age.setText(str[1]);


        int dist=intent.getIntExtra("d",0);
        distance.setText(dist+"");
        source.setText(str[5]);
        destination.setText(str[6]);
        String ticketClass="";
        if(str[2].equals("1"))
            ticketClass="AC";
        else if(str[2].equals("2"))
            ticketClass="Sleeper";
        else
            ticketClass="2S";
        travelClass.setText(ticketClass);
        fare.setText(str[7]);
    }

}
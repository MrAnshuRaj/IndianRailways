package com.anshu.indianrailways;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class bookTicket extends AppCompatActivity {
    int d = 0;

    int[] pno = new int[375];//array for PNR number
    String[] name =new String[375];//array for storing names of each passenger
    String[] phone =new String[375];//array for storing passengers phone numbers
    String[] age =new String[375];//array for storing passengers age
    int[] cl =new int[375];//array for storing passengers class of travel
    String[] date =new String[375];//array to store date of travel for the passengers
    String[] source =new String[375];//array to store source stations for each passenger
    String[] destination =new String[375];//array to store destination stations for each passenger
    int[] Price =new int[375];//array to store the fare for each passenger
    int pCount=0;//variable for index value of the arrays
    int pNum =1;
    String[] ticket=new String[9];
    int ct=0;//for class of travel
    String ss;//variable for source station
    String ds;//variable for destination station

    EditText nameE, ageE, travelDate, phoneNo, sourceE, destinationE, classOfTravel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ticket);
        nameE = findViewById(R.id.name);
        ageE = findViewById(R.id.age);
        travelDate = findViewById(R.id.travelDate);
        phoneNo = findViewById(R.id.phoneNo);
        sourceE = findViewById(R.id.sourceTkt);
        destinationE = findViewById(R.id.destinationTkt);
        classOfTravel = findViewById(R.id.classTravel);


    }
    public int Fare(String sstn,String dstn,int cloT)
    {

        int sourceD=0,dst=0,ind1=0,ind2=0,pt1=0,tot=0;
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

        if(ind2>0)
        {
            sourceD=distance[ind1];
            dst=distance[ind2];
            d=dst-sourceD;
        }
        //calculating fare @20/km
        if(cloT==1) //checking whether class of travel is AC
        {
            tot = d * 20;//calculating total fare=(no of tickets*cost per ticket)
        } else if(cloT==2) //Checking whether class of travel is Sleeper
        {
            //calculating fare @15/km
            tot=d*15;
        }
        else if(cloT==3) //checking whether class of travel is 2S
            tot = d * 10;
       return tot;
    }
    public void ShowTicket(View v)
    {
        Intent intent=new Intent(this,showTicket.class);
        intent.putExtra("d",this.d);
        intent.putExtra("ticket",ticket);
        startActivity(intent);
    }

    public void bookTicket(View view) {
        int tno = 1;//storing no of tickets user wants to book
        if (tno <= (MainActivity.max1 + MainActivity.max2 + MainActivity.max3)) {
            pno[pCount] = pNum;//assigning passengers no to the PNR no array
            String ctrl = classOfTravel.getText().toString();
            if (ctrl.equalsIgnoreCase("AC")) ct = 1;
            else if (ctrl.equalsIgnoreCase("Sleeper")) ct = 2;
            else if (ctrl.equalsIgnoreCase("2S") || ctrl.equalsIgnoreCase("Second Sitting")) ct = 3;
            //storing class of travel in variable ct
            if (ct == 1 && MainActivity.max1 >= 1) //if class of travel is AC and tickets are available in the AC class
            {
                MainActivity.max1--;//seats are reduced in AC class
            } else if (ct == 2 && MainActivity.max2 >= 1) //similar as above it's for sleeper class
            {
                MainActivity.max2--;
            } else if (ct == 3 && MainActivity.max3 >= 1) // similar as above it's for 2S class
            {
                MainActivity.max3--;
            }
                ticket[0]= name[pCount] = nameE.getText().toString(); //storing name of passenger in name[] array
                ticket[1]= age[pCount] = ageE.getText().toString();//storing passenger's age in age[] array
                ticket[2]= String.valueOf(cl[pCount] = ct);/*storing class of travel in cl[] array.Written inside so that class array is assigned data when
                    seats are available*/
                ticket[3]= date[pCount] = travelDate.getText().toString();//storing date of travel of passenger in date[] array
                ticket[4]= phone[pCount] = phoneNo.getText().toString();//storing phone number of passenger in phone[] array
                ticket[5]= source[pCount] = sourceE.getText().toString().toUpperCase();//storing source station in source[] array input by user
                ss = source[pCount];//assigning source station to ss named string which is used as parameter for Fare() method
                ticket[6]= destination[pCount] = destinationE.getText().toString().toUpperCase();//storing destination station in destination[] array
                ds = destination[pCount];//assigning destination station to ds named string
                ticket[7]= String.valueOf(Price[pCount] = Fare(ss, ds, ct));//calling Fare() method and storing fare calculated in Price[] array
                Toast.makeText(this,"Congratulations!! Ticket Booked Successfully",Toast.LENGTH_LONG).show();
                pCount++;//incrementing for next passenger
                pNum++;
        }
    }
}
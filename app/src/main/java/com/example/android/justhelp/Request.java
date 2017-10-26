package com.example.android.justhelp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;


public class Request extends AppCompatActivity {

    int quantityFood;
    int quantityWater;
    int quantityShelter;
    int quantityEmergency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
    }




//LINKING JAVA COMMANDS TO XML ID

    //    Displays food quantity with the 'displayFood' command
    private void displayFood(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.foodQuantity);
        priceTextView.setText("" + number);
    }

    //    Displays water quantity with the 'displayWater' command
    private void displayWater(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.waterQuantity);
        priceTextView.setText("" + number);
    }

    //    Displays shelter quantity with the 'displayShelter' command
    private void displayShelter(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.shelterQuantity);
        priceTextView.setText("" + number);
    }

    //    Displays Emergency quantity with the 'displayEmergency' command
    private void displayEmergency(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.emergencyQuantity);
        priceTextView.setText("" + number);
    }






    //TO UPDATE FOOD QUANTITY
    public void incrementFood(View view){
        quantityFood = quantityFood +1;
        displayFood(quantityFood);
    }
    public void decrementFood(View view){
        if(quantityFood>0)
        quantityFood = quantityFood -1;
        displayFood(quantityFood);
    }


 //TO UPDATE WATER QUANTITY
    public void incrementWater(View view){
        quantityWater = quantityWater +1;
        displayWater(quantityWater);
    }
    public void decrementWater(View view){
        if(quantityWater>0)
        quantityWater = quantityWater -1;
        displayWater(quantityWater);
    }

//TO UPDATE SHELTER QUANTITY
    public void incrementShelter(View view){
        quantityShelter = quantityShelter +1;
        displayShelter(quantityShelter);
    }
    public void decrementShelter(View view){
        if(quantityShelter>0)
        quantityShelter = quantityShelter -1;
        displayShelter(quantityShelter);
    }

//TO UPDATE EMERGENCY QUANTITY
    public void incrementEmergency(View view){
        quantityEmergency = quantityEmergency +1;
        displayEmergency(quantityEmergency);
    }
    public void decrementEmergency(View view){
        if(quantityEmergency>0)
        quantityEmergency = quantityEmergency -1;
        displayEmergency(quantityEmergency);
    }



//SUBMIT BUTTON
    public void submit (View view){

        //name text field
        EditText nameField = (EditText)findViewById(R.id.name);
        String name = nameField.getText().toString();

        //location text field
        EditText locationField = (EditText)findViewById(R.id.location);
        String location = locationField.getText().toString();



    //creating summary text for email
String summary = "Requestor: " + name;
        summary += "\nRescue Location: " + location;
        summary += "\n Food: " + quantityFood;
        summary += "\n Water: " + quantityWater;
        summary += "\n Shelter: "+ quantityShelter;
        summary += "\n Emergency: "+quantityEmergency;



        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:vickia@uci.edu")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "New Request");
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }



//    BACK BUTTON
    public void btnGoMain(View view){
        this.finish();
    }
}

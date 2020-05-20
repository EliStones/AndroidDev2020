package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //Getting order info from main activity
        //We use key to track message from Main Activity
        Intent myIntent = getIntent();
        String displayMessage = myIntent.getStringExtra(MainActivity.EXTRA_ORDER_KEY);

        //Get textView and setTExt to it
        TextView orderDisplay = findViewById(R.id.text_display_order);
        orderDisplay.setText(displayMessage);
    }

    public void onClickRadioButton(View view) {
        //This method is used for several radio buttons so we use a switch case block
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.same_day:
                if (checked){
                    getString(R.string.same_day_messenger_service);
                }
                break;

            case R.id.next_day:
                if (checked){
                    getString(R.string.next_day_delivery_service);
                }
                break;

            case R.id.pick_up:
                if (checked){
                    getString(R.string.pick_up);
                }

            default:
                //Get popping
                break;
        }

    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}

package com.example.droidcafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String mOrderMessage;
    public static final String EXTRA_ORDER_KEY = "MY KEY FOR ORDER MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, OrderActivity.class);
                myIntent.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        //Switch through the IDs
        switch (item.getItemId()){
            case R.id.order:
                Intent myIntent = new Intent(MainActivity.this, OrderActivity.class);
                myIntent.putExtra(EXTRA_ORDER_KEY, mOrderMessage);
                startActivity(myIntent);
                return true;

            case R.id.call_us:
                //Impement an implicit intent that calls your number
                Uri myUri = Uri.parse("tel: 0727307123");
                Intent myIntent1 = new Intent(Intent.ACTION_DIAL,myUri);
                startActivity(myIntent1);
                return true;

            case R.id.locate_us:
                Uri gMapsUri = Uri.parse("geo:-1.329105,36.801");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gMapsUri);
//                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                return true;

            case R.id.about_us:
                Uri webpage = Uri.parse("https://www.ubereats.com/");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showIceCreamOrder(View view){
        displayToast((String) getText(R.string.ice_cream_order_text));

        //Add order message to forward to intent
        mOrderMessage = getString(R.string.ice_cream_order_text);
        displayToast(mOrderMessage);
    }

    public void showFroyoOrder(View view){
        displayToast((String) getText(R.string.froyo_order_text));

        //Add order message to forward to intent
        mOrderMessage = getString(R.string.froyo_order_text);
        displayToast(mOrderMessage);
    }

    public void showDonutOrder(View view){
        displayToast((String) getText(R.string.donut_order_text));

        //Add order message to forward to intent
        mOrderMessage = getString(R.string.donut_order_text);
        displayToast(mOrderMessage);
    }
}

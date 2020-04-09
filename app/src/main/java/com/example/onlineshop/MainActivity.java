package com.example.onlineshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Product> elements = new LinkedList<Product>();
        elements.add( new Product("Product1", "Description for product 1") );
        elements.add( new Product("Product2", "Description for product 2") );
        elements.add( new Product("Product3", "Description for product 3") );
        elements.add( new Product("Product4", "Description for product 4") );

        ListView myListView = (ListView) findViewById(R.id.my_listview);

        ProductArrayAdapter productArrayAdapter = new ProductArrayAdapter(this, android.R.layout.simple_list_item_1, elements);

        myListView.setAdapter(productArrayAdapter);

        // am pus un listener pentru fiecare item afisez descrierea
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product selectedItem = (Product) parent.getItemAtPosition(position);

                TextView tv = (TextView) findViewById(R.id.my_textview);
                view.findViewById(R.id.my_textview);

                tv.setText("DESCRIPTION IS: " + selectedItem.getName());
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("OnStart");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("OnStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("OnDestroy");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("OnResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("OnPause");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_acasa:
                break;

            case R.id.menu_second_activity:
                Intent secondActivityIntent = new Intent(getApplicationContext(), SecondActivity.class);
                secondActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(secondActivityIntent);
                break;

            case R.id.menu_settings_activity:
                Intent settingsActivity = new Intent(getApplicationContext(), SettingsActivity.class);
                settingsActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(settingsActivity);
                break;

            case R.id.menu_sensor_activity:
                Intent sensorsActivity = new Intent(getApplicationContext(), SensorActivity.class);
                sensorsActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(sensorsActivity);
                break;

            case R.id.menu_gps_activity:
                Intent gpsActivity = new Intent(getApplicationContext(), GpsActivity.class);
                gpsActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(gpsActivity);
                break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }
}

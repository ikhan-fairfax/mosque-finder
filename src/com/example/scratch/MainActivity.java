package com.example.scratch;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Lists.newArrayList;

public class MainActivity extends SherlockActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.find_mosque:
                findMosque();
                return true;

            case R.id.add_mosque:
                return true;

            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    private void findMosque() {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (locationManager != null && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Criteria criteria = new Criteria();
            String provider = locationManager.getBestProvider(criteria, false);
            Location location = locationManager.getLastKnownLocation(provider);
            Toast.makeText(this, "Finding locations near " + location.getLongitude() + ", "+ location.getLatitude() , Toast.LENGTH_SHORT).show();
        }

        GetMosquesTask getMosquesTask = new GetMosquesTask(this);
        getMosquesTask.execute("http://10.1.1.5:8080/examples/mosque.json");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return true;
    }
}

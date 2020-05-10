package com.example.birdsapp.post.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.birdsapp.R;
import com.example.birdsapp.data.BirdsList;
import com.example.birdsapp.data.Species;
import com.example.birdsapp.map.activity.MapActivity;
import com.example.birdsapp.models.Post;
import com.example.birdsapp.post.PostListTool;
import com.example.birdsapp.profile.Profile;
import com.example.birdsapp.tools.NotificationTool;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.Date;
import java.util.List;

import static com.example.birdsapp.map.IGPSActivity.REQUEST_CODE;

public class NewPostActivity extends AppCompatActivity implements View.OnClickListener {
    PostListTool postTool = new PostListTool();
    List<Post> posts;
    Profile profile;
    GeoPoint currentPosition;
    boolean permissionGranted1;
    private LocationManager locationManager;
    private MyLocationNewOverlay mLocationOverlay;
    private TextView textViewPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        textViewPosition=findViewById(R.id.locationAddPost);
        permissionGranted1  = ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED;

        Spinner spinner = (Spinner) findViewById(R.id.species_dropdown);
        spinner.setAdapter(new ArrayAdapter<Species>(this, android.R.layout.simple_spinner_item, Species.values()));
        findViewById(R.id.save_post_button).setOnClickListener(this);
        profile = Profile.load(getSharedPreferences(Profile.SAVE_LINK, Context.MODE_PRIVATE));
        if(permissionGranted1) {
            LocationListener listener = initListener();
            locationManager = (LocationManager) (this.getSystemService(Context.LOCATION_SERVICE));
            locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 5000, 100, listener);
        }
        else{
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantedResults){
        switch(requestCode){
            case REQUEST_CODE:{
                if(grantedResults.length>0 && grantedResults[0]== PackageManager.PERMISSION_GRANTED){
                    Toast toast = Toast.makeText(getApplicationContext(),"location activated",Toast.LENGTH_LONG);
                    toast.show();
                    Intent intentReload = new Intent(getApplicationContext(), NewPostActivity.class);
                    startActivity(intentReload);
                }
                break;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View button) {
        Spinner spinner = (Spinner)findViewById(R.id.species_dropdown);
        DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker1);
        Species species = (Species)spinner.getSelectedItem();
        String description = ((EditText)findViewById(R.id.description_textInput)).getText().toString();
        Date date = new Date();
        if (button.getId() == R.id.save_post_button) {
            if(currentPosition!=null) {
                Post post = new Post(species, this.profile, date, new GeoPoint(currentPosition.getLatitude(), currentPosition.getLongitude()), description, BirdsList.findMipmap(species));
                Log.d("POST", "onClick: " + post.toString());
                PostListTool.addPost(post, getSharedPreferences(PostListTool.KEY, Context.MODE_PRIVATE));

                NotificationTool notif = new NotificationTool(this);
                notif.notify(1,true, "NOUVEAU", species.toString(),BirdsList.findMipmap(species));

                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(intent);
            }
            else{
                ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},REQUEST_CODE);
            }
        }

    }

    LocationListener initListener(){
        LocationListener listener= new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                currentPosition = new GeoPoint(location);
                textViewPosition.setText(currentPosition.toDoubleString());


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        return listener;
    }
}

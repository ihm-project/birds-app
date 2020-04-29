package com.example.birdsapp.map.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import com.example.birdsapp.R;
import com.example.birdsapp.map.IGPSActivity;
import com.example.birdsapp.models.Post;
import com.example.birdsapp.post.activity.PostActivity;
import com.example.birdsapp.profile.activity.ProfileModificator;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;


public class MapFragment extends Fragment implements IGPSActivity {

    IMapController mapController;
    private MapView map;
    private Location currentLocation;
    private GeoPoint currentPosition;
    private LocationManager locationManager;
    private MyLocationNewOverlay mLocationOverlay;

    public MapFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().load(   getContext(),
                PreferenceManager.getDefaultSharedPreferences(getContext()) );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView=inflater.inflate(R.layout.fragment_map,container,false);
        this.map=initMap(rootView);

        boolean permissionGranted1  = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED;
        rootView.findViewById(R.id.btnAddPost).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPostActivity = new Intent(getActivity().getApplicationContext(), PostActivity.class);
                startActivity(intentPostActivity);
            }
        });
        if(permissionGranted1){
            rootView.findViewById(R.id.positionButton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   moveCamera();
                }
            });


            this.mLocationOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getContext()),map);
            this.mLocationOverlay.enableMyLocation();
            this.mLocationOverlay.enableFollowLocation();
            mLocationOverlay.set;

            map.getOverlays().add(this.mLocationOverlay);
            currentPosition=mLocationOverlay.getMyLocation();

            
            LocationListener listener = initListener();
            locationManager = (LocationManager) (getActivity().getSystemService(Context.LOCATION_SERVICE));
            locationManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 5000, 1, listener);

        }
        else {
            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},REQUEST_CODE);
        }
        return rootView;
    }

    @Override
    public void onPause(){
        super.onPause();
        map.onPause();
    }

    @Override
    public void onResume(){
        super.onResume();
        map.onResume();
    }



    /**
     * initialise la map
     * @return map initialisée
     */
    private MapView initMap(View rootView){
        MapView map;
        map= rootView.findViewById(R.id.display_map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);
        mapController = map.getController();
        mapController.setZoom(18.0);

        return map;
    }

    LocationListener initListener(){
        LocationListener listener= new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                currentLocation=location;
                currentPosition = new GeoPoint(currentLocation);
                moveCamera();


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

    @Override
    public void moveCamera() {
        mapController.animateTo(currentPosition);
    }



}

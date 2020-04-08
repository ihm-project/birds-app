package com.example.birdsapp.map.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import android.os.Bundle;

import com.example.birdsapp.R;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;




/**
 *  A AJOUTER DANS build.gradle (Module: app)
 *     androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
 *     implementation 'org.osmdroid:osmdroid-android:6.0.2'
 *     implementation "androidx.preference:preference:1.1.0"
 */
public class OSMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        Configuration.getInstance().load(   getApplicationContext(),
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()) );
        setContentView(R.layout.activity_osm);

        MapView map = findViewById(R.id.display_map);
        map.setTileSource(TileSourceFactory.MAPNIK);    //render
        map.setBuiltInZoomControls(true);               // zoomable
        map.setMultiTouchControls(true);                //  zoom with 2 fingers

        IMapController mapController = map.getController();
        mapController.setZoom(18.0);
        GeoPoint startPoint = new GeoPoint(43.65020, 7.00517);
        mapController.setCenter(startPoint);
    }
}

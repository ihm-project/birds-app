package com.example.birdsapp.map.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import com.example.birdsapp.R;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;


public class MapFragment extends Fragment {

    IMapController mapController;
    private MapView map;

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

        GeoPoint startPoint = new GeoPoint(43.61592102050781,7.072372913360596);
        mapController = map.getController();
        mapController.setZoom(18.0);
        mapController.setCenter(startPoint);

        return map;
    }
}

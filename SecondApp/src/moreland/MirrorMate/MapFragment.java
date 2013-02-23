package moreland.MirrorMate;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
/*
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.SupportMapFragment;

public class MapFragment extends SupportMapFragment {
private LocationManager locationManager;
private LocationListener locale;
private GoogleMap mymap;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    getMap().setMyLocationEnabled(true);
 //   locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000L, 10F, locale);
/*
    if(locationManager != null)
    {
        boolean gpsIsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean networkIsEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if(gpsIsEnabled)
        {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000L, 10F, (LocationListener) this);
        }
        else if(networkIsEnabled)
        {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000L, 10F, (LocationListener) this);
        }
        else
        {
            //Show an error dialog that GPS is disabled.
        }
    }
    else
    {
        //Show a generic error dialog since LocationManager is null for some reason
    }
    mymap.setMyLocationEnabled(true);
    mymap.setLocationSource((LocationSource) this);
    mymap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.basicMap)).getMap();*/
   /* return inflater.inflate(R.layout.map_fragment, container,
            false);
}

public void onDestroyView() {
    super.onDestroyView(); 
    Fragment fragment = (getFragmentManager().findFragmentById(R.id.map));  
    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
    ft.remove(fragment);
    ft.commit();
}
@Override
public void onViewCreated(View view, Bundle savedInstanceState)     {
    super.onViewCreated(view, savedInstanceState);
}
 }*/
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;

/**
 * This shows how to create a simple activity with a map and a marker on the map.
 * <p>
 * Notice how we deal with the possibility that the Google Play services APK is not
 * installed/enabled/updated on a user's device.
 */

public class MapFragment extends FragmentActivity implements LocationListener, LocationSource
{
/**
 * Note that this may be null if the Google Play services APK is not available.
 */
private GoogleMap mMap;

private OnLocationChangedListener mListener;
private LocationManager locationManager;

@Override
protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);

    setContentView(R.layout.map_fragment);

    locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

    if(locationManager != null)
    {
        boolean gpsIsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean networkIsEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if(gpsIsEnabled)
        {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000L, 10F, this);
        }
        else if(networkIsEnabled)
        {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000L, 10F, this);
        }
        else
        {
            //Show an error dialog that GPS is disabled.
        }
    }
    else
    {
        //Show a generic error dialog since LocationManager is null for some reason
    }

    setUpMapIfNeeded();
}

@Override
public void onPause()
{
    if(locationManager != null)
    {
        locationManager.removeUpdates(this);
    }

    super.onPause();
}

@Override
public void onResume()
{
    super.onResume();

    setUpMapIfNeeded();

    if(locationManager != null)
    {
        mMap.setMyLocationEnabled(true);
    }
}


/**
 * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
 * installed) and the map has not already been instantiated.. This will ensure that we only ever
 * call {@link #setUpMap()} once when {@link #mMap} is not null.
 * <p>
 * If it isn't installed {@link SupportMapFragment} (and
 * {@link com.google.android.gms.maps.MapView
 * MapView}) will show a prompt for the user to install/update the Google Play services APK on
 * their device.
 * <p>
 * A user can return to this Activity after following the prompt and correctly
 * installing/updating/enabling the Google Play services. Since the Activity may not have been
 * completely destroyed during this process (it is likely that it would only be stopped or
 * paused), {@link #onCreate(Bundle)} may not be called again so we should call this method in
 * {@link #onResume()} to guarantee that it will be called.
 */
private void setUpMapIfNeeded() {
    // Do a null check to confirm that we have not already instantiated the map.
    if (mMap == null) 
    {
        // Try to obtain the map from the SupportMapFragment.
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        // Check if we were successful in obtaining the map.

        if (mMap != null) 
        {
            setUpMap();
        }

        //This is how you register the LocationSource
        mMap.setLocationSource(this);
    }
}

/**
 * This is where we can add markers or lines, add listeners or move the camera. In this case, we
 * just add a marker near Africa.
 * <p>
 * This should only be called once and when we are sure that {@link #mMap} is not null.
 */
private void setUpMap() 
{
    mMap.setMyLocationEnabled(true);
}

@Override
public void activate(OnLocationChangedListener listener) 
{
    mListener = listener;
}

@Override
public void deactivate() 
{
    mListener = null;
}

@Override
public void onLocationChanged(Location location) 
{
	int x=0;
    if( mListener != null )
    {
        mListener.onLocationChanged( location );

        //Move the camera to the user's location once it's available!
   //     mMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
       
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
        if(x==0)
        	{
        	mMap.animateCamera(CameraUpdateFactory.zoomTo(16));
        	x=1;
        	}
    }
}

@Override
public void onProviderDisabled(String provider) 
{
    // TODO Auto-generated method stub
    Toast.makeText(this, "provider disabled", Toast.LENGTH_SHORT).show();
}

@Override
public void onProviderEnabled(String provider) 
{
    // TODO Auto-generated method stub
    Toast.makeText(this, "provider enabled", Toast.LENGTH_SHORT).show();
}

@Override
public void onStatusChanged(String provider, int status, Bundle extras) 
{
    // TODO Auto-generated method stub
    Toast.makeText(this, "status changed", Toast.LENGTH_SHORT).show();
}
}
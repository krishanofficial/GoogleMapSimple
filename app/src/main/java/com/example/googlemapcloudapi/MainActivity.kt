package com.example.googlemapcloudapi

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment

class MainActivity : AppCompatActivity() {

    private lateinit var googlemap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapView=supportFragmentManager.findFragmentById(R.id.mapView) as? SupportMapFragment
        mapView?.getMapAsync { googleMap ->
            googlemap = googleMap

            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {

            } else {
                googlemap.isMyLocationEnabled=true
                googlemap.isTrafficEnabled=true
                googlemap.uiSettings.isMyLocationButtonEnabled=true
                googlemap.uiSettings.isCompassEnabled=true
                googlemap.uiSettings.isIndoorLevelPickerEnabled=true
                googlemap.uiSettings.isZoomControlsEnabled=true
                googlemap.uiSettings.isTiltGesturesEnabled=true
                googlemap.uiSettings.isZoomGesturesEnabled=true
                googlemap.uiSettings.isScrollGesturesEnabled=true
            }
        }

    }
}
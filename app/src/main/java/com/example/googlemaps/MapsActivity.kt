package com.example.googlemaps

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap




        val latitude =-7.747033
        val latitudeJcm = -7.751883
        val latRumah = -7.867433
        val longRumah = 110.322324
        val longtitudeJcm = 110.361613
        val longitude =  110.355398
        val zoomLevel =15f
        val overlaySize = 100f

        val homeLatLng = LatLng(latitude,longitude)
        mMap.addMarker(MarkerOptions().position(homeLatLng).title("Universitas Teknologi Yogjakarta").snippet("-7.747033/110.355398"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng,zoomLevel))

        val jcm = LatLng(latitudeJcm,longtitudeJcm)
        mMap.addMarker(MarkerOptions().position(jcm).title("Jogja City Moll").snippet("-7.751883/110.361613").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))

        val Rumah = LatLng(latRumah,longRumah)
        mMap.addMarker(MarkerOptions().position(Rumah).title("Rumah").snippet("-7.867433/110.322324").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)))


        val googleOverlay= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.uty)).position(homeLatLng,overlaySize)
        mMap.addGroundOverlay(googleOverlay)

        val googleOverlay3= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.rumah)).position(Rumah,overlaySize)
        mMap.addGroundOverlay(googleOverlay3)

        val googleOverlay2= GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.jcm)).position(jcm,overlaySize)
        mMap.addGroundOverlay(googleOverlay2)
    }}
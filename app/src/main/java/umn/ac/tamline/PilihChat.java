package umn.ac.tamline;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PilihChat extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener {

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    LocationRequest mLocationRequest;

    RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutmanager;
    String[] programNameList = {"Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","PostgreSQL","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan","Bengkel Tamvan"};
    String[] programDescriptionList = {"Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109","Jl. Semangka No. 109"};
    int[] programImages = {R.drawable.bengkel_logo};

    private Button mLogout, mRequest, mKeRiwayat, mKeHome, mKeChat;

    private LatLng pickupLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_chat);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager() //Otomatis dari googlenya jadi udah enak, pas dijalanin otomatis udah ada
                .findFragmentById(R.id.map);// --/--
        mapFragment.getMapAsync(this);// --/--

//        mLogout = (Button) findViewById(R.id.logout);



        mRequest = (Button) findViewById(R.id.requestBtn);
//        mLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut(); //buat logout
//                Intent intent = new Intent(PilihChat.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//                return;
//            }
//        });

        recyclerView = findViewById(R.id.rvChatSatuan);

        layoutmanager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutmanager);

        programAdapter = new ProgramAdapter2(this, programNameList, programDescriptionList, programImages);
        recyclerView.setAdapter(programAdapter);

        mKeRiwayat = (Button) findViewById(R.id.cart);
        mKeRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PilihChat.this, DaftarRiwayat.class);
                startActivity(intent);
            }
        });
        mKeHome = (Button) findViewById(R.id.logout);
        mKeHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PilihChat.this, CustomerMapActivity.class);
                startActivity(intent);
            }
        });
    }
    public void pindahKeChattan(View view){
        Intent intent = new Intent(PilihChat.this, Chattingan.class);
        startActivity(intent);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) { //Buat ngasi tau kalo map'nya udah rede atau belum, krn cukup makan waktu jadi ini dulu yg dijalanin
        mMap = googleMap;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        buildGoogleApiClient();
        mMap.setMyLocationEnabled(true);
    }

    protected synchronized void buildGoogleApiClient(){
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        mLastLocation = location;

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) { //
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) { //check boleh nggk di-locate?
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this); // Ngetrigger refresh untuk lokasinya, kl nggk pake ya cuman kelocate sekali

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
package com.dinesh.android.java.request_permission.old_method;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Location extends AppCompatActivity {
    private final String TAG = "log_" + getClass().getName().split(getClass().getName().split("\\.")[2] + ".")[1];
    private static final int REQUEST_FINE_LOCATION = 1002;

    @Override
    protected void onStart() {
        super.onStart();

        requestingLocationPermission();
    }

    public void requestingLocationPermission() {
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Log.e(TAG, "Location : OFF");

            AlertDialog builder = new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setTitle("Location")
                    .setMessage("Location is off. Do you want to turn on?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(intent);
                            dialog.dismiss();
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Location.this, "Please turn on the location(GPS)", Toast.LENGTH_SHORT).show();
                            //                            dialog.dismiss();
                        }
                    }).show();
        } else {
            Log.i(TAG, "Location : ON");
        }

        if (ContextCompat.checkSelfPermission(Location.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //Permission Granted
            Log.i(TAG, "requestingPermission: ----> " + Manifest.permission.ACCESS_FINE_LOCATION + " Granted");
        } else {
            //Permission not Granted
            //Request for permission
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, REQUEST_FINE_LOCATION);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "onRequestPermissionsResult--> Permission Granted: " + permissions[0]);
        } else {
            Log.e(TAG, "onRequestPermissionsResult--> Permission Denied: " + permissions[0]);
            if (!ActivityCompat.shouldShowRequestPermissionRationale(Location.this, permissions[0])) {
                //This block here means PERMANENTLY DENIED PERMISSION
                Log.i(TAG, "onRequestPermissionsResult: AlertDialog");
                new AlertDialog.Builder(Location.this)
                        .setCancelable(false)
                        .setTitle("Request Location Permission")
                        .setMessage("You have permanently denied location permission. Please allow permission to access location to use this app. \n\n\n" +
                                "Do you want to go to settings to allow permission?")
                        .setPositiveButton("Go to Settings", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent();
                                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package", getPackageName(), null);
                                intent.setData(uri);
                                startActivity(intent);
                                dialog.dismiss();
                            }
                        }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Location.this, "Exit the app", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                                finish();
                                finishAffinity();
                                finishAndRemoveTask();
                            }
                        })
                        .show();
            } else {
                Log.i(TAG, "onRequestPermissionsResult--> Permission Denied Again " + permissions[0]);
                ActivityCompat.requestPermissions(this, new String[]{permissions[0]}, REQUEST_FINE_LOCATION);
            }
        }
    }

}

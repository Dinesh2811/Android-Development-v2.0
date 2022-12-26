package com.dinesh.android.java.request_permission.old_method;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Camera extends AppCompatActivity {
    private static final int REQUEST_EXTERNAL_STORAGE = 1002;
    private final String TAG = "log_" + getClass().getName().split(getClass().getName().split("\\.")[2] + ".")[1];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        requestingCameraPermission();
    }

    public void requestingCameraPermission() {
        if (ContextCompat.checkSelfPermission(Camera.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            //Permission Granted
            Log.i(TAG, "requestingPermission: ----> " + Manifest.permission.READ_EXTERNAL_STORAGE + " Granted");
        } else {
            //Permission not Granted
            //Request for permission
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE
            }, REQUEST_EXTERNAL_STORAGE);
        }
    }

}

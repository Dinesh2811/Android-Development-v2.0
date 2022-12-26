package com.dinesh.android.java.request_permission.old_method;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class ExternalStorage extends AppCompatActivity{
    private final String TAG = "log_" + getClass().getName().split(getClass().getName().split("\\.")[2] + ".")[1];
    private static final int REQUEST_EXTERNAL_STORAGE = 1001;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        requestingStoragePermission();
    }

    public void requestingStoragePermission() {
        if (ContextCompat.checkSelfPermission(ExternalStorage.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
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


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.i(TAG, "requestCode: " + requestCode);
        Log.i(TAG, "permissions: " + permissions[0]); // (Manifest.permission.READ_EXTERNAL_STORAGE)
        Log.i(TAG, "grantResults: " + grantResults[0]); // ContextCompat.checkSelfPermission(ExternalStorage.this, Manifest.permission.READ_EXTERNAL_STORAGE)

        if (grantResults.length > 0){
            if (requestCode == REQUEST_EXTERNAL_STORAGE) {
                request_EXTERNAL_STORAGE();
            }

        }

    }

    public void request_EXTERNAL_STORAGE() {
        if (ContextCompat.checkSelfPermission(ExternalStorage.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "onRequestPermissionsResult--> Permission Granted: " + (Manifest.permission.READ_EXTERNAL_STORAGE));
        } else {
            Log.e(TAG, "onRequestPermissionsResult--> Permission Denied: " + (Manifest.permission.READ_EXTERNAL_STORAGE));
            if (!ActivityCompat.shouldShowRequestPermissionRationale(ExternalStorage.this, (Manifest.permission.READ_EXTERNAL_STORAGE))) {
                //This block here means PERMANENTLY DENIED PERMISSION
                Log.i(TAG, "onRequestPermissionsResult: AlertDialog");
                new AlertDialog.Builder(ExternalStorage.this)
                        .setCancelable(false)
                        .setTitle("Request STORAGE Permission")
                        .setMessage("You have permanently denied STORAGE permission. To use the app please allow permission to access STORAGE. " +
                                "\n\n\n" +
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
                                Toast.makeText(ExternalStorage.this, "Exit the app", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                                finish();
                                finishAffinity();
                                finishAndRemoveTask();
                            }
                        })
                        .show();
            } else {
                Log.i(TAG, "onRequestPermissionsResult--> Permission Denied Again " + (Manifest.permission.READ_EXTERNAL_STORAGE));
                ActivityCompat.requestPermissions(this, new String[]{(Manifest.permission.READ_EXTERNAL_STORAGE)}, REQUEST_EXTERNAL_STORAGE);
            }
        }
    }
}



/*



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0){
            if (requestCode == REQUEST_EXTERNAL_STORAGE) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.i(TAG, "onRequestPermissionsResult--> Permission Granted: " + permissions[0]);
                } else {
                    Log.e(TAG, "onRequestPermissionsResult--> Permission Denied: " + permissions[0]);
                    if (!ActivityCompat.shouldShowRequestPermissionRationale(ExternalStorage.this, permissions[0])) {
                        //This block here means PERMANENTLY DENIED PERMISSION
                        Log.i(TAG, "onRequestPermissionsResult: AlertDialog");
                        new AlertDialog.Builder(ExternalStorage.this)
                                .setCancelable(false)
                                .setTitle("Request STORAGE Permission")
                                .setMessage("You have permanently denied STORAGE permission. To use the app please allow permission to access STORAGE. " +
                                        "\n\n\n" +
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
                                        Toast.makeText(ExternalStorage.this, "Exit the app", Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                        finish();
                                        finishAffinity();
                                        finishAndRemoveTask();
                                    }
                                })
                                .show();
                    } else {
                        Log.i(TAG, "onRequestPermissionsResult--> Permission Denied Again " + permissions[0]);
                        ActivityCompat.requestPermissions(this, new String[]{permissions[0]}, REQUEST_EXTERNAL_STORAGE);
                    }
                }
            }else {
                Log.e(TAG, "onRequestPermissionsResult: else 000000000" +requestCode);
            }



        }


    }
 */


/*

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (requestCode == REQUEST_EXTERNAL_STORAGE  && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            }
            Log.i(TAG, "onRequestPermissionsResult--> Permission Granted: " + permissions[0]);
        } else {
            Log.e(TAG, "onRequestPermissionsResult--> Permission Denied: " + permissions[0]);
            if (!ActivityCompat.shouldShowRequestPermissionRationale(ExternalStorage.this, permissions[0])) {
                //This block here means PERMANENTLY DENIED PERMISSION
                Log.i(TAG, "onRequestPermissionsResult: AlertDialog");
                new AlertDialog.Builder(ExternalStorage.this)
                        .setCancelable(false)
                        .setTitle("Request STORAGE Permission")
                        .setMessage("You have permanently denied STORAGE permission. To use the app please allow permission to access STORAGE. " +
                                "\n\n\n" +
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
                                Toast.makeText(ExternalStorage.this, "Exit the app", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                                finish();
                                finishAffinity();
                                finishAndRemoveTask();
                            }
                        })
                        .show();
            } else {
                Log.i(TAG, "onRequestPermissionsResult--> Permission Denied Again " + permissions[0]);
                ActivityCompat.requestPermissions(this, new String[]{permissions[0]}, REQUEST_EXTERNAL_STORAGE);
            }
        }
    }
 */
package com.dinesh.android.java.basic.image_view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dinesh.android.R;
import com.dinesh.android.java.request_permission.old_method.ExternalStorage;

public class Gallery_Camera extends ExternalStorage {
    private final String TAG = "log_" + getClass().getName().split(getClass().getName().split("\\.")[2] + ".")[1];

    private static final int REQUEST_PICK_IMAGE = 101;
    private static final int REQUEST_CAPTURE_IMAGE = 102;

    private static final int REQUEST_CAMERA_PERMISSION = 1002;

    ImageView imageView;
    Button btnGallery, btnCamera;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_image_view);

        btnGallery = findViewById(R.id.button3);
        btnCamera = findViewById(R.id.button4);
        imageView = findViewById(R.id.imageView2);


        Glide.with(this)
                .load("https://loremflickr.com/500/500")
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .centerInside()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);


        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImageFromGallery();
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (ContextCompat.checkSelfPermission(Gallery_Camera.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    //Permission Granted
                    Log.i(TAG, "requestingPermission: ----> " + Manifest.permission.CAMERA + " Granted");
                    captureImageUsingCamera();
                } else {
                    //Permission not Granted
                    //Request for permission
                    ActivityCompat.requestPermissions(Gallery_Camera.this, new String[]{
                            Manifest.permission.CAMERA
                    }, REQUEST_CAMERA_PERMISSION);
                }

            }
        });

    }

    public void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");

        startActivityForResult(intent, REQUEST_PICK_IMAGE);
    }

    public void captureImageUsingCamera() {
        Intent intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAPTURE_IMAGE);
    }


        @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == REQUEST_PICK_IMAGE){
                Uri uri = data.getData();
                Log.i(TAG, "onActivityResult: uri: "+uri);
                imageView.setImageURI(uri);
            } else if (requestCode == REQUEST_CAPTURE_IMAGE){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);
            }
        }
    }

}

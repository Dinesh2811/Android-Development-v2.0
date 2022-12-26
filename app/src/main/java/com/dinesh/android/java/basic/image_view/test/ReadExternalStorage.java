package com.dinesh.android.java.basic.image_view.test;


import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dinesh.android.databinding.TestActivityReadExternalStorageBinding;

public class ReadExternalStorage extends AppCompatActivity {

    private TestActivityReadExternalStorageBinding binding;
    private ActivityResultLauncher<String> mTakePhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = TestActivityReadExternalStorageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();

    }

    private void init(){

        mTakePhoto = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {

                        binding.firebaseimage.setImageURI(result);

                    }
                }
        );

        binding.selectImagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ContextCompat.checkSelfPermission(
                        ReadExternalStorage.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                ){

                    mTakePhoto.launch("image/*");

                }else{

                    Toast.makeText(ReadExternalStorage.this,"Permission not Granted",Toast.LENGTH_SHORT).show();
                }



            }
        });

    }
}
package com.example.nourdaghash;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int CAMERA_REQUEST = 0;
    private ImageView imageViewThePhoto;
    private Button buttonTakePhoto, buttonOpenGallery;
    private Bitmap bitmap;

    //This variable will hold the photo of the camera

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        //Create this display objects so they can be programed
        imageViewThePhoto = findViewById(R.id.imageViewThePhoto);
        buttonTakePhoto = findViewById(R.id.buttonTakePhoto);
        buttonTakePhoto.setOnClickListener (this);
        buttonOpenGallery = findViewById(R.id.buttonOpenGallery);
        buttonOpenGallery.setOnClickListener(this);


    }



    @Override
    @RequiresApi (api = Build.VERSION_CODES.M)
    public void onClick(View view) {
        if (view == buttonTakePhoto) {
            //Camera

            f(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
              requestPermissions(new String[]{Manifest.permission.CAMERA},CAMERA_REQUEST);

}

            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i, CAMERA_REQUEST);
        }//if

        else {
            if (view == buttonOpenGallery ){
                //gallery

            }
        }//else


    }//onClick

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_REQUEST){
            if (grantResults [0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this, "No Permission was Granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && requestCode==RESULT_OK){
            bitmap=(Bitmap) data.getExtras().get("data");
            imageViewThePhoto.setImageBitmap(bitmap);

        }

    }
}
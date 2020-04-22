package com.example.birdsapp.tools;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.widget.ImageView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class CameraTool {
    public static final int REQUEST_CAMERA = 100;
    private static final String DIR_NAME = "imagesDir";

    /**
     * à utiliser par le bouton de prise de photo
     * @param context getContext()
     * @param activity getActivity()
     */
    public static void use_camera(Context context, Activity activity){
        if(ContextCompat.checkSelfPermission( context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions( activity,
                                                new String[]{Manifest.permission.CAMERA},
                                                REQUEST_CAMERA);
        } else {
            takePicture(activity);
        }
    }

    public static void takePicture(Activity activity) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        activity.startActivityForResult(intent, REQUEST_CAMERA);
    }
}

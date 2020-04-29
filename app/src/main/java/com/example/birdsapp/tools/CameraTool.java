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
    public static final int REQUEST_READ_EXT_MEM = 101;
    public static final int REQUEST_WRITE_EXT_MEM = 102;
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

    public static void read_memory(Context context, Activity activity, ToDoAfter toDo){
        if(ContextCompat.checkSelfPermission( context, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions( activity,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    REQUEST_READ_EXT_MEM);
        } else {
            toDo.toDo();
        }
    }

    public static void write_memory(Context context, Activity activity, ToDoAfter toDo){
        if(ContextCompat.checkSelfPermission( context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions( activity,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_WRITE_EXT_MEM);
        } else {
            toDo.toDo();
        }
    }
}

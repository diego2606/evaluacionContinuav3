package com.example.evaluacioncontinuav3;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends AppCompatActivity {
    ImageView set;
    ProgressDialog pd;
    private static final int CAMERA_REQUEST = 100;
    private static final int STORAGE_REQUEST = 200;
    private static final int IMAGE_PICK_GALLERY_REQUEST = 300;
    private static final int IMAGE_PICK_CAMERA_REQUEST = 400;

    String cameraPermision[];
    String storagePermision[];

    Uri imageUri;
    String profileOrCoverImage;
    AppCompatButton editImage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_fragment);
        editImage = findViewById(R.id.edit_image);
    }


}

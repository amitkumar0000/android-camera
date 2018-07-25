package com.android.camera;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.camera.models.CameraModels;
import com.android.camera.utils.Constants;

public class MainActivity extends AppCompatActivity {
    CameraModels cameraModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CameraActivity cameraActivity = DataBindingUtil.setContentView(this,R.layout.activity_main);
        cameraModels = new CameraModels();

        cameraActivity.setCameramodels(cameraModels);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.CAMERA_PIC_REQUEST && data!=null
                && data.getExtras()!=null) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            if(image!=null) {
                cameraModels.setImageBitmap(image);
                cameraModels.setName("VIPIN");
            }
        }
    }
}

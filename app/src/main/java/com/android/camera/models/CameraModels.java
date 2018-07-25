package com.android.camera.models;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.android.camera.BR;

import static com.android.camera.utils.Constants.CAMERA_PIC_REQUEST;

public class CameraModels extends BaseObservable{

    Bitmap imageBitmap;

    ImageView imageView;

    String name;


    public void onCameraAction(Context context){
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        ((Activity) context).startActivityForResult(intent,CAMERA_PIC_REQUEST);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
        notifyPropertyChanged(BR.imageView);
    }

    @Bindable
    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public void setImageBitmap(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
        notifyPropertyChanged(BR.imageBitmap);
    }

    @BindingAdapter("android:src")
    public static void loadImage(ImageView iv, Bitmap bitmap) {
        iv.setImageBitmap(bitmap);
    }
}

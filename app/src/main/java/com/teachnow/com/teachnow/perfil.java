package com.teachnow.com.teachnow;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class perfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        /*Drawable originDrawable = getResources().getDrawable(R.drawable.profile);
        Bitmap originBitmap = ((BitmapDrawable) originDrawable).getBitmap();

        RoundedBitmapDrawable roundedDrawable = RoundedBitmapDrawableFactory.create(getResources(), originBitmap);

        roundedDrawable.setCornerRadius(originBitmap.getHeight());

        ImageView imageView = (ImageView) findViewById(R.id.imagePerfil);

        imageView.setImageDrawable(roundedDrawable);*/

    }

}

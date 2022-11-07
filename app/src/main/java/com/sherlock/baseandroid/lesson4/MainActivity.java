package com.sherlock.baseandroid.lesson4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        Typeface tf = Typeface.createFromAsset(getAssets(),"font/teddy-bear.ttf");
        TextView tvDescriptionLang = findViewById(R.id.textVLang);
        tvDescriptionLang.setTypeface(tf);
        tvDescriptionLang.setText(getText(R.string.descriptionLanguage));
        AppCompatImageView image = findViewById(R.id.imageView);
        loadImageFromAsset(image,"android.png");
    }

    private void loadImageFromAsset(ImageView image, String fileName){
        try{
            InputStream ims = getAssets().open(fileName);
            Drawable d = Drawable.createFromStream(ims,null);
            image.setImageDrawable(d);
        }catch (IOException ex){
            return;
        }

    }

}
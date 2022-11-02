package com.sherlock.baseandroid.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        TextView tvDescriptionLang = findViewById(R.id.textVLang);
        tvDescriptionLang.setText(getText(R.string.descriptionLanguage));
    }
}
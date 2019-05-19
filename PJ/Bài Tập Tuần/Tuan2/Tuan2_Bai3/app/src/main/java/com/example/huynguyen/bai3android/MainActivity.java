package com.example.huynguyen.bai3android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.content.*;

public class MainActivity extends AppCompatActivity {

    private RadioGroup RadioGroup;
    private ImageView ImageView;
    private Integer []photos = { R.drawable.bird, R.drawable.cat, R.drawable.dog, R.drawable.rabbit, R.drawable.pig};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ImageView = (ImageView) findViewById(R.id.ImageView);
        this.RadioGroup =  (RadioGroup) findViewById(R.id.RadioGroup);
        this.RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(android.widget.RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton) radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
                ImageView.setImageResource(photos[index]);
            }
        });
    }
}

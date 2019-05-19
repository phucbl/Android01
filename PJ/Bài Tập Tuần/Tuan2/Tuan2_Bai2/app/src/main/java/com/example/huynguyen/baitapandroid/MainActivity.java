package com.example.huynguyen.baitapandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private CheckBox check1, check2, check3, check4;
    private ImageView image1, image2, image3, image4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListnerToCheckBox();
    }
    public void addListnerToCheckBox() {
        check1 = (CheckBox) findViewById(R.id.Gun);
        check2 = (CheckBox) findViewById(R.id.Pistol);
        check3 = (CheckBox) findViewById(R.id.Bullets);
        check4 = (CheckBox) findViewById(R.id.Nade);
        image1 = (ImageView) findViewById(R.id.ImageGun);
        image2 = (ImageView) findViewById(R.id.ImagePistol);
        image3 = (ImageView) findViewById(R.id.ImageBullets);
        image4 = (ImageView) findViewById(R.id.ImageNade);

        check1.setOnClickListener( new View.OnClickListener() {
                                      @Override
                                      public void onClick(View a) {
                                          if (((CheckBox) a).isChecked()) {
                                              image1.setImageResource(R.drawable.gun);
                                              image1.setVisibility(View.VISIBLE);
                                          }else image1.setVisibility(View.INVISIBLE);
                                      }
                                  }
        );

        check2.setOnClickListener( new View.OnClickListener() {
                                      @Override
                                      public void onClick(View b) {
                                          if (((CheckBox) b).isChecked()) {
                                              image2.setImageResource(R.drawable.pistol);
                                              image2.setVisibility(View.VISIBLE);
                                          }else image2.setVisibility(View.INVISIBLE);
                                      }
                                  }
        );

        check3.setOnClickListener( new View.OnClickListener() {
                                      @Override
                                      public void onClick(View c) {
                                          if (((CheckBox) c).isChecked()) {
                                              image3.setImageResource(R.drawable.bullets);
                                              image3.setVisibility(View.VISIBLE);
                                          }else image3.setVisibility(View.INVISIBLE);
                                      }
                                  }
        );

        check4.setOnClickListener( new View.OnClickListener() {
                                      @Override
                                      public void onClick(View d) {
                                          if (((CheckBox) d).isChecked()) {
                                              image4.setImageResource(R.drawable.nade);
                                              image4.setVisibility(View.VISIBLE);
                                          }else image4.setVisibility(View.INVISIBLE);
                                      }
                                  }
        );
    }
}

package com.example.roommanage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class ActivitySplashScreen extends AppCompatActivity {

    LinearLayout lnran1, lnran2;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.GIAODIEN);

        lnran1 = (LinearLayout) findViewById(R.id.linearsp1);
        lnran2 = (LinearLayout) findViewById(R.id.linearsp2);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_down);
        lnran1.setAnimation(animation);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.push_right);
        lnran2.setAnimation(animation);

        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(4000);
                    Intent intent = new Intent(getApplicationContext(),Home.class);
                    startActivity(intent);
                    finish();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                super.run();

            }
        };
        thread.start();
    }
}

package com.example.roommanage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {

    LinearLayout lnrAvai, lnrFull, lnrKhach, lnrPhieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Anhxa();

        lnrAvai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, MainActivity.class));
            }
        });
        lnrFull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, MainActivity.class));
            }
        });
        lnrKhach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, MainActivity.class));
            }
        });
        lnrPhieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, ShowPhieu.class));
            }
        });

    }

    private void Anhxa() {
        lnrAvai  = (LinearLayout) findViewById(R.id.linearAvai);
        lnrFull  = (LinearLayout) findViewById(R.id.LinearFull);
        lnrKhach = (LinearLayout) findViewById(R.id.LinearKhach);
        lnrPhieu = (LinearLayout) findViewById(R.id.linearPhieu);
    }
}

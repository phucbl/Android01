package com.example.tracnghiem;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class man6 extends AppCompatActivity {
    Switch a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man6);
        Button btnBack = findViewById(R.id.back);
        Button btnForward = findViewById(R.id.forward);
        Button btnResult = findViewById(R.id.result);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(man6.this,man6.class);
                startActivity(intent);
            }
        });
        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(man6.this,man6.class);
                startActivity(intent);
            }
        });
        a = findViewById(R.id.cau1);
        b = findViewById(R.id.cau2);
        c = findViewById(R.id.cau3);
        a.setTextOff("Sai");
        a.setTextOn("Đúng");
        b.setTextOff("Sai");
        b.setTextOn("Đúng");
        c.setTextOff("Sai");
        c.setTextOn("Đúng");

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result;

                if (a.isChecked() == false && b.isChecked() && c.isChecked()){
                    result = "Bạn đã trả lời đúng hết những câu hỏi trên";
                }
                else
                    result = "Bạn đã trả lời sai.";

                AlertDialog.Builder builder = new AlertDialog.Builder(man6.this);
                builder.setTitle("KẾT QUẢ");
                builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.cancel();
                    }
                });


                builder.setMessage(result);
                builder.create().show();
            }
        });
    }
}

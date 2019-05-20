package com.example.choibai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
  //click nút PLay trước khi click vào lá bài
    //Mỗi lượt chơi lá bài chỉ được lật 1 lần nên sau khi lick lá bài sẽ bị vô hiệu hóa muốn chơi lại phải lick nút play
    // Khi lick vào lá bài nút PLAY sẽ bị vô hiệu hóa và sau khi lick xong 3 lá nút PLAY sẽ được enable để chơi lại
    Button btn1,btn2,btn3,btnplay, nen;
    TextView scource;
    ArrayList<Integer> arrayImage;
    int diem =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        scource.setText(diem+"");

       btnDisable();
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Lick vào hinh để mở bai",Toast.LENGTH_LONG).show();

               btnEnable();
               btnplay.setEnabled(false);

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"Hiện random hinh anh",Toast.LENGTH_LONG).show();
                        RandomHinh(btn1);
                        btn1.setEnabled(false);
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"Hiện random hinh anh",Toast.LENGTH_LONG).show();
                        RandomHinh(btn2);
                        btn2.setEnabled(false);
                    }
                });
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,"Hiện random hinh anh",Toast.LENGTH_LONG).show();
                        RandomHinh(btn3);
                        btn3.setEnabled(false);
                    }
                });

                btnplay.setEnabled(true);
            }
        });

    }

    private void AnhXa ()
    {
        btn1 = (Button)findViewById(R.id.la1);
        btn2 = (Button)findViewById(R.id.la2);
        btn3 = (Button)findViewById(R.id.la3);
        btnplay = (Button)findViewById(R.id.play);
        scource = (TextView)findViewById(R.id.diem);
    }
    private void RandomHinh(Button bt)
    {
        int btn = bt.getId();
        nen =(Button) findViewById(btn); // hiện thị ngẫu nhiên hinh nền

        arrayImage = new ArrayList<>();

        arrayImage.add(R.drawable.ba0);
        arrayImage.add(R.drawable.b10);
        arrayImage.add(R.drawable.b2);
        arrayImage.add(R.drawable.b3);
        arrayImage.add(R.drawable.b4);
        arrayImage.add(R.drawable.b5);
        arrayImage.add(R.drawable.b6);
        arrayImage.add(R.drawable.b7);
        arrayImage.add(R.drawable.b8);
        arrayImage.add(R.drawable.b9);
        arrayImage.add(R.drawable.ca0);
        arrayImage.add(R.drawable.c10);
        arrayImage.add(R.drawable.c2);
        arrayImage.add(R.drawable.c3);
        arrayImage.add(R.drawable.c4);
        arrayImage.add(R.drawable.chuon5);
        arrayImage.add(R.drawable.c6);
        arrayImage.add(R.drawable.c7);
        arrayImage.add(R.drawable.c8);
        arrayImage.add(R.drawable.c9);
        arrayImage.add(R.drawable.jbich0);
        arrayImage.add(R.drawable.jchuon0);
        arrayImage.add(R.drawable.jco0);
        arrayImage.add(R.drawable.jro0);
        arrayImage.add(R.drawable.kbich0);
        arrayImage.add(R.drawable.kchuon0);
        arrayImage.add(R.drawable.kco0);
        arrayImage.add(R.drawable.kro0);
        arrayImage.add(R.drawable.qbich0);
        arrayImage.add(R.drawable.qchuon0);
        arrayImage.add(R.drawable.qco0);
        arrayImage.add(R.drawable.qro0);
        arrayImage.add(R.drawable.ra0);
        arrayImage.add(R.drawable.r10);
        arrayImage.add(R.drawable.r2);
        arrayImage.add(R.drawable.ro3);
        arrayImage.add(R.drawable.ro4);
        arrayImage.add(R.drawable.r5);
        arrayImage.add(R.drawable.r6);
        arrayImage.add(R.drawable.r7);
        arrayImage.add(R.drawable.r8);
        arrayImage.add(R.drawable.r9);

        Random rd = new Random();
        int BG = rd.nextInt(arrayImage.size());
        nen.setBackgroundResource(arrayImage.get(BG));

    }
    private void btnEnable()
    {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
    }
    private void btnDisable()
    {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
    }

}

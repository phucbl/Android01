package com.example.bai3_tuan7;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageButton;
import android.widget.ListView;

public class ChuyenPhongBanActivity extends Activity {

    ListView lvPb;
    private static ArrayList<PhongBan>arrPhongBan=null;
    ArrayAdapter<PhongBan>adapter;
    ImageButton btnApply;
    NhanVien nv=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuyen_phong_ban);
        getFormWidgets();

        Intent i=getIntent();
        Bundle b= i.getBundleExtra("DATA");
        nv=(NhanVien) b.getSerializable("NHANVIEN");
    }

    public void getFormWidgets()
    {
        lvPb=(ListView) findViewById(R.id.lvphongban);
        btnApply=(ImageButton) findViewById(R.id.imgapply);

        arrPhongBan=MainActivity.getListPhongBan();
        adapter=new ArrayAdapter<PhongBan>
                (this, android.R.layout.simple_list_item_single_choice,
                        arrPhongBan);
        lvPb.setAdapter(adapter);

        lvPb.setOnItemClickListener(new OnItemClickListener() {

            boolean somethingChecked = false;
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                if(somethingChecked){
                    CheckedTextView cv = (CheckedTextView) arg1;
                    cv.setChecked(false);

                }
                CheckedTextView cv = (CheckedTextView) arg1;
                if(!cv.isChecked())
                {
                    cv.setChecked(true);
                    arrPhongBan.get(arg2).themNv(nv);
                }
                somethingChecked=true;
            }
        });

        btnApply.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                doApply();

            }
        });
    }
    public void doApply()
    {
        setResult(MainActivity.CHUYENPHONG_THANHCONG);
        finish();
    }
}


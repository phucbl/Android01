package com.example.bai3_tuan7;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.app.Activity;
import android.content.Intent;

public class ThietLapTruongPhongActivity extends Activity {

    ListView lvtruongphong,lvphophong;
    ArrayList<NhanVien>arrNvForTP=new ArrayList<NhanVien>();
    ArrayAdapter<NhanVien> adapterForTP;
    ArrayList<NhanVien>arrNvForPP=new ArrayList<NhanVien>();
    ArrayAdapter<NhanVien> adapterForPP;
    ImageButton btnApply;
    int lastChecked=-1;
    PhongBan pb=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thiet_lap_truong_phong);
        getFormWidgets();
    }

    public void getFormWidgets()
    {
        lvtruongphong=(ListView) findViewById(R.id.lvtruongphong);
        lvtruongphong.setTextFilterEnabled(true);
        lvtruongphong.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lvtruongphong.setOnItemClickListener(new OnItemClickListener() {
            boolean somethingChecked = false;
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                arrNvForTP.get(arg2).setChucvu(ChucVu.TruongPhong);
                if(somethingChecked){
                    CheckedTextView cv = (CheckedTextView) arg1;
                    cv.setChecked(false);

                }
                CheckedTextView cv = (CheckedTextView) arg1;
                if(!cv.isChecked())
                {
                    cv.setChecked(true);
                    arrNvForTP.get(arg2).setChucvu(ChucVu.TruongPhong);
                }
                else
                {
                    arrNvForTP.get(arg2).setChucvu(ChucVu.NhanVien);
                }
                lastChecked = arg2;
                somethingChecked=true;
            }

        });
        lvphophong=(ListView) findViewById(R.id.lvphophong);
        lvphophong.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                CheckedTextView cv = (CheckedTextView) arg1;
                if(!cv.isChecked())
                {cv.setChecked(true);
                    arrNvForPP.get(arg2).setChucvu(ChucVu.PhoPhong);
                }
                else
                {cv.setChecked(false);
                    arrNvForPP.get(arg2).setChucvu(ChucVu.NhanVien);
                }
            }

        });

        adapterForTP=new ArrayAdapter<NhanVien>(this,
                android.R.layout.simple_list_item_single_choice,
                arrNvForTP);
        adapterForPP=new ArrayAdapter<NhanVien>(this,
                android.R.layout.simple_list_item_multiple_choice,
                arrNvForPP);
        lvtruongphong.setAdapter(adapterForTP);
        lvphophong.setAdapter(adapterForPP);
        Intent i= getIntent();
        Bundle bundle= i.getBundleExtra("DATA");
        pb= (PhongBan) bundle.getSerializable("PHONGBAN");
        addNvToListTP(pb);
        addNvToListPP(pb);
        adapterForTP.notifyDataSetChanged();
        adapterForPP.notifyDataSetChanged();

        btnApply=(ImageButton) findViewById(R.id.imgapply);
        btnApply.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                doApply();

            }
        });
    }

    public void doApply()
    {
        Intent i=getIntent();
        Bundle bundle=new Bundle();
        bundle.putSerializable("PHONGBAN", pb);
        i.putExtra("DATA", bundle);
        setResult(MainActivity.THIET_LAP_TP_PP_THANHCONG, i);
        finish();
    }

    public void addNvToListTP(PhongBan pb)
    {
        arrNvForTP.clear();
        for(NhanVien nv:pb.getListNhanVien())
        {
            arrNvForTP.add(nv);
        }
    }

    public void addNvToListPP(PhongBan pb)
    {
        arrNvForPP.clear();
        for(NhanVien nv:pb.getListNhanVien())
        {
            arrNvForPP.add(nv);
        }
    }
}


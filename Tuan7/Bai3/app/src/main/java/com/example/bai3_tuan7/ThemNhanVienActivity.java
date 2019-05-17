package com.example.bai3_tuan7;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class ThemNhanVienActivity extends Activity {

    private Button btnXoaTrang,btnLuuNhanVien;
    private EditText editManv,editTenNv;
    private RadioButton radNam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhan_vien);
        getFormWidgets();
        addEvents();
    }

    public void getFormWidgets()
    {
        btnXoaTrang=(Button) findViewById(R.id.btnxoatrang);
        btnLuuNhanVien=(Button) findViewById(R.id.btnluunv);
        editManv=(EditText) findViewById(R.id.editMaNV);
        editTenNv=(EditText) findViewById(R.id.editTenNV);
        radNam=(RadioButton) findViewById(R.id.radNam);
    }

    public void addEvents()
    {
        btnXoaTrang.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                doXoaTrang();
            }
        });
        btnLuuNhanVien.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                doLuuNhanVien();
            }
        });
    }

    public void doXoaTrang()
    {
        editManv.setText("");
        editTenNv.setText("");
        editManv.requestFocus();
    }

    public void doLuuNhanVien()
    {
        NhanVien nv=new NhanVien();
        nv.setMa(editManv.getText()+"");
        nv.setTen(editTenNv.getText()+"");
        nv.setChucvu(ChucVu.NhanVien);
        nv.setGioitinh(!radNam.isChecked());
        Intent i=getIntent();
        Bundle bundle=new Bundle();
        bundle.putSerializable("NHANVIEN", nv);
        i.putExtra("DATA", bundle);
        setResult(MainActivity.THEM_NHAN_VIEN_THANHCONG, i);
        finish();
    }
}


package com.example.bai3_tuan7;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class DanhSachNhanVienActivity extends Activity {

    TextView txtmsg;
    ImageButton btnback;
    ListView lvNhanvien;
    ArrayList<NhanVien> arrNhanvien=null;

    NhanVienAdapter adapter=null;
    PhongBan pb=null;
    private NhanVien nvSelected=null;
    private int position=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_nhan_vien);
        txtmsg=(TextView) findViewById(R.id.txtmsg);
        btnback=(ImageButton) findViewById(R.id.btnback);
        lvNhanvien=(ListView) findViewById(R.id.lvnhanvien);
        getDataFromMain();
        addEvents();
        registerForContextMenu(lvNhanvien);
    }

    public void getDataFromMain()
    {
        Intent i=getIntent();
        Bundle b=i.getBundleExtra("DATA");
        pb= (PhongBan) b.getSerializable("PHONGBAN");
        arrNhanvien=pb.getListNhanVien();
        adapter=new NhanVienAdapter(this,
                R.layout.layout_item_custom,
                arrNhanvien);
        lvNhanvien.setAdapter(adapter);
        txtmsg.setText("DS nhân viên ["+pb.getTen()+"]");
    }

    public void addEvents()
    {
        btnback.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                doUpdateToMain();
            }
        });
        lvNhanvien.setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                nvSelected=arrNhanvien.get(arg2);
                position=arg2;
                return false;
            }

        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu_nhanvien, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.mnusuanv:
                doSuaNhanVien();
                break;
            case R.id.mnuchuyenpb:
                doChuyenPhongBan();
                break;
            case R.id.mnuxoanv:
                doXoaNhanVien();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==MainActivity.SUA_NHAN_VIEN_THANHCONG)
        {
            Bundle b=data.getBundleExtra("DATA");
            NhanVien nv= (NhanVien) b.getSerializable("NHANVIEN");
            arrNhanvien.set(position, nv);
            adapter.notifyDataSetChanged();
        }

        else if(resultCode==MainActivity.CHUYENPHONG_THANHCONG)
        {
            arrNhanvien.remove(nvSelected);
            adapter.notifyDataSetChanged();
        }
    }

    public void doSuaNhanVien()
    {
        Intent i=new Intent(this, SuaNhanVienActivity.class);
        Bundle b=new Bundle();
        b.putSerializable("NHANVIEN", nvSelected);
        i.putExtra("DATA", b);
        startActivityForResult(i, MainActivity.MO_ACTIVITY_SUA_NHAN_VIEN);
    }

    public void doChuyenPhongBan()
    {
        Intent i=new Intent(this, ChuyenPhongBanActivity.class);
        Bundle b=new Bundle();
        b.putSerializable("NHANVIEN", nvSelected);
        i.putExtra("DATA", b);
        startActivityForResult(i, MainActivity.MO_ACTIVITY_CHUYENPHONG);
    }

    public void doXoaNhanVien()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder (this);
        builder.setTitle("Hỏi xóa");
        builder.setMessage("Bạn có chắc chắn muốn xóa ["+nvSelected.getTen()+"]");
        builder.setIcon(android.R.drawable.ic_input_delete);
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                arg0.cancel();
            }
        });
        builder.setPositiveButton("Ừ", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                arrNhanvien.remove(nvSelected);
                adapter.notifyDataSetChanged();
            }
        });
        builder.show();
    }

    public void doUpdateToMain()
    {
        Intent i=getIntent();
        Bundle b=new Bundle();
        b.putSerializable("PHONGBAN", pb);
        i.putExtra("DATA", b);
        setResult(MainActivity.CAPNHAT_DS_NHAN_VIEN_THANHCONG, i);
        finish();
    }
}


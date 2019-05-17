package com.example.bai3_tuan7;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class MainActivity extends Activity {

    public static final int MO_ACTIVITY_THEM_NHAN_VIEN=1;
    public static final int MO_ACTIVITY_SUA_NHAN_VIEN=2;
    public static final int THEM_NHAN_VIEN_THANHCONG=3;
    public static final int SUA_NHAN_VIEN_THANHCONG=4;
    public static final int XEM_DS_NHAN_VIEN=5;
    public static final int CAPNHAT_DS_NHAN_VIEN_THANHCONG=6;
    public static final int MO_ACTIVITY_THIET_LAP_TP_PP=7;
    public static final int THIET_LAP_TP_PP_THANHCONG=8;
    public static final int MO_ACTIVITY_CHUYENPHONG=9;
    public static final int CHUYENPHONG_THANHCONG=10;

    private Button btnLuuPb;
    private EditText editMapb,editTenpb;
    private ListView lvpb;
    private static ArrayList<PhongBan>arrPhongBan=new ArrayList<PhongBan>();

    private PhongBanAdapter adapterPb=null;
    private PhongBan pbSelected=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFormWidgets();
        addEvents();
        fakeData();
    }

    public void fakeData()
    {
        NhanVien nv=null;
        PhongBan pb=new PhongBan("pb1", "Kỹ thuật");
        nv=new NhanVien("m4", "Đoàn Ái Nương", true);
        nv.setChucvu(ChucVu.TruongPhong);
        pb.themNv(nv);
        nv=new NhanVien("m5", "Trần Đạo Đức", false);
        nv.setChucvu(ChucVu.PhoPhong);
        pb.themNv(nv);
        nv=new NhanVien("m6", "Nguyễn Đại Tài", false);
        nv.setChucvu(ChucVu.PhoPhong);
        pb.themNv(nv);
        arrPhongBan.add(pb);
        pb=new PhongBan("pb2", "Dịch vụ");
        arrPhongBan.add(pb);
        pb=new PhongBan("pb3", "Truyền thông");
        arrPhongBan.add(pb);
        nv=new NhanVien("m1", "Nguyễn Văn Tẻo", false);
        nv.setChucvu(ChucVu.NhanVien);
        pb.themNv(nv);
        nv=new NhanVien("m2", "Nguyễn Thị Téo", true);
        nv.setChucvu(ChucVu.TruongPhong);
        pb.themNv(nv);
        nv=new NhanVien("m3", "Nguyễn Văn Teo", false);
        nv.setChucvu(ChucVu.NhanVien);
        pb.themNv(nv);

        adapterPb.notifyDataSetChanged();
    }

    public void getFormWidgets()
    {
        btnLuuPb=(Button) findViewById(R.id.btnluupb);
        editMapb=(EditText) findViewById(R.id.editmapb);
        editTenpb=(EditText) findViewById(R.id.editTenpb);
        lvpb=(ListView) findViewById(R.id.lvphongban);

        adapterPb=new PhongBanAdapter(this,
                R.layout.layout_item_custom,
                arrPhongBan);
        lvpb.setAdapter(adapterPb);

        registerForContextMenu(lvpb);
    }

    public void addEvents()
    {

        btnLuuPb.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                doLuuPhongBan();
            }
        });

        lvpb.setOnItemLongClickListener(new OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {

                pbSelected=arrPhongBan.get(arg2);
                return false;
            }

        });
    }

    public void doLuuPhongBan()
    {
        String mapb=editMapb.getText()+"";
        String tenpb=editTenpb.getText()+"";
        PhongBan pb=new PhongBan(mapb, tenpb);
        arrPhongBan.add(pb);
        adapterPb.notifyDataSetChanged();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.contextmenu_phongban, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.mnuthemnv:
                doThemNhanVien();
                break;
            case R.id.mnudanhsachnv:
                doDanhSachNhanVien();
                break;
            case R.id.mnutruongphong:
                doThietLapLanhDao();
                break;
            case R.id.mnuxoapb:
                doXoaPhongBan();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void doThemNhanVien()
    {
        Intent i=new Intent(this, ThemNhanVienActivity.class);
        startActivityForResult(i, MO_ACTIVITY_THEM_NHAN_VIEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==THEM_NHAN_VIEN_THANHCONG)
        {

            Bundle bundle= data.getBundleExtra("DATA");
            NhanVien nv= (NhanVien) bundle.getSerializable("NHANVIEN");
            pbSelected.themNv(nv);
            adapterPb.notifyDataSetChanged();
        }

        else if(resultCode==THIET_LAP_TP_PP_THANHCONG||
                resultCode==CAPNHAT_DS_NHAN_VIEN_THANHCONG)
        {

            Bundle bundle= data.getBundleExtra("DATA");
            PhongBan pb= (PhongBan) bundle.getSerializable("PHONGBAN");

            pbSelected.getListNhanVien().clear();

            pbSelected.getListNhanVien().addAll(pb.getListNhanVien());
            adapterPb.notifyDataSetChanged();
        }
    }

    public void doDanhSachNhanVien()
    {
        Intent i=new Intent(this, DanhSachNhanVienActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("PHONGBAN", pbSelected);
        i.putExtra("DATA", bundle);
        startActivityForResult(i, XEM_DS_NHAN_VIEN);
    }

    public void doThietLapLanhDao()
    {
        Intent i=new Intent(this, ThietLapTruongPhongActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("PHONGBAN", pbSelected);
        i.putExtra("DATA", bundle);
        startActivityForResult(i, MO_ACTIVITY_THIET_LAP_TP_PP);
    }

    public void doXoaPhongBan()
    {
        AlertDialog.Builder builder=new AlertDialog.Builder (this);
        builder.setTitle("Hỏi xóa");
        builder.setMessage("Bạn có chắc chắn muốn xóa ["+pbSelected.getTen()+"]");
        builder.setIcon(android.R.drawable.ic_input_delete);
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO Auto-generated method stub
                arg0.cancel();
            }
        });
        builder.setPositiveButton("Ừ", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                arrPhongBan.remove(pbSelected);
                adapterPb.notifyDataSetChanged();
            }
        });
        builder.show();
    }

    public static  ArrayList<PhongBan> getListPhongBan()
    {
        return arrPhongBan;
    }
}


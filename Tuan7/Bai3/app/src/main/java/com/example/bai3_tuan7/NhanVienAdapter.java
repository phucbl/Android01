package com.example.bai3_tuan7;

import java.util.ArrayList;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NhanVienAdapter extends ArrayAdapter<NhanVien> {

    Activity context;
    int layoutId;
    ArrayList<NhanVien> arrNhanVien;
    public NhanVienAdapter(Activity context, int textViewResourceId,
                           ArrayList<NhanVien> objects) {
        super(context, textViewResourceId, objects);
        this.context=context;
        this.layoutId=textViewResourceId;
        this.arrNhanVien=objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView=context.getLayoutInflater().inflate(layoutId, null);

        TextView txtnv= (TextView) convertView.findViewById(R.id.txtShortInfor);
        TextView txtmotanv= (TextView) convertView.findViewById(R.id.txtDetailInfor);
        ImageView img=(ImageView) convertView.findViewById(R.id.imgview);

        NhanVien nv=arrNhanVien.get(position);
        txtnv.setText(nv.toString());
        String strMota="";
        String cv="Chức vụ: "+nv.getChucvu().getChucVu();
        String gt="Giới tính: "+(nv.isGioitinh()?"Nữ":"Nam");

        img.setImageResource(R.drawable.girlicon);
        if(!nv.isGioitinh())
            img.setImageResource(R.drawable.boyicon);
        strMota=cv+"\n"+gt;
        txtmotanv.setText(strMota);
        return convertView;
    }

}

package com.example.roommanage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class KhachHangAdapter extends BaseAdapter {
    private ActivityKhachHang context;
    private int layout;
    private List<KhachHang> khachHangList;

    public KhachHangAdapter(ActivityKhachHang context, int layout, List<KhachHang> khachHangList) {
        this.context = context;
        this.layout = layout;
        this.khachHangList = khachHangList;
    }

    @Override
    public int getCount() {
        return khachHangList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtMaKhachHang, txtHoTen, txtQuocTich;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        KhachHangAdapter.ViewHolder holder;
        if(view == null){
            holder = new KhachHangAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtMaKhachHang        = (TextView)view.findViewById(R.id.textviewMaKhachHang);
            holder.txtHoTen              = (TextView)view.findViewById(R.id.textviewTenKhachHang);
            holder.txtQuocTich           = (TextView)view.findViewById(R.id.textviewQuocTich);

            view.setTag(holder);
        }else{
            holder = (KhachHangAdapter.ViewHolder) view.getTag();
        }

        final KhachHang khachHang = khachHangList.get(i);

        holder.txtMaKhachHang.setText("Mã khách hàng: "+ khachHang.getMaKH());
        holder.txtHoTen.setText("Họ Tên: " + khachHang.getTenKH());
        holder.txtQuocTich.setText("Quốc tịch: "+ khachHang.getQuocTich());


        return view;
    }
}

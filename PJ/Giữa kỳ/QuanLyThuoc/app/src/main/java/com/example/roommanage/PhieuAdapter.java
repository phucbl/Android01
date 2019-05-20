package com.example.roommanage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class PhieuAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Phieu> phieuList;

    public PhieuAdapter(Context context, int layout, List<Phieu> phieuList) {
        this.context = context;
        this.layout = layout;
        this.phieuList = phieuList;
    }

    @Override
    public int getCount() {
        return phieuList.size();
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
        TextView txtHoTen, txtNgayDat, txtSoNgayO, txtMaPhong, txtLoaiPhong, txtTang, txtGiaPhong;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtHoTen             = (TextView) view.findViewById(R.id.textviewHoTenPhieu);
            holder.txtNgayDat           = (TextView) view.findViewById(R.id.textviewNgayDatPhieu);
            holder.txtSoNgayO           = (TextView) view.findViewById(R.id.textviewSoNgayOPhieu);
            holder.txtMaPhong           = (TextView) view.findViewById(R.id.textviewMaPhongPhieu);
            holder.txtLoaiPhong         = (TextView) view.findViewById(R.id.textviewLoaiPhongPhieu);
            holder.txtTang              = (TextView) view.findViewById(R.id.textviewTangPhieu);
            holder.txtGiaPhong          = (TextView) view.findViewById(R.id.textviewGiaPhongPhieu);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        final Phieu phieu = phieuList.get(i);

        holder.txtHoTen.setText("Họ tên khách hàng: "+ phieu.getTenKh());
        holder.txtNgayDat.setText("Ngày đặt phòng: " + phieu.getNgayDat());
        holder.txtSoNgayO.setText("Sô ngày ở: "+ phieu.getSoNgayO());
        holder.txtMaPhong.setText("Mã phòng đặt: " + phieu.getMaPhong());
        holder.txtLoaiPhong.setText("Loại phòng đặt: " + phieu.getLoaiPhong());
        holder.txtTang.setText("Tầng: "+ phieu.getTang());
        holder.txtGiaPhong.setText("Giá phòng: " + phieu.getGiaPhong());



        return view;
    }
}

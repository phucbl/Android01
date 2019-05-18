package com.example.roommanage;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class RoomAdapter extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<Room> roomList;

    public RoomAdapter(MainActivity context, int layout, List<Room> roomList) {
        this.context = context;
        this.layout = layout;
        this.roomList = roomList;
    }

    @Override
    public int getCount() {
        return roomList.size();
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
        RelativeLayout rltpick;
        TextView txtMaPhong, txtLoaiPhong, txtTang, txtGiaPhong;
        ImageView imgEdit, imgDelete;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.txtMaPhong        = (TextView)view.findViewById(R.id.textviewMaPhong);
            holder.txtLoaiPhong      = (TextView)view.findViewById(R.id.textviewLoaiPhong);
            holder.txtTang           = (TextView)view.findViewById(R.id.textviewTang);
            holder.txtGiaPhong       = (TextView)view.findViewById(R.id.textviewGia);
            holder.imgEdit           = (ImageView)view.findViewById(R.id.imageviewEdit);
            holder.imgDelete         = (ImageView)view.findViewById(R.id.imageviewDelete);
            holder.rltpick           = (RelativeLayout) view.findViewById(R.id.pickitem);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        final Room room = roomList.get(i);

        holder.txtMaPhong.setText("Mã phòng: "+ room.getMaPhong());
        holder.txtLoaiPhong.setText("Loại phòng: " + room.getLoaiPhong());
        holder.txtTang.setText("Tầng: "+ room.getTang());
        holder.txtGiaPhong.setText("Giá phòng: " + room.getGiaPhong());

        // bắt sự kiện xóa và sửa và book

        holder.rltpick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Book_Room.class);
                intent.putExtra("dataRoom", room);
                context.startActivity(intent);
            }
        });

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateRoom.class);
                intent.putExtra("dataRoom", room);
                context.startActivity(intent);
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XacNhanXoa(room.getLoaiPhong(), room.getMaPhong());
            }
        });

        return view;
    }

    private void XacNhanXoa(String loai, final String maphong ){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(context);
        dialogXoa.setMessage("Bạn có muốn xóa phòng " + loai + " không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                context.DeleteKhoa(maphong);
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

            }
        });
        dialogXoa.show();
    }
}

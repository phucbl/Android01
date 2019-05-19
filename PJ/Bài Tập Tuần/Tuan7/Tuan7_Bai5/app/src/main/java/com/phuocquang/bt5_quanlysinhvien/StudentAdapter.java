package com.phuocquang.bt5_quanlysinhvien;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student> {

    Context context;
    int layout;
    ArrayList<Student> arrayList;

    public StudentAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Student> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.arrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =LayoutInflater.from(context);
        convertView = inflater.inflate(layout,null);
        ImageView img =(ImageView)convertView.findViewById(R.id.image);
        TextView txt1 = (TextView)convertView.findViewById(R.id.txtName);
        TextView txt2 = (TextView)convertView.findViewById(R.id.txtAddress);
        if(arrayList.get(position).getGender() == 1) {
            img.setImageResource(R.drawable.male);
        }
        else {
            img.setImageResource(R.drawable.female);
        }
        txt1.setText(arrayList.get(position).getName());
        txt2.setText(arrayList.get(position).getAddress());
        return convertView;
    }
}

package com.ntnt.bai2tuan7;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
/**
 * class dùng để custom layout
 * dùng chung cho hiển thị Sách và Tác giả
 * @author drthanh
 *
 */
public class MySimpleArrayAdapter extends ArrayAdapter<InforData> {

    private Activity context;
    private int layout;
    private List<InforData>list;
    public MySimpleArrayAdapter(Context context, int textViewResourceId,
                                List<InforData> objects) {
        super(context, textViewResourceId, objects);
        // TODO Auto-generated constructor stub
        this.context=(Activity) context;
        this.layout=textViewResourceId;
        this.list=objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater flater=context.getLayoutInflater();
        View row=flater.inflate(layout, parent,false);
        TextView txt1=(TextView) row.findViewById(R.id.textView1);
        TextView txt2=(TextView) row.findViewById(R.id.textView2);
        TextView txt3=(TextView) row.findViewById(R.id.textView3);
		/*txt1.setTextAlignment(Gravity.LEFT);
		txt2.setTextAlignment(Gravity.LEFT);
		txt3.setTextAlignment(Gravity.LEFT);*/
        InforData data=list.get(position);
        txt1.setText(data.getField1()==null?"":data.getField1().toString());
        txt2.setText(data.getField2()==null?"":data.getField2().toString());
        txt3.setText(data.getField3()==null?"":data.getField3().toString());
        if(position==0)
        {
            row.setBackgroundColor(Color.RED);
        }
        return row;
    }
}



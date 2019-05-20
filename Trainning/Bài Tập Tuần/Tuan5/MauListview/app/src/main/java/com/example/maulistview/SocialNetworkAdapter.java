package com.example.maulistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SocialNetworkAdapter extends ArrayAdapter<SocialNetwork> {
    Context context;
    int layoutResourceId;
    ArrayList<SocialNetwork> data = null;

    public SocialNetworkAdapter(Context context, int layoutResourceId, ArrayList<SocialNetwork> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        SocialNetworkHolder holder = null;
        if (row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId,parent, false);
            holder = new SocialNetworkHolder();
            holder.imIcon = row.findViewById(R.id.imgIcon);
            holder.txtTitle = row.findViewById(R.id.txtTitle);

            row.setTag(holder);
        }
        else
            holder = (SocialNetworkHolder)row.getTag();
        SocialNetwork item = data.get(position);
        holder.txtTitle.setText(item.title);
        holder.imIcon.setImageResource(item.icon);
        return  row;

    }
    static class SocialNetworkHolder{
        ImageView imIcon;
        TextView txtTitle;
    }
}



package com.phuocquang.country.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.phuocquang.country.R;
import com.phuocquang.country.model.Country;

import java.util.ArrayList;



public class CustomAdapter extends ArrayAdapter<Country> {
    private Context context;
    private int resource;
    private ArrayList<Country> arrCountry;

    public CustomAdapter(Context context, int resource, ArrayList<Country> object) {
        super(context, resource, object);
        this.context = context;
        this.resource = resource;
        this.arrCountry = object;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.row_item, parent,false);

            viewHolder = new ViewHolder();
            viewHolder.tv_Image = (ImageView) convertView.findViewById(R.id.tv_image);
            viewHolder.tv_Name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tv_Population= (TextView) convertView.findViewById(R.id.tv_population);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }



        Country country = arrCountry.get(position);

        viewHolder.tv_Image.setImageResource(country.getUrlImage());
        viewHolder.tv_Name.setText(country.getmCountry());
        viewHolder.tv_Population.setText(country.getmPopulation());
        return convertView;
    }

    public class ViewHolder{
        TextView tv_Name;
        TextView tv_Population;
        ImageView tv_Image;
    }
}

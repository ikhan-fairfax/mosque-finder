package com.example.scratch;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by imrank on 4/01/2014.
 */
public class CustomListViewAdapter extends ArrayAdapter<Mosque> {
    private final Activity context;
    private final List<Mosque> mosqueList;

    public CustomListViewAdapter(Activity context, List<Mosque> mosqueList) {
        super(context, R.layout.list_item, mosqueList);
        this.context = context;
        this.mosqueList = mosqueList;
    }

    public Mosque getItem(int position) {
        return mosqueList.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater layoutInflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item, null);

            holder = new ViewHolder();
            holder.textBrand = (TextView) convertView.findViewById(R.id.brand);
            holder.textModel = (TextView) convertView.findViewById(R.id.model);
            holder.textPrice = (TextView) convertView.findViewById(R.id.price);
            holder.imageView = (ImageView) convertView.findViewById(R.id.thumbnail);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Mosque mosque = getItem(position);

        holder.textPrice.setText(mosque.getCoordinates());
        holder.textModel.setText(mosque.getName());
        holder.textPrice.setText(mosque.getAddress());
//        holder.imageView.setImageBitmap(mosque.getImageBitmap());
        return convertView;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView textBrand;
        TextView textModel;
        TextView textPrice;
    }
}

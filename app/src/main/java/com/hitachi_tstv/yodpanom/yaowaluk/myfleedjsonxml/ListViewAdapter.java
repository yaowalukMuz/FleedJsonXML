package com.hitachi_tstv.yodpanom.yaowaluk.myfleedjsonxml;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Yaowaluk on 31/08/2560.
 */

public class ListViewAdapter extends BaseAdapter {

    public  Context mContext;
    public LayoutInflater mInflater;

    public ListViewAdapter(Context context) {
        mContext  = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder = null;


        if(convertView == null){
// load layout
            convertView = mInflater.inflate(R.layout.item_listview_org,null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.item_listview_title);
            holder.description = (TextView) convertView.findViewById(R.id.item_listview_desc);
            holder.authorImage = (ImageView) convertView.findViewById(R.id.item_listview_authorIcon);
            holder.youtubeThumbnail = (ImageView) convertView.findViewById(R.id.item_listview_youtube_image);
            convertView.setTag(holder);

        }else{

            //restoration
            holder = (ViewHolder) convertView.getTag();
        }
holder.title.setText("HITACHI:::"+ String.valueOf(position));
        return convertView;
    }

    public class  ViewHolder{
        TextView title;
        ImageView authorImage;
        ImageView youtubeThumbnail;
        TextView description;

    }
}

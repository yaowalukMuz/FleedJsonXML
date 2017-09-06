package com.hitachi_tstv.yodpanom.yaowaluk.myfleedjsonxml;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeIntents;
import com.hitachi_tstv.yodpanom.yaowaluk.util.CMXmlJsonConvertor;
import com.hitachi_tstv.yodpanom.yaowaluk.util.CircleTransform;

import java.util.ArrayList;
//import com.hitachi_tstv.yodpanom.yaowaluk.util.CircleTransform;

/**
 * Created by Yaowaluk on 31/08/2560.
 */

public class ListViewAdapter extends BaseAdapter {
    private String youtubeID;
    private String title;
    private String desc;
    private String youtubeImageURL;
    private String authorImageURL;
    public  Context mContext;
    public LayoutInflater mInflater;
    public ArrayList<Object> feedDataList;

    public ListViewAdapter(Context context,ArrayList<Object> _feedDataList) {
        mContext  = context;
        feedDataList = _feedDataList;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return feedDataList.size();
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
//    public View getView(int position, View convertView, ViewGroup parent) {
//       ViewHolder holder = null;
//
//
//        if(convertView == null){
//// load layout
//            convertView = mInflater.inflate(R.layout.item_listview_org,null);
//            holder = new ViewHolder();
//            holder.title = (TextView) convertView.findViewById(R.id.item_listview_title);
//            holder.description = (TextView) convertView.findViewById(R.id.item_listview_desc);
//            //authorImageURL = convertView.getValue(feedDataList.get(position), "image_link");
//            holder.authorImage = (ImageView) convertView.findViewById(R.id.item_listview_authorIcon);
//            holder.youtubeThumbnail = (ImageView) convertView.findViewById(R.id.item_listview_youtube_image);
//            convertView.setTag(holder);
//
//        }else{
//
//            //restoration
//            holder = (ViewHolder) convertView.getTag();
//        }
//
//        holder.title.setText("HITACHI:::"+ String.valueOf(position));
//
//        //syn img from server
//        String url  = "http://ww1.prweb.com/prfiles/2014/04/10/11752526/gI_134971_best-image-web-hosting.png";
//
//        // load img default before load image success
//
//       //  (R.drawable.cmdev_logo).into(holder.authorImage);
//
//        Glide.with(mContext).load(url).into(holder.authorImage);
//        Glide.with(mContext)
//        .load(url)
//                .placeholder(R.drawable.cmdev_logo)
//                .transform(new CircleTransform(mContext))
//        .into(holder.authorImage);
//
//        return convertView;
//    }

//    public View getView(final int position, View convertView, ViewGroup parent) {
//        ViewHolder holder;
//
//        if (convertView == null) {
//            convertView = mInflater.inflate(R.layout.item_listview, null);
//            holder = new ViewHolder();
//            holder.title = (TextView) convertView.findViewById(R.id.item_listview_title);
//            holder.description = (TextView) convertView.findViewById(R.id.item_listview_desc);
//            holder.youtubeThumbnail = (ImageView) convertView.findViewById(R.id.item_listview_youtube_image);
//            holder.authorImage = (ImageView) convertView.findViewById(R.id.item_listview_authorIcon);
//
//            holder.youtubeThumbnail.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    final String youtubeID = v.getTag(R.id.item_listview_youtube_image).toString();
//                    Intent intent = YouTubeIntents.createPlayVideoIntentWithOptions(mContext, youtubeID, true, false);
//                    mContext.startActivity(intent);
//                }
//            });
//
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//
//
//        title = CMXmlJsonConvertor.getValue(feedDataList.get(position), "title");
//        desc = CMXmlJsonConvertor.getValue(feedDataList.get(position), "description");
//        authorImageURL = CMXmlJsonConvertor.getValue(feedDataList.get(position), "image_link");
//        youtubeID = CMXmlJsonConvertor.getValue(feedDataList.get(position), "youtubeID");
//        youtubeImageURL = CMXmlJsonConvertor.getValue(feedDataList.get(position), "youtube_image");
//
//        holder.title.setText(title);
//        holder.description.setText(desc);
//
//        Glide.with(mContext).load(authorImageURL).bitmapTransform(new CircleTransform(mContext)).into(holder.authorImage);
//        Glide.with(mContext).load(youtubeImageURL).into(holder.youtubeThumbnail);
//
//        holder.youtubeThumbnail.setTag(R.id.item_listview_youtube_image,youtubeID);
//
//        return convertView;
//    }


    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_listview, null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.item_listview_title);
            holder.description = (TextView) convertView.findViewById(R.id.item_listview_desc);
            holder.youtubeThumbnail = (ImageView) convertView.findViewById(R.id.item_listview_youtube_image);
            holder.authorImage = (ImageView) convertView.findViewById(R.id.item_listview_authorIcon);


            //click list  view
            holder.youtubeThumbnail.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    final String youtubeID = v.getTag(R.id.item_listview_youtube_image).toString();
                    Intent intent = YouTubeIntents.createPlayVideoIntentWithOptions(mContext, youtubeID, true, false);
                    mContext.startActivity(intent);
                }
            });

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        title = CMXmlJsonConvertor.getValue(feedDataList.get(position), "title");
        desc = CMXmlJsonConvertor.getValue(feedDataList.get(position), "description");
        authorImageURL = CMXmlJsonConvertor.getValue(feedDataList.get(position), "image_link");
        youtubeID = CMXmlJsonConvertor.getValue(feedDataList.get(position), "youtubeID");
        youtubeImageURL = CMXmlJsonConvertor.getValue(feedDataList.get(position), "youtube_image");

        holder.title.setText(title);
        holder.description.setText(desc);

        Glide.with(mContext).load(authorImageURL).bitmapTransform(new CircleTransform(mContext)).into(holder.authorImage);
        Glide.with(mContext).load(youtubeImageURL).into(holder.youtubeThumbnail);

        holder.youtubeThumbnail.setTag(R.id.item_listview_youtube_image,youtubeID);

        return convertView;
    }
    public class  ViewHolder{
        TextView title;
        ImageView authorImage;
        ImageView youtubeThumbnail;
        TextView description;

    }
}

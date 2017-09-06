package com.hitachi_tstv.yodpanom.yaowaluk.myfleedjsonxml;


import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hitachi_tstv.yodpanom.yaowaluk.util.BlurUtil;
import com.hitachi_tstv.yodpanom.yaowaluk.util.CMFeedJsonUtil;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedJsonFragment extends Fragment {

    public static ArrayList<Object> feedDataList;
    private ImageView mBlurredImage;
    private ImageView mNormalImage;
    private TextView headerView;
    private ListView mListView;
    private ContentValues value;

    public FeedJsonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // View v = inflater.inflate(R.layout.fragment_feed_json, container, false);
       // mListView = (ListView) v.findViewById(R.id.listview2);
       // FleetData();
       // return v;

        View v = inflater.inflate(R.layout.fragment_feed_json, container, false);
        mListView = (ListView) v.findViewById(R.id.listview);
//        mBlurredImage = (ImageView) v.findViewById(R.id.blurred_image);
//        mNormalImage = (ImageView) v.findViewById(R.id.normal_image);
        new FeedAsynTask().execute("http://codemobiles.com/adhoc/feed/youtube_feed.php");

        return v;

    }

    private void FleetData() {
        //mListView.setAdapter(new ListViewAdapter(getActivity()));
        new FeedAsynTask().execute("55555");
    }

    public class FeedAsynTask extends AsyncTask<String, Void, ArrayList<Object>> {

        @Override
        protected ArrayList<Object> doInBackground(String... params) {
            // json feed
            // final String _url = "http://codemobiles.com/adhoc/youtube_feed.php?type=json";

            // assign post data
            RequestBody postData = new FormEncodingBuilder()
                    .add("type", "json")
                    .build();

            ArrayList<Object> feedDataList = CMFeedJsonUtil.feed(params[0], postData);
            Log.d("Tag", feedDataList.toString());
            return feedDataList;
        }

        @Override
        protected void onPostExecute(ArrayList<Object> result) {
            super.onPostExecute(result);

            try {
                if (headerView == null) {
                    headerView = new TextView(getActivity());
                    final int TOP_MARGIN = (int) getActivity().getResources().getDimension(R.dimen.listview_header_height);
                    headerView.setHeight(TOP_MARGIN);
                    Log.d("Tag", headerView.getText().toString());
                    Log.d("Tag", mListView.toString());
                    mListView.addHeaderView(headerView);
                }
            } catch (Exception e) {
                Log.d("Tag", "Error " + e + " Line " + e.getStackTrace()[0].getLineNumber());
            }

            if (result != null) {
                mListView.setAdapter(new ListViewAdapter(getActivity(), new ArrayList<Object>(result)));
            }

           // BlurUtil.setupBlurEffect(getActivity(), mListView, R.drawable.bg, headerView, mNormalImage, mBlurredImage);
        }
    }

}

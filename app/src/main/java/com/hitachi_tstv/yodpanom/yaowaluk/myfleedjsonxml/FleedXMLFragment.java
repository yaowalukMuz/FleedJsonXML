package com.hitachi_tstv.yodpanom.yaowaluk.myfleedjsonxml;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.hitachi_tstv.yodpanom.yaowaluk.util.CMFeedXmlUtil;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FleedXMLFragment extends Fragment {
    private ListView dataListView;

    public FleedXMLFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fleed_xml, container, false);
        dataListView = (ListView) view.findViewById(R.id.listview);

       // feedData();
        new FeedAsyncTask().execute("http://codemobiles.com/adhoc/feed/youtube_feed.php");
        return view;
    }

//    private void feedData() {
//        //set data tolistview adapter
//       // dataListView.setAdapter(new ListViewAdapter(getActivity()));
//        new FeedAsyncTask().execute("55555");
//    }

    public class FeedAsyncTask extends AsyncTask<String, Void, ArrayList<Object>> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Toast.makeText(getActivity(),"Connecting...",Toast.LENGTH_LONG).show();
            Log.i("Tag","onPreExecute()");
            }

//            @Override
//            protected ArrayList<Object>  doInBackground(String... params) {
//                Log.i("Tag","doInBackground()"+ params[0]);
//                final  String _url = "http://codemobiles.com/adhoc/feed/youube_feed.php?type=xml";
//                try{
//                    OkHttpClient client = new OkHttpClient();
//                    Request request = new Request.Builder().url(_url).build();
//                    Response response = client.newCall(request).execute();
                   // Log.i("Tag",response.body().string());


//                    RequestBody postData = new FormEncodingBuilder()
//                            .add("type", "xml")
//                            .build();
//
//                    ArrayList<Object> feedDataList = CMFeedXmlUtil.feed(params[0], "youtube_item", postData);
//                    return feedDataList;

                    @Override
                    protected ArrayList<Object> doInBackground(String... params) {
                        // json feed
                        // final String _url = "http://codemobiles.com/adhoc/youtube_feed.php?type=xml";

                        // assign post data
                        RequestBody postData = new FormEncodingBuilder()
                                .add("type", "xml")
                                .build();

                        ArrayList<Object> feedDataList = CMFeedXmlUtil.feed(params[0], "youtube_item", postData);
                        return feedDataList;

//                }catch (Exception e) {
//                  Log.i("TAG", "__"+ e.getStackTrace());
//                }

//                return null;

            }

            @Override
            protected void onPostExecute(ArrayList<Object> result) {
                super.onPostExecute(result);
                if (result != null) {
                    dataListView.setAdapter(new ListViewAdapter(getActivity(), new ArrayList<Object>(result)));
                }

            }
        }



}

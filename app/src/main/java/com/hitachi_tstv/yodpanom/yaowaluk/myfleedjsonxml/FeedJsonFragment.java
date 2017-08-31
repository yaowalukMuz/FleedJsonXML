package com.hitachi_tstv.yodpanom.yaowaluk.myfleedjsonxml;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedJsonFragment extends Fragment {
    private ListView mListView;


    public FeedJsonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_feed_json, container, false);
        mListView = (ListView) v.findViewById(R.id.listview2);
        FleetData();
        return v;
    }

    private void FleetData() {
        mListView.setAdapter(new ListViewAdapter(getActivity()));

    }

}

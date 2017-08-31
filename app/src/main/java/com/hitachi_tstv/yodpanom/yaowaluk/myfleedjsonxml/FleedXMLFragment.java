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

        feedData();
        return view;
    }

    private void feedData() {
        //set data tolistview adapter
        dataListView.setAdapter(new ListViewAdapter(getActivity()));

    }

}

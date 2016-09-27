package com.winer.watchhouse.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.winer.watchhouse.R;
import com.winer.watchhouse.adapter.HouseAdapter;
import com.winer.watchhouse.view.pullview.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 全景看房
 */
public class PanoramicFragment extends BaseFragment {
    @BindView(R.id.gv_house)
    PullToRefreshGridView gvHouse;

    private HouseAdapter adapter;

    public PanoramicFragment() {
        // Required empty public constructor
    }


    public static PanoramicFragment newInstance() {
        PanoramicFragment fragment = new PanoramicFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_panoramic, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        List<String> list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        adapter=new HouseAdapter(getContext(),list);
        gvHouse.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}

package com.winer.watchhouse.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.winer.watchhouse.EstateActivity;
import com.winer.watchhouse.HouseTypeActivity;
import com.winer.watchhouse.MainActivity;
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
public class PanoramicFragment extends BaseFragment implements AdapterView.OnItemClickListener{
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
        gvHouse.setOnItemClickListener(this);
        gvHouse.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ((MainActivity)getActivity()).goPage(EstateActivity.class);
    }
}

package com.winer.watchhouse.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;

import com.winer.watchhouse.R;
import com.winer.watchhouse.adapter.HouseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 楼盘简介
 * Created by guugangzhu on 2016/9/28.
 */

public class EstateInfoFragment extends BaseFragment {

    @BindView(R.id.id_stickynavlayout_innerscrollview)
    ScrollView lvInfo;

    public static EstateInfoFragment newInstance() {
        EstateInfoFragment fragment = new EstateInfoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estate_info, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }


    @Override
    public void initView(View view) {
        List<String> list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        HouseAdapter  adapter=new HouseAdapter(getContext(),list);
        View header=getLayoutInflater(null).inflate(R.layout.layout_house_info_header,null);
//        lvInfo.addHeaderView(header);
//        lvInfo.setAdapter(adapter);
    }
}

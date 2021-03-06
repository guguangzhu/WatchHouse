package com.toda.yjkf.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.toda.yjkf.R;
import com.toda.yjkf.adapter.HouseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guugangzhu on 2016/9/28.
 */

public class HouseTypeInfoFragment extends BaseFragment {

    @BindView(R.id.id_stickynavlayout_innerscrollview)
    ListView lvInfo;

    public static HouseTypeInfoFragment newInstance() {
        HouseTypeInfoFragment fragment = new HouseTypeInfoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_house_info, container, false);
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
        lvInfo.addHeaderView(header);
        lvInfo.setAdapter(adapter);
    }
}

package com.winer.watchhouse.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.winer.watchhouse.R;
import com.winer.watchhouse.adapter.HouseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guugangzhu on 2016/9/28.
 */

public class HouseTypeInfoFragment extends BaseFragment {


    @BindView(R.id.tv_house_info)
    TextView tvHouseInfo;
    @BindView(R.id.lv_info)
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
        lvInfo.setAdapter(adapter);
    }
}

package com.toda.yjkf.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.toda.yjkf.R;
import com.toda.yjkf.adapter.EstateTypeAdapter;
import com.toda.yjkf.view.NoScrollGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 楼盘周边
 * Created by guugangzhu on 2016/9/28.
 */

public class EstatePanoramicFragment extends BaseFragment {

    @BindView(R.id.id_stickynavlayout_innerscrollview)
    ScrollView lvInfo;
    @BindView(R.id.gv_outer_scene)
    NoScrollGridView gvOuterScene;
    @BindView(R.id.gv_inner_scene)
    NoScrollGridView gvInnerScene;

    public static EstatePanoramicFragment newInstance() {
        EstatePanoramicFragment fragment = new EstatePanoramicFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estate_panoramic, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }


    @Override
    public void initView(View view) {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        EstateTypeAdapter adapter = new EstateTypeAdapter(getContext(), list);
//        lvInfo.addHeaderView(header);
        gvOuterScene.setAdapter(adapter);
        gvInnerScene.setAdapter(adapter);
    }
}

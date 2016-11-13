package com.toda.yjkf.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.toda.yjkf.R;
import com.toda.yjkf.adapter.EstateTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 户型图片
 * Created by guugangzhu on 2016/9/28.
 */

public class HouseTypePicFragment extends BaseFragment {

    @BindView(R.id.id_stickynavlayout_innerscrollview)
    GridView lvPicture;

    public static HouseTypePicFragment newInstance() {
        HouseTypePicFragment fragment = new HouseTypePicFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_house_pic, container, false);
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
        list.add("");
        list.add("");
        EstateTypeAdapter adapter = new EstateTypeAdapter(getContext(), list);
        lvPicture.setAdapter(adapter);
    }
}

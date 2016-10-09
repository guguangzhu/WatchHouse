package com.winer.watchhouse.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.winer.watchhouse.HouseTypeActivity;
import com.winer.watchhouse.R;
import com.winer.watchhouse.adapter.EstateTypeAdapter;
import com.winer.watchhouse.adapter.HouseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 楼盘户型
 * Created by guugangzhu on 2016/9/28.
 */

public class EstateTypeFragment extends BaseFragment implements AdapterView.OnItemClickListener{


    @BindView(R.id.id_stickynavlayout_innerscrollview)
    GridView lvPicture;

    public static EstateTypeFragment newInstance() {
        EstateTypeFragment fragment = new EstateTypeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estate_type, container, false);
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
        lvPicture.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        getActivity().startActivity(new Intent(getActivity(), HouseTypeActivity.class));
    }
}

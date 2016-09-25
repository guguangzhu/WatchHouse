package com.winer.watchhouse.fragment;


import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.winer.watchhouse.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 首页地图
 */
public class HomeMapFragment extends Fragment {

    public static final int TYPE_NEW = 0;  //新房
    public static final int TYPE_OLD = 1;  //二手房

    @BindView(R.id.tv_tab_new)
    TextView tvTabNew;
    @BindView(R.id.tv_tab_old)
    TextView tvTabOld;
    @BindView(R.id.map)
    MapView mapView;

    private AMap aMap;

    public HomeMapFragment() {
        // Required empty public constructor
    }


    public static HomeMapFragment newInstance() {
        HomeMapFragment fragment = new HomeMapFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initView(view,savedInstanceState);
        return view;
    }

    private void initView( View mapLayout , Bundle savedInstanceState) {
        mapView.onCreate(savedInstanceState);//必须写

        if (aMap == null) {
            aMap = mapView.getMap();

        } else {
            if (mapLayout.getParent() != null) {
                ((ViewGroup) mapLayout.getParent()).removeView(mapLayout);
            }
        }
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();

    }

    /**
     * 方法必须重写
     * map的生命周期方法
     */
    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();

    }

    /**
     * 方法必须重写
     * map的生命周期方法
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     * map的生命周期方法
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @OnClick({R.id.tv_tab_new, R.id.tv_tab_old})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_tab_new:
                changeTab(TYPE_NEW);
                break;
            case R.id.tv_tab_old:
                changeTab(TYPE_OLD);
                break;
        }
    }


    private void changeTab(int index) {   //0   持有中   1 已完成
        switch (index) {
            case 0: {
                tvTabNew.setTextColor(getResources().getColor(R.color.white));
                tvTabNew.setBackgroundResource(R.drawable.bg_left_oval_blue);
                tvTabOld.setTextColor(getResources().getColor(R.color.main_color));
                tvTabOld.setBackgroundResource(R.drawable.bg_right_oval_white_with_blue_stroke);
                break;
            }
            case 1: {
                tvTabNew.setTextColor(getResources().getColor(R.color.main_color));
                tvTabNew.setBackgroundResource(R.drawable.bg_left_oval_white_with_blue_stroke);
                tvTabOld.setTextColor(getResources().getColor(R.color.white));
                tvTabOld.setBackgroundResource(R.drawable.bg_right_oval_blue);
                break;
            }
        }
    }
}

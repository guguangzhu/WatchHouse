package com.toda.yjkf.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.toda.yjkf.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 首页地图
 */
public class HomeMapFragment extends BaseFragment implements LocationSource,
        AMapLocationListener {

    public static final int TYPE_NEW = 0;  //新房
    public static final int TYPE_OLD = 1;  //二手房

    @BindView(R.id.tv_tab_new)
    TextView tvTabNew;
    @BindView(R.id.tv_tab_old)
    TextView tvTabOld;
    @BindView(R.id.map)
    MapView mapView;

    private AMap aMap;

    private OnLocationChangedListener mListener;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private RadioGroup mGPSModeGroup;

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
            setUpMap();
        } else {
            if (mapLayout.getParent() != null) {
                ((ViewGroup) mapLayout.getParent()).removeView(mapLayout);
            }
        }
    }


    /**
     * 设置一些amap的属性
     */
    private void setUpMap() {
        aMap.setLocationSource(this);// 设置定位监听
        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
        aMap.setMyLocationEnabled(true);// 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        // 设置定位的类型为定位模式 ，可以由定位、跟随或地图根据面向方向旋转几种
        aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);
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
        if(null != mlocationClient){
            mlocationClient.onDestroy();
        }
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


    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (mListener != null && amapLocation != null) {
            if (amapLocation != null
                    && amapLocation.getErrorCode() == 0) {
                mListener.onLocationChanged(amapLocation);// 显示系统小蓝点
            } else {
                String errText = "定位失败," + amapLocation.getErrorCode()+ ": " + amapLocation.getErrorInfo();
                Log.e("AmapErr",errText);

            }
        }
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
        if (mlocationClient == null) {
            mlocationClient = new AMapLocationClient(getContext());
            mLocationOption = new AMapLocationClientOption();
            //设置定位监听
            mlocationClient.setLocationListener(this);
            //设置为高精度定位模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位参数
            mlocationClient.setLocationOption(mLocationOption);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用onDestroy()方法
            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
            mlocationClient.startLocation();
        }
    }

    @Override
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }

    @Override
    public void initView(View view) {

    }
}

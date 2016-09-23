package com.winer.watchhouse;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    public static final int TYPE_NEW = 0;  //新房
    public static final int TYPE_OLD = 1;  //二手房

    @BindView(R.id.tv_tab_new)
    TextView tvTabNew;
    @BindView(R.id.tv_tab_old)
    TextView tvTabOld;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    private MapView mapView;
    private AMap aMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        mapView = (MapView) findViewById(R.id.map);
//        mapView.onCreate(savedInstanceState);// 此方法必须重写
//
//        init();
    }

    /**
     * 初始化AMap对象
     */
    private void init() {
        if (aMap == null) {
            aMap = mapView.getMap();


        }
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
//        mapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
//        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mapView.onDestroy();
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

    private void changeTab(int index){   //0   持有中   1 已完成
        switch (index){
            case 0:{
                tvTabNew.setTextColor(getResources().getColor(R.color.white));
                tvTabNew.setBackgroundResource(R.drawable.bg_left_oval_blue);
                tvTabOld.setTextColor(getResources().getColor(R.color.main_color));
                tvTabOld.setBackgroundResource(R.drawable.bg_right_oval_white_with_blue_stroke);
                break;
            }
            case 1:{
                tvTabNew.setTextColor(getResources().getColor(R.color.main_color));
                tvTabNew.setBackgroundResource(R.drawable.bg_left_oval_white_with_blue_stroke);
                tvTabOld.setTextColor(getResources().getColor(R.color.white));
                tvTabOld.setBackgroundResource(R.drawable.bg_right_oval_blue);
                break;
            }
        }
    }
}

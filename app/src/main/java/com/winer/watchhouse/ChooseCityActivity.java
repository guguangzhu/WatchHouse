package com.winer.watchhouse;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.LocationSource;
import com.winer.watchhouse.adapter.CityAdapter;
import com.winer.watchhouse.view.NoScrollListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChooseCityActivity extends BaseActivity implements AMapLocationListener {

    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.lv_cites)
    NoScrollListView lvCites;
    @BindView(R.id.activity_choose_city)
    ScrollView activityChooseCity;

    private LocationSource.OnLocationChangedListener mListener;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;

    private CityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_city);
        ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        List<String> list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        adapter=new CityAdapter(this,list);
        lvCites.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        activate();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        deactivate();
    }

    public void activate() {
        if (mlocationClient == null) {
            mlocationClient = new AMapLocationClient(this);
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


    /**
     * 停止定位
     */
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }


    @Override
    public void onLocationChanged(AMapLocation amapLocation) {

        if (amapLocation != null
                && amapLocation.getErrorCode() == 0) {
//                mListener.onLocationChanged(amapLocation);// 显示系统小蓝点
            tvCity.setText(amapLocation.getCity());

        } else {
            String errText = "定位失败," + amapLocation.getErrorCode() + ": " + amapLocation.getErrorInfo();
            Log.e("AmapErr", errText);
            toast(errText);
//                mLocationErrText.setVisibility(View.VISIBLE);
//                mLocationErrText.setText(errText);
        }

    }

    @OnClick(R.id.tv_city)
    public void onClick() {
        Intent intent = new Intent();
        intent.putExtra(KEY_LOCATION,tvCity.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}

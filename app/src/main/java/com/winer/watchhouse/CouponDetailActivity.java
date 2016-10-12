package com.winer.watchhouse;

import android.os.Bundle;

/**
 * Created by guugangzhu on 2016/10/12.
 */

public class CouponDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_detail);

        initView();
    }

    @Override
    public void initView() {
        topBar.setTitleRightText("删除");
    }

    @Override
    public void onTopRightClick() {
    }
}

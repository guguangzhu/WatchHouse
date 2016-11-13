package com.toda.yjkf;

import android.os.Bundle;

/**
 * Created by guugangzhu on 2016/10/12.
 */

public class PacketDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packet_detail);

        initView();
    }

    @Override
    public void initView() {
        topBar.setTitleRightText("提现");
    }

    @Override
    public void onTopRightClick() {
        goPage(WithdrawalActivity.class);
    }
}

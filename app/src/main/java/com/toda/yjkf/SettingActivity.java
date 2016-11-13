package com.toda.yjkf;

import android.os.Bundle;

/**
 * Created by guugangzhu on 2016/10/17.
 */

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    @Override
    public void initView() {
        setTitle("设置");
    }
}

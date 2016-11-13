package com.toda.yjkf;

import android.os.Bundle;

/**
 * 修改地址
 * Created by guugangzhu on 2016/10/18.
 */

public class EditAddressActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_address);
        initView();
    }

    @Override
    public void initView() {
        setTitle("收件地址");
    }
}

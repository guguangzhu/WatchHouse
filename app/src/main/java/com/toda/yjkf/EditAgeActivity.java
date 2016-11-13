package com.toda.yjkf;

import android.os.Bundle;

/**
 * Created by guugangzhu on 2016/10/18.
 */

public class EditAgeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_age);
        initView();
    }

    @Override
    public void initView() {
        setTitle("年龄");
    }
}

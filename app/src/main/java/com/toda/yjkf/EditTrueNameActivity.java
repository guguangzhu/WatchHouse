package com.toda.yjkf;

import android.os.Bundle;

/**
 * Created by guugangzhu on 2016/10/18.
 */

public class EditTrueNameActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_true_name);
        initView();
    }

    @Override
    public void initView() {
        setTitle("真实姓名");
    }
}

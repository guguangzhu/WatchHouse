package com.winer.watchhouse;

import android.os.Bundle;

/**
 * Created by guugangzhu on 2016/10/18.
 */

public class EditIdentityActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_identity);
        initView();
    }

    @Override
    public void initView() {
        setTitle("身份证号");
    }
}

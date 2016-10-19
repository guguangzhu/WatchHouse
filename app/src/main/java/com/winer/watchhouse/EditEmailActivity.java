package com.winer.watchhouse;

import android.os.Bundle;

/**
 * Created by guugangzhu on 2016/10/18.
 */

public class EditEmailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_email);
        initView();
    }

    @Override
    public void initView() {
        setTitle("邮箱");
    }
}

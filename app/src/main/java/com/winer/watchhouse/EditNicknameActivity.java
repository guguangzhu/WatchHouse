package com.winer.watchhouse;

import android.os.Bundle;

/**
 * Created by guugangzhu on 2016/10/18.
 */

public class EditNicknameActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_nickname);
        initView();
    }

    @Override
    public void initView() {
        setTitle("用户名");
    }
}

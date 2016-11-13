package com.toda.yjkf;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by guugangzhu on 2016/10/18.
 */

public class ChangeMarriageStatusActivity extends BaseActivity {

    @BindView(R.id.iv_not_married)
    ImageView ivNotMarried;
    @BindView(R.id.ll_not_married)
    LinearLayout llNotMarried;
    @BindView(R.id.iv_married)
    ImageView ivMarried;
    @BindView(R.id.ll_married)
    LinearLayout llMarried;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_marriage);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        setTitle("常住城市");
    }

    @OnClick({R.id.ll_not_married, R.id.ll_married})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_not_married:
                ivNotMarried.setVisibility(View.VISIBLE);
                llMarried.setVisibility(View.INVISIBLE);
                break;
            case R.id.ll_married:
                ivNotMarried.setVisibility(View.INVISIBLE);
                llMarried.setVisibility(View.VISIBLE);
                break;
        }
    }
}

package com.winer.watchhouse;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by guugangzhu on 2016/10/18.
 */

public class EditGenderActivity extends BaseActivity{


    @BindView(R.id.iv_gender_man)
    ImageView ivGenderMan;
    @BindView(R.id.ll_gender_man)
    LinearLayout llGenderMan;
    @BindView(R.id.iv_gender_woman)
    ImageView ivGenderWoman;
    @BindView(R.id.ll_gender_woman)
    LinearLayout llGenderWoman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_gender);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        setTitle("性  别");
    }


    @OnClick({R.id.ll_gender_man, R.id.ll_gender_woman})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_gender_man:
                ivGenderMan.setVisibility(View.VISIBLE);
                ivGenderWoman.setVisibility(View.INVISIBLE);
                break;
            case R.id.ll_gender_woman:
                ivGenderMan.setVisibility(View.INVISIBLE);
                ivGenderWoman.setVisibility(View.VISIBLE);
                break;
        }
    }
}

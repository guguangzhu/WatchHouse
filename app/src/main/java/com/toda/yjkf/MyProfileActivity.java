package com.toda.yjkf;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by guugangzhu on 2016/10/12.
 */

public class MyProfileActivity extends BaseActivity {

    @BindView(R.id.lv_logo)
    ImageView lvLogo;
    @BindView(R.id.ll_my_logo)
    LinearLayout llMyLogo;
    @BindView(R.id.tv_nickname)
    TextView tvNickname;
    @BindView(R.id.ll_nickname)
    LinearLayout llNickname;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.ll_phone)
    LinearLayout llPhone;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.ll_email)
    LinearLayout llEmail;
    @BindView(R.id.tv_level)
    ImageView tvLevel;
    @BindView(R.id.ll_level)
    LinearLayout llLevel;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.tv_true_name)
    TextView tvTrueName;
    @BindView(R.id.ll_true_name)
    LinearLayout llTrueName;
    @BindView(R.id.tv_id_num)
    TextView tvIdNum;
    @BindView(R.id.ll_id_num)
    LinearLayout llIdNum;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.ll_sex)
    LinearLayout llSex;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.ll_age)
    LinearLayout llAge;
    @BindView(R.id.tv_live_city)
    TextView tvLiveCity;
    @BindView(R.id.ll_live_city)
    LinearLayout llLiveCity;
    @BindView(R.id.tv_marriage_status)
    TextView tvMarriageStatus;
    @BindView(R.id.ll_marriage_status)
    LinearLayout llMarriageStatus;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.ll_address)
    LinearLayout llAddress;
    @BindView(R.id.tv_weixin_bind)
    TextView tvWeixinBind;
    @BindView(R.id.ll_weixin_bind)
    LinearLayout llWeixinBind;
    @BindView(R.id.tv_weibo_bind)
    TextView tvWeiboBind;
    @BindView(R.id.ll_weibo_bind)
    LinearLayout llWeiboBind;
    @BindView(R.id.tv_qq_bind)
    TextView tvQqBind;
    @BindView(R.id.ll_qq_bind)
    LinearLayout llQqBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        ButterKnife.bind(this);

        initView();
    }

    @Override
    public void initView() {

    }

    @OnClick({R.id.ll_my_logo, R.id.ll_nickname, R.id.ll_phone, R.id.ll_email, R.id.ll_level, R.id.ll_true_name, R.id.ll_id_num,
            R.id.ll_sex, R.id.ll_age, R.id.ll_live_city, R.id.ll_marriage_status, R.id.ll_address, R.id.ll_weixin_bind, R.id.ll_weibo_bind, R.id.ll_qq_bind})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_my_logo:
                break;
            case R.id.ll_nickname: //用户名
                goPage(EditNicknameActivity.class);
                break;
            case R.id.ll_phone:
                goPage(EditPhoneActivity.class);
                break;
            case R.id.ll_email:
                goPage(EditEmailActivity.class);
                break;
            case R.id.ll_level:
                break;
            case R.id.ll_true_name:
                goPage(EditTrueNameActivity.class);
                break;
            case R.id.ll_id_num:
                goPage(EditIdentityActivity.class);
                break;
            case R.id.ll_sex:
                goPage(EditGenderActivity.class);
                break;
            case R.id.ll_age:
                goPage(EditAgeActivity.class);
                break;
            case R.id.ll_live_city:
                goPage(ChangeLivingCityActivity.class);
                break;
            case R.id.ll_marriage_status:
                goPage(ChangeMarriageStatusActivity.class);
                break;
            case R.id.ll_address:
                goPage(EditAddressActivity.class);
                break;
            case R.id.ll_weixin_bind:
                break;
            case R.id.ll_weibo_bind:
                break;
            case R.id.ll_qq_bind:
                break;
        }
    }
}

package com.winer.watchhouse;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by guugangzhu on 2016/9/27.
 */

public class UserCenterActivity extends BaseActivity {

    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.iv_sign_in)
    ImageView ivSignIn;
    @BindView(R.id.line1)
    View line1;
    @BindView(R.id.tv_my_info)
    TextView tvMyInfo;
    @BindView(R.id.tv_my_concern)
    TextView tvMyConcern;
    @BindView(R.id.tv_coupon)
    TextView tvCoupon;
    @BindView(R.id.tv_coupon_amount)
    TextView tvCouponAmount;
    @BindView(R.id.rl_coupon)
    RelativeLayout rlCoupon;
    @BindView(R.id.tv_red_packet)
    TextView tvRedPacket;
    @BindView(R.id.tv_remain)
    TextView tvRemain;
    @BindView(R.id.rl_red_packet)
    RelativeLayout rlRedPacket;
    @BindView(R.id.tv_gift)
    TextView tvGift;
    @BindView(R.id.tv_not_get)
    TextView tvNotGet;
    @BindView(R.id.rl_gift)
    RelativeLayout rlGift;
    @BindView(R.id.tv_point)
    TextView tvPoint;
    @BindView(R.id.tv_remain_point)
    TextView tvRemainPoint;
    @BindView(R.id.rl_points)
    RelativeLayout rlPoints;
    @BindView(R.id.tv_msg_count)
    TextView tvMsgCount;
    @BindView(R.id.ll_message)
    LinearLayout llMessage;
    @BindView(R.id.ll_my_subscription)
    LinearLayout llMySubscription;
    @BindView(R.id.ll_counselor)
    LinearLayout llCounselor;
    @BindView(R.id.ll_buy_house)
    LinearLayout llBuyHouse;
    @BindView(R.id.ll_points_store)
    LinearLayout llPointsStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        topBar.setTitleRightImg(R.mipmap.ic_setting);
    }

    @Override
    public void onTopRightClick() {
        goPage(SettingActivity.class);
    }

    @OnClick({R.id.iv_logo, R.id.iv_sign_in, R.id.tv_my_info, R.id.tv_my_concern, R.id.rl_coupon, R.id.rl_red_packet, R.id.rl_gift, R.id.rl_points,
            R.id.ll_message, R.id.ll_my_subscription, R.id.ll_counselor, R.id.ll_buy_house, R.id.ll_points_store})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_logo:
                break;
            case R.id.iv_sign_in:   //签到
                break;
            case R.id.tv_my_info:  //个人资料
                goPage(MyProfileActivity.class);
                break;
            case R.id.tv_my_concern:  //关注
                goPage(MyCollectionActivity.class);
                break;
            case R.id.rl_coupon: //优惠券
                goPage(MyCouponActivity.class);
                break;
            case R.id.rl_red_packet:  //红包
                goPage(RedPacketActivity.class);
                break;
            case R.id.rl_gift:  //礼品
                goPage(MyGiftActivity.class);
                break;
            case R.id.rl_points: //积分
                goPage(MyPointsActivity.class);
                break;
            case R.id.ll_message:
                break;
            case R.id.ll_my_subscription:
                break;
            case R.id.ll_counselor:
                break;
            case R.id.ll_buy_house:
                break;
            case R.id.ll_points_store:
                break;
        }
    }
}

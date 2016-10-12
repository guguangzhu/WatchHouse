package com.winer.watchhouse;

import android.os.Bundle;
import android.widget.ListView;

import com.winer.watchhouse.adapter.HouseAdapter;
import com.winer.watchhouse.adapter.RedPacketAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 优惠券
 */

public class MyCouponActivity extends BaseActivity {


    @BindView(R.id.lv_coupon)
    ListView lvCoupon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_coupon);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        setTitle("我的优惠券");
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        RedPacketAdapter adapter = new RedPacketAdapter(this, list);
        lvCoupon.setAdapter(adapter);
    }
}

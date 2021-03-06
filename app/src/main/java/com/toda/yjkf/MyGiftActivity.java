package com.toda.yjkf;

import android.os.Bundle;
import android.widget.ListView;

import com.toda.yjkf.adapter.RedPacketAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 礼品
 */

public class MyGiftActivity extends BaseActivity {

    @BindView(R.id.lv_red_packet)
    ListView lvRedPacket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_gift);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        setTitle("我的礼品");
        List<String> list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        RedPacketAdapter adapter=new RedPacketAdapter(this,list);
        lvRedPacket.setAdapter(adapter);
    }
}

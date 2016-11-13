package com.toda.yjkf;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.toda.yjkf.fragment.EstateInfoFragment;
import com.toda.yjkf.fragment.EstatePanoramicFragment;
import com.toda.yjkf.fragment.EstateSurroundingFragment;
import com.toda.yjkf.fragment.EstateTypeFragment;
import com.toda.yjkf.fragment.HouseTypePicFragment;
import com.toda.yjkf.view.SimpleViewPagerIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 楼盘详情
 * Created by guugangzhu on 2016/9/28.
 */

public class EstateActivity extends BaseActivity {

    @BindView(R.id.id_stickynavlayout_topview)
    RelativeLayout idStickynavlayoutTopview;
    @BindView(R.id.id_stickynavlayout_indicator)
    SimpleViewPagerIndicator idStickynavlayoutIndicator;
    @BindView(R.id.id_stickynavlayout_viewpager)
    ViewPager idStickynavlayoutViewpager;
    @BindView(R.id.ll_house_type_bottom)
    LinearLayout llHouseTypeBottom;
    @BindView(R.id.iv_title)
    ImageView ivTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_size)
    TextView tvSize;
    @BindView(R.id.calculator)
    ImageView calculator;
    @BindView(R.id.iv_red_packet)
    ImageView ivRedPacket;
    @BindView(R.id.rl_name)
    RelativeLayout rlName;
    @BindView(R.id.line1)
    View line1;

    private String[] mTitles = new String[]{"简介", "户型", "周边配套", "全景看房", "图片", "活动"};
    private FragmentPagerAdapter mAdapter;
    private Fragment[] mFragments = new Fragment[mTitles.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estate_detail);
        ButterKnife.bind(this);
        initView();
        initEvents();
        initDatas();
    }


    public void initView() {

    }

    private void initEvents() {
        idStickynavlayoutViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                idStickynavlayoutIndicator.scroll(position, positionOffset);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initDatas() {
        setTitle("万科 魅力之城");
        topBar.setRightSecondImg(R.mipmap.ic_heart);
        topBar.setTitleRightImg(R.mipmap.ic_share);
        idStickynavlayoutIndicator.setTitles(mTitles);

//        for (int i = 0; i < mTitles.length; i++)
//        {
//            mFragments[i] = HouseTypeInfoFragment.newInstance();
//        }
        mFragments[0] = EstateInfoFragment.newInstance();
        mFragments[1] = EstateTypeFragment.newInstance();
        mFragments[2] = EstateSurroundingFragment.newInstance();
        mFragments[3] = EstatePanoramicFragment.newInstance();
        mFragments[4] = HouseTypePicFragment.newInstance();
        mFragments[5] = HouseTypePicFragment.newInstance();

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }

        };

        idStickynavlayoutViewpager.setAdapter(mAdapter);
        idStickynavlayoutViewpager.setCurrentItem(0);
    }

    @OnClick({R.id.iv_title, R.id.calculator, R.id.iv_red_packet})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_title:
                goPage(PhotoViewActivity.class);
                break;
            case R.id.calculator:
                break;
            case R.id.iv_red_packet:
                break;
        }
    }
}

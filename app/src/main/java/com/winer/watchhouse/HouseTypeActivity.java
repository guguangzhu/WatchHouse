package com.winer.watchhouse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.winer.watchhouse.fragment.HouseTypeInfoFragment;
import com.winer.watchhouse.view.SimpleViewPagerIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 户型
 * Created by guugangzhu on 2016/9/28.
 */

public class HouseTypeActivity extends AppCompatActivity {

    @BindView(R.id.id_stickynavlayout_topview)
    RelativeLayout idStickynavlayoutTopview;
    @BindView(R.id.id_stickynavlayout_indicator)
    SimpleViewPagerIndicator idStickynavlayoutIndicator;
    @BindView(R.id.id_stickynavlayout_viewpager)
    ViewPager idStickynavlayoutViewpager;

    private String[] mTitles = new String[] { "简介", "全景看房", "图片" };
    private FragmentPagerAdapter mAdapter;
    private Fragment[] mFragments = new Fragment[mTitles.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_type);
        ButterKnife.bind(this);
        initView();
        initEvents();
        initDatas();
    }


    public void initView() {

    }

    private void initEvents()
    {
        idStickynavlayoutViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position)
            {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels)
            {
                idStickynavlayoutIndicator.scroll(position, positionOffset);
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });

    }

    private void initDatas()
    {
        idStickynavlayoutIndicator.setTitles(mTitles);

        for (int i = 0; i < mTitles.length; i++)
        {
            mFragments[i] = HouseTypeInfoFragment.newInstance();
        }

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager())
        {
            @Override
            public int getCount()
            {
                return mTitles.length;
            }

            @Override
            public Fragment getItem(int position)
            {
                return mFragments[position];
            }

        };

        idStickynavlayoutViewpager.setAdapter(mAdapter);
        idStickynavlayoutViewpager.setCurrentItem(0);
    }
}

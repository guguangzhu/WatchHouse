package com.winer.watchhouse;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.winer.watchhouse.fragment.CollectionFragment;
import com.winer.watchhouse.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guugangzhu on 2016/10/17. 我的收藏
 */

public class MyCollectionActivity extends BaseActivity implements ViewPager.OnPageChangeListener{


    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.view_pager_collection)
    ViewPager viewPagerCollection;

    private final String[] TITLE = new String[]{"楼盘", "户型","二手房"};
    private List<Fragment> mFragments = new ArrayList<>();
    private boolean isDelModel=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_collection);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        setTitle("我的收藏");
        setTopBarRightText("删除");
        tabs.setupWithViewPager(viewPagerCollection);
        mFragments.add(CollectionFragment.newInstance());
        mFragments.add(CollectionFragment.newInstance());
        mFragments.add(CollectionFragment.newInstance());
        viewPagerCollection.addOnPageChangeListener(this);
        viewPagerCollection.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
    }

    @Override
    public void onTopRightClick() {
        if(isDelModel){
            isDelModel=false;
            setTopBarRightText("删除");
            changeMode();
        }else {
            isDelModel=true;
            setTopBarRightText("取消");
            changeMode();
        }
    }

    private void changeMode(){
        CollectionFragment fragment= (CollectionFragment) mFragments.get( viewPagerCollection.getCurrentItem());
        fragment.changeMode(isDelModel);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        LogUtils.e("onPageSelected"+position);
        isDelModel=false;
        setTopBarRightText("删除");
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class MyFragmentAdapter extends FragmentPagerAdapter {
        FragmentManager fm;

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
            this.fm = fm;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE[position % TITLE.length];
        }

        @Override
        public int getCount() {
            return TITLE.length;
        }

        @Override
        public Fragment instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container,
                    position);
            fm.beginTransaction().show(fragment).commitAllowingStateLoss();
            return fragment;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // super.destroyItem(container, position, object);
            Fragment fragment = mFragments.get(position);
            fm.beginTransaction().hide(fragment).commitAllowingStateLoss();

        }

    }
}

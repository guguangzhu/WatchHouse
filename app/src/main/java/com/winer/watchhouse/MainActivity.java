package com.winer.watchhouse;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.winer.watchhouse.fragment.HomeMapFragment;
import com.winer.watchhouse.fragment.PanoramicFragment;
import com.winer.watchhouse.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    public static final int TYPE_NEW = 0;  //新房
    public static final int TYPE_OLD = 1;  //二手房

    private final int MAP = 0;  //地图
    private final int PANORAMIC = 1;  //全景看房

    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.view_pager_main)
    NoScrollViewPager viewPagerMain;

    private final String[] TITLE = new String[]{"全景看房"};
    @BindView(R.id.tv_house_type)
    TextView tvHouseType;
    private List<Fragment> mFragments = new ArrayList<>();
    private Fragment homeFragment, panoramicFragment;
    private Fragment currentFragment;
    private int currentPosition = MAP;
    private MyFragmentAdapter mAdapter;

    private int type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

//        clearFragment();

    }

    @Override
    public void onTopCenterClick() {
        if(tvHouseType.getVisibility()==View.VISIBLE){
            tvHouseType.setVisibility(View.GONE);
            topBar.getTitleView().setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_arrow_down, 0);
        }else{
            tvHouseType.setVisibility(View.VISIBLE);
            topBar.getTitleView().setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_arrow_up, 0);
        }


    }

    @Override
    public void onTopLeftClick() {

    }

    @Override
    public void onTopRightClick() {
        goPage(ChooseCityActivity.class, null, KEY_GETLOCATION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case KEY_GETLOCATION:
//                setTitle();
                if (resultCode == RESULT_OK) {
                    String city = data.getStringExtra(KEY_LOCATION);
                    setTopBarRightText(city);
                }
                break;
        }

    }

    public void initView() {
        setTitle("新房");
        topBar.setTitleRightText("北京");
        topBar.getTitleView().setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_arrow_down, 0);
//        topBar.setTitleLeftImg(R.mipmap.ic_launcher);
        viewPagerMain.setNoScroll(true);
//        mFragments.add(HomeMapFragment.newInstance());
        mFragments.add(PanoramicFragment.newInstance());
        mAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        viewPagerMain.setAdapter(mAdapter);
        tabs.setupWithViewPager(viewPagerMain);

        type=TYPE_NEW;
        tvHouseType.setText("二手房");

    }
    @OnClick(R.id.tv_house_type)
    public void onClick() {
        type=type==TYPE_NEW?TYPE_OLD:TYPE_NEW;
        tvHouseType.setVisibility(View.GONE);
        topBar.getTitleView().setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_arrow_down, 0);
        tvHouseType.setText(type==TYPE_NEW?"二手房":"新房");
        setTitle(type==TYPE_NEW?"新房":"二手房");
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(tvHouseType.getVisibility()==View.GONE)
            return super.dispatchTouchEvent(ev);
        Rect viewRect = new Rect();
        topBar.getTitleView().getGlobalVisibleRect(viewRect);
        if(viewRect.contains((int) ev.getRawX(), (int) ev.getRawY()))
            return super.dispatchTouchEvent(ev);
        tvHouseType.getGlobalVisibleRect(viewRect);
        if (!viewRect.contains((int) ev.getRawX(), (int) ev.getRawY())) {
            tvHouseType.setVisibility(View.GONE);
            topBar.getTitleView().setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_arrow_down, 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void switchFragment(int position) {
        Fragment fragment = getFragment(position);
        if (currentFragment != null && fragment == currentFragment) {
            return;
        }
//
//        for (TabItem item : items) {
//            if (items[position] != item) {
//                item.setChecked(false);
//            }
//        }
//        items[position].setFragment(fragment);
//        items[position].setChecked(true);

        currentPosition = position;
        currentFragment = fragment;
    }


    private Fragment getFragment(int position) {
        Fragment fragment = null;
        switch (position) {
            case MAP:
                if (homeFragment == null) {
                    homeFragment = new HomeMapFragment();
                }
                fragment = homeFragment;
                break;
            case PANORAMIC:
                if (panoramicFragment == null) {
                    panoramicFragment = new PanoramicFragment();
                }
                fragment = panoramicFragment;
                break;

        }
        return fragment;
    }


    private void clearFragment() {
        try {
            if (currentFragment != null) {
                FragmentTransaction begin = getSupportFragmentManager().beginTransaction();
                if (homeFragment != null) {
                    begin.remove(homeFragment);
                    begin.commit();
                }

                if (panoramicFragment != null) {
                    begin.remove(panoramicFragment);
                    begin.commit();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        homeFragment = null;
        currentFragment = null;
        panoramicFragment = null;
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

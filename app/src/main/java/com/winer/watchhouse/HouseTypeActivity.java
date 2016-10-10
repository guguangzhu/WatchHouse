package com.winer.watchhouse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.winer.watchhouse.adapter.EstateTypeAdapter;
import com.winer.watchhouse.adapter.HouseSizeAdapter;
import com.winer.watchhouse.fragment.HouseTypeInfoFragment;
import com.winer.watchhouse.fragment.HouseTypePicFragment;
import com.winer.watchhouse.fragment.PanoramicFragment;
import com.winer.watchhouse.view.SimpleViewPagerIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 户型
 * Created by guugangzhu on 2016/9/28.
 */

public class HouseTypeActivity extends BaseActivity {

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
        setTitle("三室两厅 100㎡");
        topBar.setRightSecondImg(R.mipmap.ic_heart);
        topBar.setTitleRightImg(R.mipmap.ic_share);
        topBar.getTitleView().setCompoundDrawablesWithIntrinsicBounds(0, 0,0,  R.mipmap.ic_arrow_down_small);
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

//        for (int i = 0; i < mTitles.length; i++)
//        {
//            mFragments[i] = HouseTypeInfoFragment.newInstance();
//        }
        mFragments[0] = HouseTypeInfoFragment.newInstance();
        mFragments[1] = HouseTypePicFragment.newInstance();
        mFragments[2] = HouseTypePicFragment.newInstance();

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

    @Override
    public void onTopCenterClick() {
        showPopupWindow(topBar.getTitleView());
    }

    private void showPopupWindow(View view) {

        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(this).inflate(
                R.layout.pop_house_size, null);

        ListView lvSize= (ListView) contentView.findViewById(R.id.lv_size);
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");

        HouseSizeAdapter adapter = new HouseSizeAdapter(this, list);
        lvSize.setAdapter(adapter);
        final PopupWindow popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

//        popupWindow.setTouchable(true);
//
//        popupWindow.setTouchInterceptor(new OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//
//                return false;
//                // 这里如果返回true的话，touch事件将被拦截
//                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
//            }
//        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.bg_transparent));

        // 设置好参数之后再show
        popupWindow.showAsDropDown(view);

    }
}

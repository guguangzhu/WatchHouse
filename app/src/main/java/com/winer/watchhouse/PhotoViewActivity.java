package com.winer.watchhouse;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by guugangzhu on 2016/10/12.
 */

public class PhotoViewActivity extends BaseActivity {

    @BindView(R.id.vp_photo)
    ViewPager vpPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        vpPhoto.setAdapter(new SamplePagerAdapter());
    }

    static class SamplePagerAdapter extends PagerAdapter {

        private static final int[] sDrawables = { R.mipmap.bg_login_one, R.mipmap.bg_login_two, R.mipmap.bg_login_three };

        @Override
        public int getCount() {
            return sDrawables.length;
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(container.getContext());
            photoView.setImageResource(sDrawables[position]);

            // Now just add PhotoView to ViewPager and return it
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }
}

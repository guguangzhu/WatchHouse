package com.toda.yjkf;

import android.app.Application;

import io.rong.imkit.RongIM;

/**
 * Created by guugangzhu on 2016/9/23.
 */

public class HouseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RongIM.init(this);
    }
}

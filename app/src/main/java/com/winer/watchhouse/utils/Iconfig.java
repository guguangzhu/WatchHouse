package com.winer.watchhouse.utils;

/**
 * Created by Zhao Haibin on 2016/2/22.
 */
public class Iconfig {

    //本地环境
    public static final String URL = "http://192.168.68.183:8087/";
    //项目存储图片根目录
    public static String WATCH_HOUSE_FILE = "/WatchHouse";
    // 缓存图片
    public static final String IMAGE_CACHE = "/imagecache";


    public static class Login{

        private static final String BASE_URL = URL + "Home/login/";

    }

    public static class User {
        private static final String BASE_URL = URL + "User/";

    }


}

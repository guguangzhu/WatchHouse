package com.toda.yjkf.model;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Zhao Haibin on 2016/1/27.
 */
public class RequestParams {
    private Map<String, String> params;
    private Map<String, String> headers;
    //是否为post请求，false为get
    private boolean isPost = true;
    //是否加密
    private boolean isEncrypt = true;
    private int tag = -1;
    private String url;

    public RequestParams(String url) {
        this.url = url;
        params = new TreeMap<>();
    }

    /***
     * 添加请求参数
     *
     * @param key
     * @param value
     * @return
     */
    public RequestParams add(String key, String value) {
        if (TextUtils.isEmpty(key)) {
            return this;
        }
        params.put(key, value);
        return this;
    }

    /***
     * 添加header
     *
     * @param key
     * @param value
     * @return
     */
    public RequestParams addHeader(String key, String value) {
        if (headers == null) {
            headers = new HashMap<>();
        }
        headers.put(key, value);
        return this;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    /***
     * 是否为post请求
     * @return
     */
    public boolean isPost() {
        return isPost;
    }

    /***
     * 设置是否为post请求
     * @param isPost
     */
    public void setIsPost(boolean isPost) {
        this.isPost = isPost;
    }

    public int getTag() {
        return tag;
    }

    /***
     * 设置请求唯一标识
     * @param tag
     */
    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public boolean isEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(boolean isEncrypt) {
        this.isEncrypt = isEncrypt;
    }
}

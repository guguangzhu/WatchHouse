package com.toda.yjkf.model;

import java.io.Serializable;

/**
 * Created by Zhao Haibin on 2016/1/28.
 */
public class ResultData implements Serializable{
    private String code="";
    private String msg="";
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

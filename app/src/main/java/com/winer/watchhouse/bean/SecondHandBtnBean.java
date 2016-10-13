package com.winer.watchhouse.bean;

import android.widget.LinearLayout;

/**
 * Created by guugangzhu on 2016/10/13.
 */

public class SecondHandBtnBean {
    private LinearLayout btn;
    private boolean isChecked;

    public SecondHandBtnBean(){

    }

    public SecondHandBtnBean(LinearLayout btn){
        this.btn=btn;
    }

    public LinearLayout getBtn() {
        return btn;
    }

    public void setBtn(LinearLayout btn) {
        this.btn = btn;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}

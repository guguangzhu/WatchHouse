package com.winer.watchhouse.bean;

/**
 * Created by guugangzhu on 2016/9/22.
 */

public class ImageScrollBean {
    private int image=-1;
    private boolean isRight;  //是：向右滑动    否：向左
    private int time=6000;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

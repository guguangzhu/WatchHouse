package com.winer.watchhouse;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.winer.watchhouse.bean.ImageScrollBean;
import com.winer.watchhouse.utils.BlurredUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.activity_splash)
    RelativeLayout activitySplash;
    public static final int STATE_SCROLL=1;
    public static final int STATE_CHANGE=2;
    private int scrollX=0;
    private int imageWidth=0;
    Random r=new Random();

    List<ImageScrollBean> list=new ArrayList<>();
    private int index;  //当前图片索引
    private ImageScrollBean currentImage; //当前图片bean;
    private int interval=50;  //每次更新控件间隔时间
    private int currentTime=0;
    private boolean isFirst=true; //是否是第一次启动线程

    private Bitmap currentBitmap;


    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case STATE_SCROLL:
                    if(currentImage.isRight()){
                        scrollX--;
                    }else {
                        scrollX++;
                    }
                    ivBg.setScrollX(scrollX);

                    break;
                case STATE_CHANGE:
                    if(index==list.size()-1){
                        index=0;
                    }else {
                        index++;
                    }
                    currentImage=list.get(index);
                    initBackground();
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
        View contentView=getLayoutInflater().inflate(R.layout.activity_login,null);
        setContentView(contentView);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        addImage();
        currentImage=list.get(0);
        index=0;

        initBackground();
    }

    @Override
    public void initView() {

    }


    private void initBackground(){
        Bitmap bitmap= BlurredUtil.drawableToBitmap(getResources().getDrawable(currentImage.getImage()));
        currentBitmap=BlurredUtil.blur(this,bitmap);
        ivBg.setImageBitmap(currentBitmap);
        ivBg.setScaleX(4);
        ivBg.setScaleY(4);

        currentTime=0;
        imageWidth=ivBg.getWidth();
        isFirst=true;
//        ivBg.getSc
        handler.postDelayed(runnable,50);
    }

    private void getScroll(){
        if(currentImage.isRight()){
            scrollX=ivBg.getWidth()/4;
        }else {
            scrollX=0;
        }
    }

    Runnable  runnable=new Runnable() {
        @Override
        public void run() {
            if(isFirst){
                getScroll();
                isFirst=false;
            }
            handler.sendEmptyMessage(STATE_SCROLL);
            currentTime+=interval;
            if(currentImage.isRight()){  //向右滑动
                if(currentTime<currentImage.getTime()&&scrollX>0){
                    handler.postDelayed(runnable,interval);
                }else {
                    handler.sendEmptyMessage(STATE_CHANGE);
                }
            }else {   //向左滑动
                if(currentTime<currentImage.getTime()&&scrollX<ivBg.getWidth()){
                    handler.postDelayed(runnable,interval);
                }else {
                    handler.sendEmptyMessage(STATE_CHANGE);
                }
            }


        }
    };

    private void addImage(){
        ImageScrollBean bean1=new ImageScrollBean();
        bean1.setImage(R.mipmap.bg_login_one);
        bean1.setRight(r.nextBoolean());
        list.add(bean1);
        ImageScrollBean bean2=new ImageScrollBean();
        bean2.setImage(R.mipmap.bg_login_two);
        bean2.setRight(r.nextBoolean());
        list.add(bean2);
        ImageScrollBean bean3=new ImageScrollBean();
        bean3.setImage(R.mipmap.bg_login_three);
        bean3.setRight(r.nextBoolean());
        list.add(bean3);
    }
}

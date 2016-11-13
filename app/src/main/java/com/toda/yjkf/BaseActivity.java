package com.toda.yjkf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.toda.yjkf.model.ResponseListener;
import com.toda.yjkf.model.ResultData;
import com.toda.yjkf.utils.Ikeys;
import com.toda.yjkf.view.TopBar;

import okhttp3.Call;

/**
 * Created by guugangzhu on 2016/9/23.
 */

public abstract class BaseActivity extends AppCompatActivity implements ResponseListener ,TopBar.OnTopBarClickListener ,Ikeys{
    private Context mContext;
    private HouseApplication app;
    public TopBar topBar;
    private RelativeLayout cltParent;

    private View contentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this;
        app= (HouseApplication) getApplication();
        setParentView(R.layout.activity_base);
    }

    /***
     * 设置父布局，即父类的setContentView
     *
     * @param resourceId
     */
    public void setParentView(int resourceId) {
//        super.setContentView(resourceId);
        View view= LayoutInflater.from(this).inflate(resourceId, null);
        topBar = (TopBar) view.findViewById(R.id.topbar);
        topBar.setOnTopBarClickListener(this);
        topBar.setTitleLeftImg(R.mipmap.ic_arrow_back);
        cltParent = (RelativeLayout) view.findViewById(R.id.clt_parent);

    }
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
//        super.setContentView(layoutResID);
        contentView = LayoutInflater.from(this).inflate(layoutResID, null);
        if (contentView != null){
            RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.
                    LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//            p.setBehavior(new AppBarLayout.ScrollingViewBehavior());
            p.addRule(RelativeLayout.BELOW, R.id.topbar);
            cltParent.addView(contentView, p);
        }
//        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        llRoot.addView(topBar,params);
//        LinearLayout.LayoutParams paramsContent=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0);
//        paramsContent.weight=1;
//        llRoot.addView(contentView,paramsContent);
        setContentView(cltParent, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public abstract void initView();

    /***
     * 显示toast，默认显示时间为LENGTH_SHORT
     *
     * @param msg 显示信息
     */
    public void toast(String msg) {
        toast(msg, Toast.LENGTH_SHORT);
    }

    /**
     * 显示Toast，防止一直点击弹出Toast
     *
     * @param text     显示的信息
     * @param duration 信息显示的时间
     */
    public void toast(String text, int duration) {
        Toast.makeText(this, text, duration).show();
    }

    /***
     * 跳转到指定页面
     *
     * @param clas 指定页面
     */
    public void goPage(Class<? extends Activity> clas) {
        goPage(clas, null);
    }

    /***
     * 跳转到指定页面
     *
     * @param clas 指定页面
     * @param data 传入数据
     */
    protected void goPage(Class<? extends Activity> clas, Bundle data) {
        goPage(clas, data, -1);
    }

    /***
     * 跳转到指定页面
     *
     * @param clas        指定页面
     * @param data        传入数据
     * @param requestCode 请求值
     */
    protected void goPage(Class<? extends Activity> clas, Bundle data, int requestCode) {
        if (clas == null) {
            return;
        }
        Intent intent = new Intent(this, clas);
        if (data != null) {
            intent.putExtra(Ikeys.KEY_DATA, data);
        }
        startActivityForResult(intent, requestCode);
    }


    /***
     * 设置toolbar title
     *
     * @param title
     */
    public void setTitle(String title) {
        topBar.setTitleText(title);
    }

    /***
     * 设置toolbar左侧图标
     *
     * @param drawable
     */
    public void setTopBarLeftImg(int drawable) {
        topBar.setTitleLeftImg(drawable);
    }

    /***
     * 设置toolbar左侧图标
     *
     * @param drawable
     */
    public void setTopBarRightImg(int drawable) {
        topBar.setTitleRightImg(drawable);
    }

    /***
     * 设置topbar右侧文字
     * @param str
     */
    public void setTopBarRightText(String str){
        topBar.setTitleRightText(str);
    }

    /***
     * 设置topbar左侧文字
     * @param str
     */
    public void setTopBarLeftText(String str){
        topBar.setTitleLeftText(str);
    }

    /***
     * 获取intent传入值
     * @return bundle
     */
    protected Bundle getIntentData(){
        Bundle bundle=getIntent().getBundleExtra(Ikeys.KEY_DATA);
        if(bundle==null){
            bundle=new Bundle();
        }
        return bundle;
    }

    /***
     * 获取String传入值，如果为空返回空字符串
     * @param key
     * @return
     */
    protected String getBundleStr(String key){
        Bundle bundle=getIntent().getBundleExtra(Ikeys.KEY_DATA);
        if(bundle==null){
            return "";
        }
        return bundle.getString(key,"");
    }

    @Override
    public void onRefresh(Call call, int tag, ResultData data) {

    }

    @Override
    public void onTopLeftClick() {
        this.finish();
    }

    @Override
    public void onTopRightClick() {

    }

    @Override
    public void onTopLeftSecondClick() {

    }

    @Override
    public void onTopCenterClick() {

    }

    @Override
    public void onTopRightSecondClick() {

    }
}

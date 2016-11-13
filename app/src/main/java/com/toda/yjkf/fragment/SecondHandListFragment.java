package com.toda.yjkf.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.toda.yjkf.R;
import com.toda.yjkf.adapter.SecondHandHouseAdapter;
import com.toda.yjkf.adapter.SecondHandOptAdapter;
import com.toda.yjkf.bean.SecondHandBtnBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 二手房
 */

public class SecondHandListFragment extends BaseFragment {

    @BindView(R.id.lv_list)
    ListView lvInfo;
    @BindView(R.id.tv_area)
    TextView tvArea;
    @BindView(R.id.btn_area)
    LinearLayout btnArea;
    @BindView(R.id.tv_total_money)
    TextView tvTotalMoney;
    @BindView(R.id.btn_total_money)
    LinearLayout btnTotalMoney;
    @BindView(R.id.tv_house_type)
    TextView tvHouseType;
    @BindView(R.id.btn_house_type)
    LinearLayout btnHouseType;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.btn_more)
    LinearLayout btnMore;

    SecondHandBtnBean area;
    SecondHandBtnBean totalMoney;
    SecondHandBtnBean houseType;
    SecondHandBtnBean more;

    private PopupWindow popArea,popTotalMoney,popHouseType,popMore;

    private List<SecondHandBtnBean> btnList=new ArrayList<>();

    public static SecondHandListFragment newInstance() {
        SecondHandListFragment fragment = new SecondHandListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_hand_list, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }


    @Override
    public void initView(View view) {
        btnList.clear();
        area=new SecondHandBtnBean(btnArea);
        totalMoney=new SecondHandBtnBean(btnTotalMoney);
        houseType=new SecondHandBtnBean(btnHouseType);
        more=new SecondHandBtnBean(btnMore);
        btnList.add(area);
        btnList.add(totalMoney);
        btnList.add(houseType);
        btnList.add(more);
        initPopArea();
        initPopTotalMoney();
        initPopHouseType();
        initPopMore();
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        SecondHandHouseAdapter adapter = new SecondHandHouseAdapter(getContext(), list);
        lvInfo.setAdapter(adapter);
    }

    @OnClick({R.id.btn_area, R.id.btn_total_money, R.id.btn_house_type, R.id.btn_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_area:
                changeArrow((LinearLayout) view);
                showPop(popArea);
                break;
            case R.id.btn_total_money:
                changeArrow((LinearLayout) view);
                showPop(popTotalMoney);
                break;
            case R.id.btn_house_type:
                changeArrow((LinearLayout) view);
                showPop(popHouseType);
                break;
            case R.id.btn_more:
                changeArrow((LinearLayout) view);
                showPop(popMore);
                break;
        }
    }

    private void changeArrow(LinearLayout v){
        for(SecondHandBtnBean btnBean:btnList){
            if(btnBean.getBtn().getId()==v.getId()){

                switch (v.getId()){
                    case R.id.btn_area:
                        if(btnBean.isChecked()){
                            tvArea.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                            btnBean.setChecked(false);
                        }else {
                            tvArea.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_up, 0);
                            btnBean.setChecked(true);
                        }
                        tvTotalMoney.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                        tvHouseType.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                        tvMore.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                        break;
                    case R.id.btn_total_money:
                        if(btnBean.isChecked()){
                            tvTotalMoney.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                            btnBean.setChecked(false);
                        }else {
                            tvTotalMoney.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_up, 0);
                            btnBean.setChecked(true);
                        }
                        tvArea.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                        tvHouseType.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                        tvMore.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                        break;
                    case R.id.btn_house_type:
                        if(btnBean.isChecked()){
                            tvHouseType.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                            btnBean.setChecked(false);
                        }else {
                            tvHouseType.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_up, 0);
                            btnBean.setChecked(true);
                        }
                        tvArea.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                        tvTotalMoney.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                        tvMore.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                        break;
                    case R.id.btn_more:
                        if(btnBean.isChecked()){
                            tvMore.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                            btnBean.setChecked(false);
                        }else {
                            tvMore.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_up, 0);
                            btnBean.setChecked(true);
                        }
                        tvArea.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                        tvTotalMoney.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                        tvHouseType.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.mipmap.ic_gray_arrow_down, 0);
                        break;
                }
            }else {
                btnBean.setChecked(false);
            }
        }
    }

    private void showPop(PopupWindow popupWindow){
        popupWindow.showAsDropDown(btnArea);
    }
    private void initPopArea(){
        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(getContext()).inflate(
                R.layout.pop_house_size, null);

        ListView lvSize= (ListView) contentView.findViewById(R.id.lv_size);
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        lvSize.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popArea.dismiss();
            }
        });
        SecondHandOptAdapter adapter = new SecondHandOptAdapter(getContext(), list);
        lvSize.setAdapter(adapter);
        popArea=new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popArea.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.bg_transparent));
        popArea.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                changeArrow(btnArea);
            }
        });
    }

    private void initPopTotalMoney(){
        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(getContext()).inflate(
                R.layout.pop_house_size, null);

        ListView lvSize= (ListView) contentView.findViewById(R.id.lv_size);
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        lvSize.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popTotalMoney.dismiss();
            }
        });
        SecondHandOptAdapter adapter = new SecondHandOptAdapter(getContext(), list);
        lvSize.setAdapter(adapter);
        popTotalMoney=new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popTotalMoney.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.bg_transparent));
        popTotalMoney.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                changeArrow(btnTotalMoney);
            }
        });
    }
    private void initPopHouseType(){
        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(getContext()).inflate(
                R.layout.pop_house_size, null);

        ListView lvSize= (ListView) contentView.findViewById(R.id.lv_size);
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        lvSize.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popHouseType.dismiss();
            }
        });
        SecondHandOptAdapter adapter = new SecondHandOptAdapter(getContext(), list);
        lvSize.setAdapter(adapter);
        popHouseType=new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popHouseType.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.bg_transparent));
        popHouseType.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                changeArrow(btnHouseType);
            }
        });
    }
    private void initPopMore(){
        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(getContext()).inflate(
                R.layout.pop_second_hand_more, null);
        List<String> list = new ArrayList<>();
        list.add("东");
        list.add("南");
        list.add("西");
        list.add("北");
        list.add("东南");
        list.add("东北");
        list.add("西南");
        list.add("西北");
        final TagFlowLayout tagFlowLayout= (TagFlowLayout) contentView.findViewById(R.id.id_flowlayout_orientation);
        tagFlowLayout.setAdapter(new TagAdapter<String>(list)
        {
            @Override
            public View getView(FlowLayout parent, int position, String s)
            {
                TextView tv = (TextView) getLayoutInflater(null).inflate(R.layout.item_radio_textview,
                        tagFlowLayout, false);
                tv.setText(s);
                return tv;
            }
        });

        final TagFlowLayout tagHouseType= (TagFlowLayout) contentView.findViewById(R.id.tag_house_type);
        initHouseTypeTag(tagHouseType);
        popMore=new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popMore.setBackgroundDrawable(getResources().getDrawable(
                R.drawable.bg_transparent));
        popMore.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                changeArrow(btnMore);
            }
        });
    }

    private void initHouseTypeTag(final TagFlowLayout tagFlowLayout){
        List<String> list = new ArrayList<>();
        list.add("不限");
        list.add("一室");
        list.add("二室");
        list.add("三室");
        list.add("三室以上");

        tagFlowLayout.setAdapter(new TagAdapter<String>(list)
        {
            @Override
            public View getView(FlowLayout parent, int position, String s)
            {
                TextView tv = (TextView) getLayoutInflater(null).inflate(R.layout.item_house_type_textview,
                        tagFlowLayout, false);
                tv.setText(s);
                return tv;
            }
        });
    }



}

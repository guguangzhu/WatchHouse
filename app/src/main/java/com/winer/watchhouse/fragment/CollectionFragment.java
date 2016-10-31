package com.winer.watchhouse.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.winer.watchhouse.EstateActivity;
import com.winer.watchhouse.MainActivity;
import com.winer.watchhouse.R;
import com.winer.watchhouse.adapter.CollectionHouseAdapter;
import com.winer.watchhouse.bean.CollectionBean;
import com.winer.watchhouse.view.pullview.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 收藏
 */
public class CollectionFragment extends BaseFragment implements AdapterView.OnItemClickListener ,CompoundButton.OnCheckedChangeListener{
    @BindView(R.id.gv_house)
    PullToRefreshListView gvHouse;
    @BindView(R.id.cb_check)
    CheckBox cbCheck;
    @BindView(R.id.btn_delete)
    TextView btnDelete;
    @BindView(R.id.rl_below)
    RelativeLayout rlBelow;

    private boolean isDelModel = false;

    private CollectionHouseAdapter adapter;
    private List<CollectionBean> list;

    public CollectionFragment() {
        // Required empty public constructor
    }


    public static CollectionFragment newInstance() {
        CollectionFragment fragment = new CollectionFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_collection, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(!isVisibleToUser&&isDelModel){
            changeMode(false);
        }
    }

    private void initView() {
        cbCheck.setOnCheckedChangeListener(this);
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CollectionBean bean = new CollectionBean();
            list.add(bean);
        }
        adapter = new CollectionHouseAdapter(getContext(), list);
        gvHouse.setOnItemClickListener(this);
        gvHouse.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void initView(View view) {

    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            for (CollectionBean bean : list) {
                bean.setChecked(true);
            }
        }else {
            for (CollectionBean bean : list) {
                bean.setChecked(false);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void changeMode(boolean isDelModel) {
        this.isDelModel = isDelModel;
        if (isDelModel) {
            for (CollectionBean bean : list) {
                bean.setVisible(true);
                rlBelow.setVisibility(View.VISIBLE);
            }
        } else {
            for (CollectionBean bean : list) {
                bean.setChecked(false);
                bean.setVisible(false);
                rlBelow.setVisibility(View.GONE);
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ((MainActivity) getActivity()).goPage(EstateActivity.class);
//
    }

    @OnClick(R.id.btn_delete)
    public void onClick() {
    }


}

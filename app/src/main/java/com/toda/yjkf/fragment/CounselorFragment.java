package com.toda.yjkf.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.toda.yjkf.EstateActivity;
import com.toda.yjkf.MainActivity;
import com.toda.yjkf.R;
import com.toda.yjkf.adapter.SecondHandHouseAdapter;
import com.toda.yjkf.view.pullview.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 经纪人
 */
public class CounselorFragment extends BaseFragment implements AdapterView.OnItemClickListener{
    public static final int TYPE_COUNSELOR=111;  //置业顾问
    public static final int TYPE_BROKER=112;  //经纪人
    @BindView(R.id.gv_house)
    PullToRefreshListView gvHouse;

    private SecondHandHouseAdapter adapter;

    public CounselorFragment() {
        // Required empty public constructor
    }


    public static CounselorFragment newInstance() {
        CounselorFragment fragment = new CounselorFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_manager, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        List<String> list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        adapter=new SecondHandHouseAdapter(getContext(),list);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {((MainActivity)getActivity()).goPage(EstateActivity.class);
//
    }
}

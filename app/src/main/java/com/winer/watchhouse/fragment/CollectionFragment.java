package com.winer.watchhouse.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.winer.watchhouse.EstateActivity;
import com.winer.watchhouse.MainActivity;
import com.winer.watchhouse.R;
import com.winer.watchhouse.adapter.PanoramicAdapter;
import com.winer.watchhouse.adapter.SecondHandHouseAdapter;
import com.winer.watchhouse.view.pullview.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 收藏
 */
public class CollectionFragment extends BaseFragment implements AdapterView.OnItemClickListener{
    @BindView(R.id.gv_house)
    PullToRefreshListView gvHouse;

    private SecondHandHouseAdapter adapter;

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
        View view = inflater.inflate(R.layout.fragment_panoramic, container, false);
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

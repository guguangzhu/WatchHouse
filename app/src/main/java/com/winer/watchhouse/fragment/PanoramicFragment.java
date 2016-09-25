package com.winer.watchhouse.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.winer.watchhouse.R;

import butterknife.ButterKnife;


/**
 * 全景看房
 */
public class PanoramicFragment extends Fragment{




    public PanoramicFragment() {
        // Required empty public constructor
    }


    public static PanoramicFragment newInstance() {
        PanoramicFragment fragment = new PanoramicFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}

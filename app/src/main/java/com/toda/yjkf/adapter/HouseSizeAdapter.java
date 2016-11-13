package com.toda.yjkf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.toda.yjkf.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：收益记录
 * 创建人：G.G.Z
 * 创建时间：16/3/18 19:41
 */
public class HouseSizeAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> list;
    private LayoutInflater mInflater;

    public HouseSizeAdapter(Context mContext, List<String> list) {
        this.mContext = mContext;
        this.list = list;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_house_size, null);
            mViewHolder = new ViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.tv_province)
        TextView tvProvince;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
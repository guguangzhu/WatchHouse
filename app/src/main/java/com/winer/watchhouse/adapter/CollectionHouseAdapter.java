package com.winer.watchhouse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.winer.watchhouse.R;
import com.winer.watchhouse.bean.CollectionBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 类描述：二手房
 * 创建人：G.G.Z
 * 创建时间：16/3/18 19:41
 */
public class CollectionHouseAdapter extends BaseAdapter {

    private Context mContext;
    private List<CollectionBean> list;
    private LayoutInflater mInflater;

    public CollectionHouseAdapter(Context mContext, List<CollectionBean> list) {
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
            convertView = mInflater.inflate(R.layout.item_collection_house, null);
            mViewHolder = new ViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        if(list.get(position).isVisible()){
            mViewHolder.checkBox.setVisibility(View.VISIBLE);
        }else {
            mViewHolder.checkBox.setVisibility(View.GONE);
        }
        if(list.get(position).isChecked()){
            mViewHolder.checkBox.setChecked(true);
        }else {
            mViewHolder.checkBox.setChecked(false);
        }

        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.iv_logo)
        ImageView ivLogo;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_size)
        TextView tvSize;
        @BindView(R.id.tv_address_price)
        TextView tvAddressPrice;
        @BindView(R.id.tv_money)
        TextView tvMoney;
        @BindView(R.id.cb_select)
        CheckBox checkBox;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

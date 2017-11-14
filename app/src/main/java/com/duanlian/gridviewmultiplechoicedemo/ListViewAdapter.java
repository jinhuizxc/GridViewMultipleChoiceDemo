package com.duanlian.gridviewmultiplechoicedemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * ListView的Adapter
 */
public class ListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> channelList;
    ViewHolder holder = null;


    public ListViewAdapter(Context context, List<String> channelList) {
        this.mContext = context;
        this.channelList = channelList;
    }

    @Override
    public int getCount() {
        return channelList != null ? channelList.size() : null;
    }

    @Override
    public Object getItem(int position) {
        return channelList != null ? channelList.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return channelList != null ? position : 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.item_gridview, null);
            holder.textView = (TextView) convertView.findViewById(R.id.tv_league);
            holder.mRelativeLayout = (RelativeLayout) convertView.findViewById(R.id.ll_competition);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //给item赋值
        holder.textView.setText(channelList.get(position));
        return convertView;
    }


    static class ViewHolder {
        TextView textView;
        RelativeLayout mRelativeLayout;

    }


}

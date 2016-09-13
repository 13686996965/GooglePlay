package cn.it.googleplay.adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.it.googleplay.R;
import cn.it.googleplay.base.BaseListAdapter;
import cn.it.googleplay.base.BaseViewHolder;
import cn.it.googleplay.base.SimpeListAdapter;
import cn.it.googleplay.holder.HomeViewHolder;
import cn.it.googleplay.utils.UIUtils;

/**
 * Created by Sen on 2016/9/13.
 */

public class HomeAdapter extends BaseListAdapter {
    @Override
    public BaseViewHolder getViewHolder(ViewGroup parent) {
        return new HomeViewHolder(parent);
    }


//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder;
//        if (convertView == null) {
//            holder = new ViewHolder();
//            convertView = UIUtils.getInflate().inflate(R.layout.item_home, parent, false);
//            holder.tv = (TextView) convertView.findViewById(R.id.tv_name);
//            convertView.setTag(holder);
//        }
//        holder = (ViewHolder) convertView.getTag();
//        holder.tv.setText((String)list.get(position));
//        Log.d("it", "getVIew()");
//        return convertView;
//    }
//
//    private class ViewHolder {
//        TextView tv;
//    }

}

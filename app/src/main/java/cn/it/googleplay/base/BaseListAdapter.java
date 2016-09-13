package cn.it.googleplay.base;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.it.googleplay.R;
import cn.it.googleplay.adapter.HomeAdapter;
import cn.it.googleplay.utils.UIUtils;


/**
 * Created by Sen on 2016/9/13.
 */

public abstract class BaseListAdapter<T> extends BaseAdapter {

    public List<T> list = new ArrayList<T>();


    // 暴露方法给外界增加&获取数据
    public void addDatas(List<T> datas) {
        //把datas集合的元素添加到fragments集合中
        list.addAll(datas);
//			fragments=datas;
        notifyDataSetChanged();
    }

    public void addData(T data) {
        list.add(data);
        notifyDataSetChanged();
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    public T getData(int position) {
        return list.get(position);
    }


    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder holder;
        if (convertView == null) {

            holder = getViewHolder(parent);


//            convertView = UIUtils.getInflate().inflate(R.layout.item_home, parent, false);
//            holder.tv = (TextView) convertView.findViewById(R.id.tv_name);

//            convertView.setTag(holder);


        }else {
            holder = (BaseViewHolder) convertView.getTag();
        }
//        holder.tv.setText((String)list.get(position));
        T data = list.get(position);
        holder.setData(data);
        return holder.getRootView();
    }

    public abstract BaseViewHolder getViewHolder(ViewGroup parent);


//    public abstract class BaseViewHolder {
//        View view;
//        T data;
//
//        public BaseViewHolder() {
//            this.view = initView();
//            this.view.setTag(this);
//        }
//
//        public void setData(T data){
//            this.data = data;
//
//        }
//
//        public T getData(){
//            return data;
//        }
//
//        public abstract View initView();
//
//        public abstract void refreshView();
//
//        public View getRootView() {
//            return view;
//        }
//    }

}

package cn.it.googleplay.base;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.it.googleplay.R;
import cn.it.googleplay.utils.UIUtils;


/**
 * Created by Sen on 2016/9/13.
 */

public abstract class SimpeListAdapter<T> extends BaseAdapter {

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
    public abstract View getView(int position, View convertView, ViewGroup parent);

}

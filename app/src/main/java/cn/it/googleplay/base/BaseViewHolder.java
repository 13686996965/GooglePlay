package cn.it.googleplay.base;

import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Sen on 2016/9/14.
 */

public abstract class BaseViewHolder<T> {
    View view;
    T data;

    public BaseViewHolder(ViewGroup parent) {
        this.view = initView(parent);
        this.view.setTag(this);
    }

    public void setData(T data){
        this.data = data;
        refreshView();
    }

    public T getData(){
        return data;
    }

    public abstract View initView(ViewGroup parent);

    public abstract void refreshView();

    public View getRootView() {
        return view;
    }
}
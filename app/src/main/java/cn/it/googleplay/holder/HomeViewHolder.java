package cn.it.googleplay.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.it.googleplay.R;
import cn.it.googleplay.base.BaseViewHolder;
import cn.it.googleplay.utils.UIUtils;

/**
 * Created by Sen on 2016/9/14.
 */

public class HomeViewHolder extends BaseViewHolder<String> {

    private TextView mNameTv;

    public HomeViewHolder(ViewGroup parent) {
        super(parent);
    }

    @Override
    public View initView(ViewGroup parent) {
        View view = UIUtils.getInflate().inflate(R.layout.item_home, parent, false);
        mNameTv = (TextView) view.findViewById(R.id.tv_name);
        return view;
    }

    @Override
    public void refreshView() {
        String data = getData();
        mNameTv.setText(data);
    }
}

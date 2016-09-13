package cn.it.googleplay.fragment;

import android.view.View;
import android.widget.TextView;

import cn.it.googleplay.base.BaseFragment;

public class CategoryFragment extends BaseFragment {
    //创建成功界面
	@Override
	public View onSubCreateView() {
		TextView tv=new TextView(context);
		tv.setText("分类");
		return tv;
	}

}

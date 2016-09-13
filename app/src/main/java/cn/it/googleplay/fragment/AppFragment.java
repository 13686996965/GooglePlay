package cn.it.googleplay.fragment;

import android.view.View;
import android.widget.TextView;

import cn.it.googleplay.base.BaseFragment;

public class AppFragment extends BaseFragment {
    //创建成功界面
	@Override
	public View onSubCreateView() {
		TextView tv=new TextView(context);
		tv.setText("应用");
		return tv;
	}

}

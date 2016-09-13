package cn.it.googleplay.fragment;

import android.view.View;
import android.widget.TextView;

import cn.it.googleplay.base.BaseFragment;
import cn.it.googleplay.view.ContentPager;

public class CategoryFragment extends BaseFragment {
    //创建成功界面
	@Override
	public View onSubCreateView() {
		TextView tv=new TextView(context);
		tv.setText("分类");
		return tv;
	}

	@Override
	public ContentPager.ResultState onLoad() {
		return ContentPager.ResultState.LOAD_EMPTY;
	}

}

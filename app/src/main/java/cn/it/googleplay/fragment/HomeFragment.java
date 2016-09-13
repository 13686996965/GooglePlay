package cn.it.googleplay.fragment;

import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.it.googleplay.R;
import cn.it.googleplay.adapter.HomeAdapter;
import cn.it.googleplay.base.BaseFragment;
import cn.it.googleplay.base.SimpeListAdapter;
import cn.it.googleplay.utils.UIUtils;
import cn.it.googleplay.view.ContentPager;

public class HomeFragment extends BaseFragment {
	List<String> datas = new ArrayList<String>();
    //创建成功界面
	@Override
	public View onSubCreateView() {
		ListView listView = new ListView(getContext());
		HomeAdapter adapter = new HomeAdapter();
		initDatas();
		adapter.addDatas(datas);
		listView.setAdapter(adapter);
		return listView;
	}

	private void initDatas() {
		String[] strings = UIUtils.getStringArray(R.array.category_app);

		for (String str : strings) {
			datas.add(str);
		}
	}

	@Override
	public ContentPager.ResultState onLoad() {
		return ContentPager.ResultState.LOAD_SUCCESS;
	}
}

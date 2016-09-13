package cn.it.googleplay.adapter;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import cn.it.googleplay.R;
import cn.it.googleplay.base.BaseFragment;
import cn.it.googleplay.factory.FragmentFactory;
import cn.it.googleplay.utils.UIUtils;

// Basepager
	public class MainPagerAdapter extends FragmentPagerAdapter{
		private List<BaseFragment> fragments=new ArrayList<BaseFragment>();
        private String[]  tabNames=null;
		public MainPagerAdapter(FragmentManager fm) {
			super(fm);
			tabNames= UIUtils.getStringArray(R.array.tab_names);
		}
		
		public void addDatas(List<BaseFragment> datas){
			//把datas集合的元素添加到fragments集合中
			fragments.addAll(datas);
//			fragments=datas;
			notifyDataSetChanged();
		}
		
		public void addData(BaseFragment data){
			fragments.add(data);
			notifyDataSetChanged();
		}
		
		public void clear(){
			fragments.clear();
			notifyDataSetChanged();
		}
		
		public Fragment getData(int position){
			return fragments.get(position);
		}
		
		public List<BaseFragment> getDatas(){
			return fragments;
		}
		//取得当前要展示的片段
		@Override
		public Fragment getItem(int position) {
			Log.d("it","****getItem*****");
//			return fragments.get(position);
			return FragmentFactory.getFragment(position);
		}
        
		//取得要装配的片段的数量
		@Override
		public int getCount() {
			return tabNames.length;
		}
		
		
		//返回页面标题，PagerSlidingTabStrip的tab标签会使用该方法的返回值作为标签的标题
		@Override
		public CharSequence getPageTitle(int position) {
			return tabNames[position];
		}
		
	}
	
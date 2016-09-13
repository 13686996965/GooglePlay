package cn.it.googleplay.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.it.googleplay.view.ContentPager;

/**
 * 所有片段(七大功能片段)的基类 
 * @author ThinkPad
 *
 */
public abstract class BaseFragment extends Fragment {
	public Context context;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		context=activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		ContentPager contentPager=new ContentPager(context) {
			@Override
			public View onCreateSuccessView() {
				return BaseFragment.this.onSubCreateView();
			}
	
		};
		return contentPager;
	}
	
	//由于BaseFragment基类不能决定子类中的成功界面如何实现 ，所以抽象出去，由子类来实现
	public abstract  View onSubCreateView() ;

	

}

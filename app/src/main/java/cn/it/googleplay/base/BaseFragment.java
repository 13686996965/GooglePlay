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
	private ContentPager mContentPager;

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		this.context=context;
	}
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mContentPager = new ContentPager(context) {
			@Override
			protected ResultState onLoad() {
				return BaseFragment.this.onLoad();
			}

			@Override
			public View onCreateSuccessView() {
				return BaseFragment.this.onSubCreateView();
			}

		};

		// 创建View的时候就进行加载或刷新
		mContentPager.onLoadOrRefresh();
		return mContentPager;
	}
	
	//由于BaseFragment基类不能决定子类中的成功界面如何实现 ，所以抽象出去，由子类来实现
	public abstract View onSubCreateView() ;

	public abstract ContentPager.ResultState onLoad();

	

}

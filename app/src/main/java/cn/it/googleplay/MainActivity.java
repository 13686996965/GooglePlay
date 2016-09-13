package cn.it.googleplay;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.it.googleplay.adapter.MainPagerAdapter;
import cn.it.googleplay.base.BaseActivity;
import cn.it.googleplay.base.BaseFragment;
import cn.it.googleplay.fragment.AppFragment;
import cn.it.googleplay.fragment.CategoryFragment;
import cn.it.googleplay.fragment.GameFragment;
import cn.it.googleplay.fragment.HomeFragment;
import cn.it.googleplay.fragment.HotFragment;
import cn.it.googleplay.fragment.RecommendFragment;
import cn.it.googleplay.fragment.SubjectFragment;
import cn.it.googleplay.utils.ToastUtil;
import cn.it.googleplay.widget.PagerSlidingTabStrip;


public class MainActivity extends BaseActivity {
	private PagerSlidingTabStrip mTabStrip;
	private ViewPager mViewPager;
	private List<BaseFragment> datas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//设置主题 ，没有标题的样式
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		
		/**
		 * 取得Actionbar ,Actionbar要依赖标题栏来显示，假如设置没有标题的样式，则Actionbar为null
		 * 升级：
		 *  titlebar--》actionbar--》 toolbar 
		
//		ActionBar actionBar = getActionBar();
		ActionBar actionBar =getSupportActionBar();
		// 设置 显示返回箭头(向上的指示器)，并且设置监听
//		actionBar.setDisplayHomeAsUpEnabled(true);
		//设置Actionbar的图标
//		actionBar.setIcon(R.drawable.action_download);
		//设置标题
//		actionBar.setTitle("google_market");
		//不显示标题
//		actionBar.setDisplayShowTitleEnabled(false);
 * 
 *  */
		
		
		//1. 引用控件
		mTabStrip=(PagerSlidingTabStrip) findViewById(R.id.tabstrip);
		mViewPager=(ViewPager) findViewById(R.id.vp_main);
		
		
		//2. 初始化要装配的片段
		initPagers();
		//3. 准备ViewPager的适配器 
		MainPagerAdapter adapter=new MainPagerAdapter(getSupportFragmentManager());
		
		//4. ViewPager设置适配器
		mViewPager.setAdapter(adapter);
		
		//5. PagerSlidingTabStrip 与ViewPager绑定在一起
		
		mTabStrip.setViewPager(mViewPager);
		
		
		//6. 往适配器中添加数据
		adapter.addDatas(datas);
	   
	}
	
	private void initPagers() {
		datas=new ArrayList<BaseFragment>();
		datas.add(new HomeFragment());
		datas.add(new AppFragment());
		datas.add(new GameFragment());
		datas.add(new SubjectFragment());
		datas.add(new RecommendFragment());
		datas.add(new CategoryFragment());
		datas.add(new HotFragment());
	}

	//创建操作按钮  ，创建菜单按钮
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// 把菜单的xml文件实例化为菜单项，再添加到menu菜单中
//		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//监听菜单按钮 ，操作按钮 ，返回监听的监听
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//取得菜单项的id
		switch (item.getItemId()) {
		case R.id.action_add:
			ToastUtil.show("更新");
			break;
		case R.id.action_settings:
			Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
			break;
		case android.R.id.home:
			Toast.makeText(this, "向上返回", Toast.LENGTH_SHORT).show();
			finish();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	

	

}

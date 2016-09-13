package cn.it.googleplay.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

import cn.it.googleplay.app.GMApplication;

/**
 * 与UI相关的操作的工具类
 * @author ThinkPad
 *
 */
public class UIUtils {
	//与GMApplicaiton相关的操作也封装到UIUtils中  好处： 只有知道一个工具类UIUtils，而不用管GMApplication类
     //取得主线程
	public static Thread getMainThread(){
		return GMApplication.getMainThread();
	}
	//取得主线程的id
	public static int getMainThreadId(){
		return GMApplication.getMainThreadId();
	}
	//取得全局的上下文
	public static Context getContext(){
		return GMApplication.getContext();
	}
	//取得handler对象
	public static Handler getHandler(){
		return  GMApplication.getHandler();
	}
	
	//把xml的布局转换为view,返回的是xml布局的根节点视图对象
	public static View inflate(int layoutResId){
		return View.inflate(getContext(), layoutResId, null);
	}
	
	//取得LayoutInflater对象
	public static LayoutInflater  getInflate(){
		return LayoutInflater.from(getContext());
	}
	
	//取得resources资源对象
	public static Resources getResources(){
		return getContext().getResources();
	}
	//取得字符串资源
	public static String getString(int stringResId){
		return getResources().getString(stringResId);
	}
	//取得Drawable资源
	public static Drawable getDrawable(int drawableResId){
		return getResources().getDrawable(drawableResId);
	}
	//取得字符串数组
	public static String[] getStringArray(int stringArrayResId){
		return getResources().getStringArray(stringArrayResId);
	}
	//dp转px    
	public static int dp2px(int dp){
		//当前手机屏幕的密度与基准的比例值 
		// 比如： 当前 密度是 240 Hdpi  dpi（每英寸物理像素点的数量）  基准密度  160 MDPI 
		//density=  1.5 
		float density = getResources().getDisplayMetrics().density;
		return (int) (dp*density+0.5f);
	}
	//px转dp  
	public static int px2dp(int px){
		//当前手机屏幕的密度与基准的比例值 
		// 比如： 当前 密度是 240 Hdpi  dpi（每英寸物理像素点的数量）  基准密度  160 MDPI 
		//density=  1.5 
		float density = getResources().getDisplayMetrics().density;
		return (int) (px/density+0.5f);
	}
	
	//判断当前线程是否为主线程
	public static boolean isMainThread(){
		return getMainThreadId()==android.os.Process.myTid();
	}
	
	public static void runOnMainThread(Runnable runnable){
		if(isMainThread()) {
		    runnable.run();
		}else
		{
			getHandler().post(runnable);
		}
	}

}

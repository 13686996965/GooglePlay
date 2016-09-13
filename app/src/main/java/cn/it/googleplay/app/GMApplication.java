package cn.it.googleplay.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
/**
 * 当定义启动时，实例化 一个单例的Application
 * @author ThinkPad
 *
 */
public class GMApplication extends Application {
	private static Context context;//上下文
	private static Handler mHandler;//线程通信工具 
	private static Thread mainThread;//主线程
	private static int mainThreadId;//主线程的id
//	private User user;//用户信息
	@Override
	public void onCreate() {
		context=this.getApplicationContext();
		mHandler=new Handler();
		mainThread=Thread.currentThread();//取得当前的线程
		mainThreadId=android.os.Process.myTid();//取得当前的线程的id
	}
	public static Context getContext() {
		return context;
	}
	public static Handler getHandler() {
		return mHandler;
	}
	public static Thread getMainThread() {
		return mainThread;
	}
	public static int getMainThreadId() {
		return mainThreadId;
	}
	
	

}

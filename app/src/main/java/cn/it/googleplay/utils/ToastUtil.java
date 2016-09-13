package cn.it.googleplay.utils;

import android.widget.Toast;

/**
 * 吐司的工具类
 * @author ThinkPad
 *
 */
public class ToastUtil {
	public static void show(String text){
		Toast.makeText(UIUtils.getContext(), text, Toast.LENGTH_SHORT).show();
	}
	public static void show(int textResId){
		Toast.makeText(UIUtils.getContext(), textResId, Toast.LENGTH_SHORT).show();
	}

}

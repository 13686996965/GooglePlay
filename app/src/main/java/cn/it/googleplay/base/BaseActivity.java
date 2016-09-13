package cn.it.googleplay.base;

import android.support.v7.app.ActionBarActivity;
/**
 * 所有Activity的基类，要求所有的Activity都向下支持ActionBar效果
 *  注意 ：
 *   1. ActionBarActivity 继承FragmentActivity
 *   2. 假如Activity 继承ActionBarActivity ,
 *      则该Activity的主题要设置 v7库中的Theme.AppCompact 或者是其子主题
 *   
 * @author ThinkPad
 *
 */
public class BaseActivity extends ActionBarActivity {

}

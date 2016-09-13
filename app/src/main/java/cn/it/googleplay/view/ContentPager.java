package cn.it.googleplay.view;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import cn.it.googleplay.R;
import cn.it.googleplay.utils.UIUtils;

/**
 * 片段的内容界面封装的自定义控件
 *
 * @author ThinkPad
 */
public abstract class ContentPager extends FrameLayout {
    private static final int STATE_LOADING = 1;  //正在加载的状态
    public static final int STATE_EMPTY = 2; //为空状态
    public static final int STATE_ERROR = 3; //访问网络出错状态
    public static final int STATE_SUCCESS = 4; //访问网络成功，且有数据的状态
    public static final int STATE_UN_LOADING = 0; //没有加载网络的状态，初始状态
    public int state = STATE_UN_LOADING;//当前的状态


    private View loadingView;//正在加载网络的界面
    private View emptyView;//访问网络 ，获取数据为空展示的界面
    private View errorView;//访问网络出错要展示的界面
    private View successView;//访问网络成功，且有数据要展示的界面

    public ContentPager(Context context) {
        super(context);
        initPager();
    }

    // 1 初始化页面
    private void initPager() {
        //1.1 添加为空的界面
        if (emptyView == null) {
            emptyView = onCreateEmptyView();
            this.addView(emptyView);
        }
        //1.2 添加访问网络出错的界面
        if (errorView == null) {
            errorView = onCreateErrorView();
            this.addView(errorView);
        }
        //1.3 添加正在访问网络的界面
        if (loadingView == null) {
            loadingView = onCreateLoadingView();
            this.addView(loadingView);
        }

        //1.4 添加访问网络成功，且有数据的界面  ，应该当要显示界面，且访问网络成功状态，才来创建成功界面

        showPager();
    }

    /**
     * 2. 依据访问网络的结果状态来决定显示哪个界面
     */
    private void showPager() {

        //2.1 假如当前的状态是正在访问网络 ，或者默认的状态，都显示转圈圈的效果
        if (loadingView != null) {
            if (state == STATE_UN_LOADING || state == STATE_LOADING) {
                loadingView.setVisibility(View.VISIBLE);
            } else {
                loadingView.setVisibility(View.INVISIBLE);
            }
        }

        //2.2 显示为空界面
        if (emptyView != null) {
            emptyView.setVisibility(state == STATE_EMPTY ? View.VISIBLE : View.INVISIBLE);
        }
        //2.3 显示访问网络出错界面
        if (errorView != null) {
            errorView.setVisibility(state == STATE_ERROR ? View.VISIBLE : View.INVISIBLE);
        }

        //2.4 显示成功界面 ,当successView为空，且状态为成功，则创建 界面
        if (successView == null && state == STATE_SUCCESS) {
            successView = onCreateSuccessView();
            //把视图添加到容器中
            if (successView != null) {
                this.addView(successView);
            }
        }

        //显示界面
        if (successView != null) {
            successView.setVisibility(state == STATE_SUCCESS ? View.VISIBLE : View.INVISIBLE);
        }
    }

    /**
     * 如果需要刷新或加载网络  则调用此方法
     * 加载或刷新网络
     * 先判断状态 if 状态为初始化 或 为空  或 出错 则加载网络
     */
    public void onLoadOrRefresh() {
        Log.d("it","onLoadOrRefresh()");
        if (state == STATE_UN_LOADING || state == STATE_EMPTY || state == STATE_ERROR) {
            // 执行刷新 更新状态
            state = STATE_LOADING;
        }

        if (state == STATE_LOADING) {

            new Thread() {
                @Override
                public void run() {
                    super.run();
                    // 子线程执行网络访问操作
                    ResultState resultState = onLoad();
                    state = resultState.getState();
                    UIUtils.runOnMainThread(new Runnable() {
                        @Override
                        public void run() {
                            // 更新UI
                            showPager();
                        }
                    });

                }
            }.start();
        }
    }

    /**
     * 枚举状态
     */
    public enum ResultState{
        LOAD_EMPTY(STATE_EMPTY),
        LOAD_ERROR(STATE_ERROR),
        LOAD_SUCCESS(STATE_SUCCESS),
        LOAD_UN_LOADING(STATE_UN_LOADING);

        private int state;
       private   ResultState(int state){
           this.state = state;
       }

        public int getState(){
            return state;
        }

    }


    /**
     * 让具体实现模块取实现具体的网络加载
     *
     * @return 返回加载的状态
     */
    protected abstract ResultState onLoad();


    /**
     * 创建成功视图界面 ，由于ContentPager是一个公共界面，不能决定成功界面，所以具体的成功界面应该有实现者去实现
     *
     * @return
     */
    public abstract View onCreateSuccessView();

    private View onCreateLoadingView() {
        return UIUtils.inflate(R.layout.layout_loading);
    }

    private View onCreateErrorView() {
        return UIUtils.inflate(R.layout.layout_error);
    }

    private View onCreateEmptyView() {
        return UIUtils.inflate(R.layout.layout_empty);
    }

}

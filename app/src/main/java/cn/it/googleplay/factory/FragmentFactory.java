package cn.it.googleplay.factory;

import java.util.HashMap;
import java.util.Map;

import cn.it.googleplay.base.BaseFragment;
import cn.it.googleplay.fragment.AppFragment;
import cn.it.googleplay.fragment.CategoryFragment;
import cn.it.googleplay.fragment.GameFragment;
import cn.it.googleplay.fragment.HomeFragment;
import cn.it.googleplay.fragment.HotFragment;
import cn.it.googleplay.fragment.RecommendFragment;
import cn.it.googleplay.fragment.SubjectFragment;

/**
 * 以工厂的模式 动态初始化Pager
 * <p>
 * Created by Sen on 2016/9/13.
 */

public class FragmentFactory {
    /**
     * datas.add(new HomeFragment());
     * datas.add(new AppFragment());
     * datas.add(new GameFragment());
     * datas.add(new SubjectFragment());
     * datas.add(new RecommendFragment());
     * datas.add(new CategoryFragment());
     * datas.add(new HotFragment());
     *
     * @param position
     * @return
     */
    private static Map<Integer, BaseFragment> fragmentMap = new HashMap<Integer, BaseFragment>();

    public static BaseFragment getFragment(int position) {
        BaseFragment fragment = fragmentMap.get(position);
        if (fragment == null) {

            switch (position) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new AppFragment();
                    break;
                case 2:
                    fragment = new GameFragment();
                    break;
                case 3:
                    fragment = new SubjectFragment();
                    break;
                case 4:
                    fragment = new RecommendFragment();
                    break;
                case 5:
                    fragment = new CategoryFragment();
                    break;
                case 6:
                    fragment = new HotFragment();
                    break;
                default:
                    fragment = new HomeFragment();
            }
            fragmentMap.put(position, fragment);
        }
        return fragmentMap.get(position);
    }

}

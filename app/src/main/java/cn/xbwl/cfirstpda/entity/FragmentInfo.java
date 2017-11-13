package cn.xbwl.cfirstpda.entity;

import cn.xbwl.cfirstpda.base.BaseFragment;

/**
 * Created by chenjinglan on 2017/11/9.
 * email:13925024285@163.com
 */

public class FragmentInfo {
    private BaseFragment fragment;
    private String fragmentTittle;
    private int fragmentIcon;

    public FragmentInfo(BaseFragment fragment, String fragmentTittle, int fragmentIcon) {
        this.fragment = fragment;
        this.fragmentTittle = fragmentTittle;
        this.fragmentIcon = fragmentIcon;
    }

    public BaseFragment getFragment() {
        return fragment;
    }

    public void setFragment(BaseFragment fragment) {
        this.fragment = fragment;
    }

    public String getFragmentTittle() {
        return fragmentTittle;
    }

    public void setFragmentTittle(String fragmentTittle) {
        this.fragmentTittle = fragmentTittle;
    }

    public int getFragmentIcon() {
        return fragmentIcon;
    }

    public void setFragmentIcon(int fragmentIcon) {
        this.fragmentIcon = fragmentIcon;
    }
}

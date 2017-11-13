package cn.xbwl.cfirstpda.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cn.xbwl.cfirstpda.base.BaseFragment;

/**
 * Created by chenjinglan on 2017/11/8.
 * email:13925024285@163.com
 */

public class TabPagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> mTabFragmentList;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public TabPagerAdapter(FragmentManager fm, List<BaseFragment> tabFragmentList) {
        super(fm);
        this.mTabFragmentList = tabFragmentList;
    }

    public void setTabFragmentList(List<BaseFragment> tabFragmentList) {
        this.mTabFragmentList = tabFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        if (mTabFragmentList != null) {
            return mTabFragmentList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTabFragmentList == null ? 0 : mTabFragmentList.size();
    }
}

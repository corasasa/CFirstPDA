package cn.xbwl.cfirstpda.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.xbwl.cfirstpda.R;
import cn.xbwl.cfirstpda.base.AbsTabFragment;
import cn.xbwl.cfirstpda.base.BaseFragment;

/**
 * Created by chenjinglan on 2017/11/8.
 * email:13925024285@163.com
 */

public class MessageFragment extends AbsTabFragment {
    @BindView(R.id.viewPager_icon)
    ViewPager viewPagerIcon;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_message, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        initViewPager();
        return rootView;
    }

    private void initViewPager() {
        List<BaseFragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeFragment1());
        mFragmentList.add(new HomeFragment2());
        mFragmentList.add(new HomeFragment3());
        BarPagerAdapter adapter = new BarPagerAdapter(getChildFragmentManager());
        adapter.setFragmentList(mFragmentList);
        viewPagerIcon.setAdapter(adapter);
        viewPagerIcon.setCurrentItem(0);
        viewPagerIcon.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    static class BarPagerAdapter extends FragmentPagerAdapter{

        private List<BaseFragment> mFragmentList=new ArrayList<>();
        public BarPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void setFragmentList(List<BaseFragment> fragmentList) {
            this.mFragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

}

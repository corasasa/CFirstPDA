package cn.xbwl.cfirstpda.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
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

public class ShopCarFragment extends AbsTabFragment {

    @BindView(R.id.tablayout_top)
    TabLayout tablayoutTop;
    @BindView(R.id.viewPager_topTab)
    ViewPager viewPagerTopTab;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopcar, container, false);
        unbinder = ButterKnife.bind(this, view);
        initViewPager();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void initViewPager() {
        List<BaseFragment> mFragmentList = new ArrayList<>();
        String[] tittles = new String[8];
        for (int i = 0; i < 8; i++) {
            tittles[i] = "tab" + i;
            mFragmentList.add(new HomeFragment1());
        }

        TopTabPagerAdapter adapter = new TopTabPagerAdapter(getChildFragmentManager());
        adapter.setFragmentList(mFragmentList);
        viewPagerTopTab.setAdapter(adapter);
        tablayoutTop.setupWithViewPager(viewPagerTopTab);

        int tabCount = tablayoutTop.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            tablayoutTop.getTabAt(i).setText(tittles[i]);
        }
        viewPagerTopTab.setCurrentItem(0);

    }

    static class TopTabPagerAdapter extends FragmentPagerAdapter {

        private List<BaseFragment> mFragmentList = new ArrayList<>();

        public TopTabPagerAdapter(FragmentManager fm) {
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

package cn.xbwl.cfirstpda.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.xbwl.cfirstpda.R;
import cn.xbwl.cfirstpda.adapter.TabPagerAdapter;
import cn.xbwl.cfirstpda.base.BaseActivity;
import cn.xbwl.cfirstpda.base.BaseFragment;
import cn.xbwl.cfirstpda.ui.fragment.HomeFragment;
import cn.xbwl.cfirstpda.ui.fragment.MineFragment;
import cn.xbwl.cfirstpda.ui.fragment.ShopCarFragment;
import cn.xbwl.cfirstpda.ui.fragment.MessageFragment;
import cn.xbwl.cfirstpda.utils.LogUtil;
import cn.xbwl.cfirstpda.utils.StatusBarUtil;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.viewPager_tab)
    ViewPager viewPagerTab;
    @BindView(R.id.rbt_menu_home)
    RadioButton rbtMenuHome;
    @BindView(R.id.rbt_menu_weitao)
    RadioButton rbtMenuWeitao;
    @BindView(R.id.rbt_menu_shopcar)
    RadioButton rbtMenuShopcar;
    @BindView(R.id.rbt_menu_mime)
    RadioButton rbtMenuMime;
    @BindView(R.id.rgp_tab_group)
    RadioGroup rgpTabGroup;

    private List<BaseFragment> mTabFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.setTranslucentForImageViewInFragment(this,null);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    private void initView() {
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        tabPagerAdapter.setTabFragmentList(mTabFragmentList);
        viewPagerTab.setAdapter(tabPagerAdapter);
        viewPagerTab.setCurrentItem(0);
        viewPagerTab.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rbtMenuHome.setChecked(true);
                        break;
                    case 1:
                        rbtMenuWeitao.setChecked(true);
                        break;
                    case 2:
                        rbtMenuShopcar.setChecked(true);
                        break;
                    case 3:
                        rbtMenuMime.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                LogUtil.d("onPageScrollStateChanged"+state);
            }
        });
        rgpTabGroup.setOnCheckedChangeListener(this);
    }

    private void initData() {
        mTabFragmentList = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        MessageFragment messageFragment = new MessageFragment();
        ShopCarFragment shopCarFragment = new ShopCarFragment();
        MineFragment mineFragment = new MineFragment();
        mTabFragmentList.add(homeFragment);
        mTabFragmentList.add(messageFragment);
        mTabFragmentList.add(shopCarFragment);
        mTabFragmentList.add(mineFragment);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbt_menu_home:
                viewPagerTab.setCurrentItem(0);
                break;
            case R.id.rbt_menu_weitao:
                viewPagerTab.setCurrentItem(1);
                break;
            case R.id.rbt_menu_shopcar:
                viewPagerTab.setCurrentItem(2);
                break;
            case R.id.rbt_menu_mime:
                viewPagerTab.setCurrentItem(3);
                break;
        }
    }
}

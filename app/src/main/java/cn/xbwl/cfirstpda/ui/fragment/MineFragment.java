package cn.xbwl.cfirstpda.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.xbwl.cfirstpda.R;
import cn.xbwl.cfirstpda.base.AbsTabFragment;

/**
 * Created by chenjinglan on 2017/11/8.
 * email:13925024285@163.com
 */

public class MineFragment extends AbsTabFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container,false);
//        initToolBar("我的");
        return view;
    }
}

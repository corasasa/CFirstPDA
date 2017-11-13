package cn.xbwl.cfirstpda.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.xbwl.cfirstpda.R;
import cn.xbwl.cfirstpda.adapter.ImageAdapter;
import cn.xbwl.cfirstpda.base.AbsTabFragment;
import cn.xbwl.cfirstpda.utils.LogUtil;

/**
 * Created by chenjinglan on 2017/11/8.
 * email:13925024285@163.com
 */

public class HomeFragment extends AbsTabFragment {

    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.iv_share)
    ImageView ivShare;
    @BindView(R.id.rlv_imgs)
    RecyclerView rlvImgs;
    Unbinder unbinder;
    private ArrayList<String> mImageUrls;

    private ArrayList<String> getImageUrls() {
        ArrayList<String> urls = new ArrayList<>();
        for (int i = 0; i < 29; i++) {
            urls.add("http://192.168.8.56:8080/imageLoad/mike" + i + ".jpg");
        }
        return urls;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        mImageUrls = getImageUrls();
        initRecycleView();
        return rootView;
    }

    private void initRecycleView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rlvImgs.setLayoutManager(linearLayoutManager);
        ImageAdapter adapter = new ImageAdapter(mImageUrls, getActivity());
        rlvImgs.setAdapter(adapter);
        Picasso.with(getActivity()).setIndicatorsEnabled(true);
        rlvImgs.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LogUtil.d("newState="+newState);
//                if (newState != AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
//                    Picasso.with(getActivity()).pauseTag("imgload");
//                } else  {
//                    Picasso.with(getActivity()).resumeTag("imgload");
//                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

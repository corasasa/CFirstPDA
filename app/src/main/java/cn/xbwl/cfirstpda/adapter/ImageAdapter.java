package cn.xbwl.cfirstpda.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.xbwl.cfirstpda.R;

/**
 * Created by chenjinglan on 2017/11/10.
 * email:13925024285@163.com
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private List<String> mUrls;
    private Context mContext;

    public ImageAdapter(List<String> urls, Context context) {
        this.mUrls = urls;
        this.mContext = context;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_image_list, null);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        String url = mUrls.get(position);
        holder.tvImgName.setText(url);
        Picasso.with(mContext)
                .load(url)
                .placeholder(R.mipmap.photo_nopic)
                .error(R.mipmap.photo_nopic)
                .tag("imgload")
                .memoryPolicy(MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_STORE)
                .into(holder.img);
    }


    @Override
    public int getItemCount() {
        return mUrls.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tv_img_name)
        TextView tvImgName;
        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

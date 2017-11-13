package cn.xbwl.cfirstpda.http;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import cn.xbwl.cfirstpda.constant.Constant;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by chenjinglan on 2017/10/26.
 * email:13925024285@163.com
 * Retrofit 获取APIService
 */

public class RetrofitManager<T> {
    private static RetrofitManager mRetrofitManager = new RetrofitManager();
    private final Retrofit mRetrofit;
    private final Retrofit mPubRetrofit;

    private RetrofitManager() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .client(OkHttpManager.getInstance().getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());
        mRetrofit = builder.client(OkHttpManager.getInstance().getOkHttpClient()).build();
        mPubRetrofit = builder.client(OkHttpManager.getInstance().getPubOkHttpClient()).build();
    }

    public static RetrofitManager getInstance() {
        if (mRetrofitManager == null) {
            mRetrofitManager = new RetrofitManager();
        }
        return mRetrofitManager;
    }

    public APIService getService() {
        return mRetrofit.create(APIService.class);
    }

    public APIService getPubService() {
        return mPubRetrofit.create(APIService.class);
    }
}

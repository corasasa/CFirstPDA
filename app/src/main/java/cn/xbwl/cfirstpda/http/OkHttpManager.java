package cn.xbwl.cfirstpda.http;

import android.support.graphics.drawable.animated.BuildConfig;

import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;

/**
 * Created by chenjinglan on 2017/10/26.
 * email:13925024285@163.com
 * 定义网络请求基础参数：响应时间，是否失败重试，是否打印请求日志等
 */

public class OkHttpManager {
    private static OkHttpManager mOkHttpManager = new OkHttpManager();
    private final OkHttpClient.Builder mOkHttpBuilder;
    private static final int CONNETIME = 30000;
    private static final int READTIME = 30000;
    private static final int WRITETIME = 30000;

    private OkHttpManager() {
        mOkHttpBuilder = new OkHttpClient.Builder()
        .connectTimeout(CONNETIME, TimeUnit.SECONDS)//连接超时
        .readTimeout(READTIME,TimeUnit.SECONDS)//响应超时
        .writeTimeout(WRITETIME,TimeUnit.SECONDS)//响应超时
        .retryOnConnectionFailure(true)//是否失败重连
        .addInterceptor(new LoggingInterceptor.Builder()//拦截日志
//                .loggable(BuildConfig.DEBUG)//自动识别是否是debug模式
                .loggable(true)//自动识别是否是debug模式
                .setLevel(Level.BASIC)
                .log(Platform.INFO)
                .addHeader("version", BuildConfig.VERSION_NAME)
                .request("Request")
                .response("Response")
                .build());
    }

    public static OkHttpManager getInstance() {
        if (mOkHttpManager == null) {
            mOkHttpManager = new OkHttpManager();
        }
        return mOkHttpManager;
    }

    //不添加请求头
    public OkHttpClient getOkHttpClient(){
        return mOkHttpBuilder.build();
    }

    //添加请求头信息
    public  OkHttpClient getPubOkHttpClient() {
        return  mOkHttpBuilder.addInterceptor(new  HeaderInterceptor()).build();
    }
}

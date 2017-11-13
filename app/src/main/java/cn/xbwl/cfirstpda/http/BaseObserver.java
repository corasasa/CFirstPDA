package cn.xbwl.cfirstpda.http;

import android.app.Activity;
import android.app.ProgressDialog;
import android.database.SQLException;
import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.google.gson.stream.MalformedJsonException;

import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import cn.xbwl.cfirstpda.exception.ApiException;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by chenjinglan on 2017/11/6.
 * email:13925024285@163.com
 * 观察者
 */

public abstract class BaseObserver<T> implements Observer<T> {

    private Activity mActivity;
    private String mTipMsg;
    private ProgressDialog mProgressDialog;
    private boolean mIsShowDialog;

    public BaseObserver(Activity activity, String tipMsg, boolean isShowDialog) {
        this.mActivity = activity;
        this.mTipMsg = tipMsg;
        this.mIsShowDialog = isShowDialog;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
        showLoadingDialog();
    }

    @Override
    public void onNext(@NonNull T t) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(5000);
//                    dismissDialog();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
        dismissDialog();
        onSuccess(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        dismissDialog();
        e.printStackTrace();
        String errorMsgTip = "";
        if (e instanceof HttpException) {
            errorMsgTip = "网络连接错误，请稍后重试";
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException
                || e instanceof MalformedJsonException
                || e instanceof IOException) {
            errorMsgTip = "解析数据失败，请稍后重试";
        } else if (e instanceof ConnectException) {
            errorMsgTip = "网络连接失败，请检查网络";
        } else if (e instanceof SocketTimeoutException) {
            errorMsgTip = "网络连接超时，请稍后重试";
        } else if (e instanceof SQLException) {
            errorMsgTip = "数据操作失败，请稍后重试";
        } else if (e instanceof ApiException) {
            errorMsgTip = e.getMessage();
        } else {
            errorMsgTip = "未知错误，请稍后重试";
        }
        onFail(e);
        onFail(errorMsgTip);
    }

    @Override
    public void onComplete() {

    }

    private void showLoadingDialog() {
        if (mActivity == null || !mIsShowDialog) {
            return;
        }
        if (mProgressDialog==null){
            mProgressDialog = new ProgressDialog(mActivity);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setMessage(mTipMsg);
        }
        mProgressDialog.show();
    }

    private void dismissDialog(){
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public abstract void onSuccess(T t);

    public void onFail(Throwable t) {

    }


    public void onFail(String msg) {
    }
}

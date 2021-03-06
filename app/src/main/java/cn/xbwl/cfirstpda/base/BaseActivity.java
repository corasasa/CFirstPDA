package cn.xbwl.cfirstpda.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import cn.xbwl.cfirstpda.entity.response.HttpResult;
import cn.xbwl.cfirstpda.exception.ApiException;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenjinglan on 2017/11/6.
 * email:13925024285@163.com
 */

public class BaseActivity extends RxAppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public <T>Observable<T> beginHttpSuscriber(Observable<HttpResult<T>> observable) {
        return observable.map(new Function<HttpResult<T>, T>() {
            @Override
            public T apply(@NonNull HttpResult<T> tHttpResult) {
                if (tHttpResult != null) {
                    if (tHttpResult.isSuccess()) {
                        return tHttpResult.getData();
                    } else {
                        throw new ApiException(tHttpResult.getReason());
                    }
                } else {
                    throw new ApiException("服务器异常");
                }
            }
        }).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<T>bindToLifecycle());
    }

    public <T>Observable<T> beginDBSubscriber(Observable<T> observable){
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(this.<T>bindToLifecycle());
    }
}

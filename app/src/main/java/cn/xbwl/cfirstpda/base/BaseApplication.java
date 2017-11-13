package cn.xbwl.cfirstpda.base;

import android.app.Application;

/**
 * Created by chenjinglan on 2017/10/27.
 * email:13925024285@163.com
 */

public class BaseApplication extends Application {

    private static BaseApplication mBaseApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        mBaseApplication = this;

    }

    public static BaseApplication getBaseApplication() {
        return mBaseApplication;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}

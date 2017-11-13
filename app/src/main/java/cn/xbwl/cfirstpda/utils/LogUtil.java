package cn.xbwl.cfirstpda.utils;

import android.util.Log;

/**
 * Created by chenjinglan on 2017/11/8.
 * email:13925024285@163.com
 */

public class LogUtil {
    private static boolean isDebug=true;

    public static void d(String str) {
        if (isDebug) {
            Log.d("test", str);
        }
    }
    public static void e(String str) {
        if (isDebug) {
            Log.e("test", str);
        }
    }
}

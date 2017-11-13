package cn.xbwl.cfirstpda.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import cn.xbwl.cfirstpda.base.BaseApplication;
import cn.xbwl.cfirstpda.entity.response.UserInfo;

/**
 * Created by chenjinglan on 2017/10/27.
 * email:13925024285@163.com
 * sharepreference 缓存信息工具类
 */

public class SPUtil {
    private static SharedPreferences getSp() {
        BaseApplication baseApplication = BaseApplication.getBaseApplication();
        if (baseApplication==null){
            Log.e("test","baseApplication==null");
        }
        return baseApplication.getSharedPreferences("CFirstPDA_Config", Context.MODE_PRIVATE);
    }

    public static boolean putString(String key, String value) {
        return getSp().edit().putString(key, value).commit();
    }

    public static String getString(String key) {
        return getSp().getString(key, "");
    }

    public static boolean putInt(String key, int value) {
        return getSp().edit().putInt(key, value).commit();
    }

    public static int getInt(String key) {
        return getSp().getInt(key, 0);
    }

    public static boolean putBoolean(String key, boolean value) {
        return getSp().edit().putBoolean(key, value).commit();
    }

    public static boolean getBoolean(String key) {
        return getSp().getBoolean(key, false);
    }

    public static boolean putFloat(String key, float value) {
        return getSp().edit().putFloat(key, value).commit();
    }

    public static float getFloat(String key) {
        return getSp().getFloat(key, 0);
    }

    public static boolean putLong(String key, long value) {
        return getSp().edit().putLong(key, value).commit();
    }

    public static float getLong(String key) {
        return getSp().getLong(key, 0);
    }

    public static boolean putUserInfo(UserInfo userInfo){
        return putString("UserInfo",new Gson().toJson(userInfo));
    }

   public static UserInfo getUserInfo() {
       String userInfo = getString("UserInfo");
       if (TextUtils.isEmpty(userInfo)) {
           return null;
       } else {
           return new Gson().fromJson(userInfo, UserInfo.class);
       }
   }
}

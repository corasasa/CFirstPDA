package cn.xbwl.cfirstpda.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by chenjinglan on 2017/10/26.
 * email:13925024285@163.com
 */

public class ToastUtil {

    public static void showString(Context context,String tip){
        Toast.makeText(context,tip,Toast.LENGTH_SHORT).show();
    }

    public static void showTopString(Context context, String tip) {
        Toast toast = Toast.makeText(context, tip, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 150);
        toast.show();
    }

    public static void showIntString(Context context,int resId){
        Toast.makeText(context,resId,Toast.LENGTH_SHORT).show();
    }

    public static void showNetError(Context context){
        Toast.makeText(context,"网络错误，请稍后再试",Toast.LENGTH_SHORT).show();
    }
}

package cn.xbwl.cfirstpda.utils;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by chenjinglan on 2017/10/26.
 * email:13925024285@163.com
 */

public class IntentUtil {

    public static void startActivity(Activity activityA,Class<?> claz) {
        Intent intent = new Intent(activityA, claz);
        activityA.startActivity(intent);
    }

    public static void startAndFinishActivity(Activity activityA,Class<?> claz){
        Intent intent = new Intent(activityA, claz);
        activityA.startActivity(intent);
        activityA.finish();
    }

    public static void startActivityAnim(Activity activityA,Class<?> claz){
        Intent intent = new Intent(activityA, claz);
        activityA.startActivity(intent);
        activityA.finish();
    }

    public static void startAndFinishActivity(Activity activityA,Class<?> claz,int tag){
        Intent intent = new Intent(activityA, claz);
        intent.putExtra("ActivityTag",tag);
        activityA.startActivity(intent);
        activityA.finish();
    }

}

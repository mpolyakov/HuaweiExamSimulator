package com.kt.std.quizeg1.utilities;

import android.app.Activity;
import android.content.Intent;

public class ActivityUtilities {
    private static ActivityUtilities activityUtilities = null;
    public static ActivityUtilities getInstance(){
        if (activityUtilities == null){
            activityUtilities = new ActivityUtilities();
        }
        return activityUtilities;
    }

    public void invokeNewActivity(Activity activity, Class<?> tClass, boolean shouldFinish){
        Intent intent = new Intent(activity, tClass);
        activity.startActivity(intent);
        if (shouldFinish){
            activity.finish();
        }



    }
}

package cn.wqgallery.mytitlecolor.util;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2019/3/19.
 * 状态栏 字体 背景 颜色 修改（为了适配低版本和灵活控制，首先去掉状态栏高度 在布局定义个view作为状态栏，这样就可以灵活控制）
 */

public class StatusBarUtils {

    private StatusBarUtils() {
    }

    private static final StatusBarUtils statusBarUtils = new StatusBarUtils();

    public static StatusBarUtils getInstance() {
        return statusBarUtils;
    }

    /**
     * 去掉状态栏
     */
    public void setNoStatusBar(Activity activity) {
        // 5.0 以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }


    /**
     * ------------------
     * 修改状态来字体颜色
     */
    public void setStatusBarTextColor(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //支持修改字体为黑色
            activity.getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        //其他默认白色
    }


    /**
     * ------------------
     * 修改状态来字体颜色
     */
    public void setStatusBarColor(Activity activity, View baseStatusBar, int alterColor, int noAlterColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //支持修改字体为黑色
            activity.getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            setStatusBarColor(activity, baseStatusBar, alterColor);
        } else {
            //字体白色
            setStatusBarColor(activity, baseStatusBar, noAlterColor);
        }
    }


    /**
     * ---------------------
     * 设置状态栏颜色
     */
    public void setStatusBarColor(Activity activity, View baseStatusBar, int color) {
        baseStatusBar.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusStateBarHeight(activity)));//填充状态栏
        baseStatusBar.setBackgroundResource(color);
    }

    /**
     * 设置状态栏颜色
     * 自定义状态栏高度
     */
    public void setStatusBarColor(View baseStatusBar, int color, int height) {
        baseStatusBar.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height));//填充状态栏
        baseStatusBar.setBackgroundResource(color);
    }

    /**
     * 获取状态栏高度,在页面还没有显示出来之前
     */
    public int getStatusStateBarHeight(Activity activity) {
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


}

package cn.wqgallery.mytitlecolor;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;

import cn.wqgallery.mytitlecolor.util.StatusBarUtils;

public class MainActivity extends BaseActivity {

    ConstraintLayout constraintLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = setBodyView(R.layout.activity_main);
        // ButterKnife.bind(this, view);
        constraintLayout = (ConstraintLayout) findViewById(R.id.cl_layout);
    }


    //去掉状态栏
    public void bt1(View view) {
        StatusBarUtils.getInstance().setNoStatusBar(this);

    }

    //修改字体和状态栏颜色
    public void bt2(View view) {
        StatusBarUtils.getInstance().setNoStatusBar(this);
        StatusBarUtils.getInstance().setStatusBarColor(this,baseStatusBar,R.color.white,R.color.titleTop);
    }


    //滑动设置状态栏颜色变化
    public void bt3(View view) {
        startActivity(new Intent(this,ScrollActivity.class));


    }

    //滑动设置状态栏颜色变化
    public void bt4(View view) {
        startActivity(new Intent(this,RecyclerActivity.class));
    }




}

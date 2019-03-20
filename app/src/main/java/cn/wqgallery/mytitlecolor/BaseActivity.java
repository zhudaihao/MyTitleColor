package cn.wqgallery.mytitlecolor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2019/3/19.
 */

public class BaseActivity extends AppCompatActivity {
    protected LinearLayout baseLlLayout;
    protected View baseStatusBar, baseViewLine;
    protected RelativeLayout baseRlTitleBar;
    protected TextView baseTitle, baseTvLeft, baseTvRight;
    protected ViewGroup contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initView();
    }

    /**
     * 基类基础控件
     */
    private void initView() {
        baseLlLayout = (LinearLayout) findViewById(R.id.base_ll_layout);
        baseStatusBar = (View) findViewById(R.id.base_status_bar);
        baseViewLine = findViewById(R.id.base_view_line);
        baseRlTitleBar = (RelativeLayout) findViewById(R.id.base_title_bar);
        baseTitle = (TextView) findViewById(R.id.base_title);
        baseTvLeft = (TextView) findViewById(R.id.base_tv_left);
        baseTvRight = (TextView) findViewById(R.id.base_tv_right);
        contentView = (ViewGroup) findViewById(R.id.base_content);
    }


    /**
     * 设置内容页面
     * 子类在onCreate方法里面实现这方法
     * layoutId为子类的布局ID
     */
    protected View setBodyView(int layoutId) {
        return View.inflate(this, layoutId, contentView);

    }



}

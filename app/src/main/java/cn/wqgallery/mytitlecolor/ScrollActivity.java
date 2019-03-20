package cn.wqgallery.mytitlecolor;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.wqgallery.mytitlecolor.util.ObservableScrollView;
import cn.wqgallery.mytitlecolor.util.StatusBarUtils;


/**
 * Created by Administrator on 2019/3/19.
 */

public class ScrollActivity extends BaseActivity {
    @BindView(R.id.oScroll_view)
    ObservableScrollView oScrollView;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.view_line)
    View viewLine;
    @BindView(R.id.view_status_bar)
    View viewStatusBar;
    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = setBodyView(R.layout.activity_color);
        ButterKnife.bind(this, view);

        initView();
    }

    private void initView() {
        baseRlTitleBar.setVisibility(View.GONE);
        //修改状态栏颜色
        StatusBarUtils.getInstance().setNoStatusBar(this);
        //监听滑动变化
        oScrollView.setOnScrollChangedListener(new ObservableScrollView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldX, int oldY) {
                setColor(rlTitle);

            }
        });

    }


    private static final int highView = 300;
    //改变title背景颜色
    private void setColor(View viewLayout) {
        //获取滑动距离，，通过布局管理器
        //1.获得视图的第一条木的下标
        //2.根据下标获得view条目,,,在获得条目的高度
        //3.下标*条目高度-可见视图距离顶部的高度
        int y = oScrollView.getScrollY();
        StatusBarUtils.getInstance().setStatusBarTextColor(this);
        if (y <= 0) {   //设置标题的背景颜色
            viewLayout.setBackgroundColor(Color.argb((int) 0, 255, 255, 255));
            viewLine.setVisibility(View.GONE);
            tvTitle.setTextColor(getResources().getColor(R.color.white));
            ivBack.setImageResource(R.mipmap.back_white);
            viewStatusBar.setVisibility(View.GONE);
        } else if (y > 0 && y <= highView) {
            //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
            float scale = (float) y / highView;
            float alpha = (255 * scale);
            viewLayout.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));
            tvTitle.setTextColor(getResources().getColor(R.color.black));
            ivBack.setImageResource(R.mipmap.back_white);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                viewStatusBar.setVisibility(View.GONE);
            } else {
                viewStatusBar.setVisibility(View.VISIBLE);
            }

            if (y > 280) {
                viewLine.setVisibility(View.VISIBLE);
            } else {
                if (y < 60) {
                    tvTitle.setTextColor(getResources().getColor(R.color.white));
                    ivBack.setImageResource(R.mipmap.back_white);
                    viewStatusBar.setVisibility(View.GONE);
                }
                viewLine.setVisibility(View.GONE);

            }

        } else {
            //16进制#F9BE18转换aRGB a为透明度（不断修改透明度） 249,190,24
            viewLayout.setBackgroundColor(Color.argb((int) 255, 255, 255, 255));
            tvTitle.setTextColor(getResources().getColor(R.color.black));
            ivBack.setImageResource(R.mipmap.back_white);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                viewStatusBar.setVisibility(View.GONE);
            } else {
                viewStatusBar.setVisibility(View.VISIBLE);
            }

            if (y > 280) {
                viewLine.setVisibility(View.VISIBLE);
            } else {
                if (y < 60) {
                    tvTitle.setTextColor(getResources().getColor(R.color.white));
                    ivBack.setImageResource(R.mipmap.back_white);
                    viewStatusBar.setVisibility(View.GONE);
                }
                viewLine.setVisibility(View.GONE);
            }

        }


    }
}

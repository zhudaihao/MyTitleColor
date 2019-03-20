package cn.wqgallery.mytitlecolor;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019/3/20.
 */

public class RecyclerActivity extends BaseActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.rl_title)
    RelativeLayout rlTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = setBodyView(R.layout.activity_recycler);
        ButterKnife.bind(this, view);

        initView();


    }

    private LinearLayoutManager linearLayoutManager;

    private void initView() {
        baseRlTitleBar.setVisibility(View.GONE);
//        //修改状态栏颜色
//        StatusBarUtils.getInstance().setNoStatusBar(this);


        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("李四");
        list.add("李四");
        list.add("李四");
        list.add("李四");
        list.add("李四");
        list.add("李四");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("李四");
        list.add("李四");
        list.add("李四");
        list.add("李四");
        list.add("李四");
        list.add("李四");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("张三");
        list.add("李四");
        list.add("李四");
        list.add("李四");
        list.add("李四");
        list.add("李四");
        list.add("李四");
        recyclerView.setAdapter(new RcyclerAdapter(list));


        //监听滑动变化
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                setColor(rlTitle);

            }
        });
    }


    //改变title背景颜色
    private void setColor(RelativeLayout rl_layout) {
        //获取滑动距离，，通过布局管理器
        //1.获得视图的第一条木的下标
        //2.根据下标获得view条目,,,在获得条目的高度
        //3.下标*条目高度-可见视图距离顶部的高度
        int position = linearLayoutManager.findFirstVisibleItemPosition();
        View view = linearLayoutManager.findViewByPosition(position);
        int itemHeight = view.getHeight();
        int y = (position) * itemHeight - view.getTop();

        if (rl_layout == null) {
         //空对象
            return;
        }

        if (y <= 0) {   //设置标题的背景颜色
            rl_layout.setBackgroundColor(Color.argb((int) 0, 249, 190, 24));
        } else if (y > 0 && y <= 300) {
            //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
            float scale = (float) y / 300;
            float alpha = (255 * scale);
            rl_layout.setBackgroundColor(Color.argb((int) alpha, 249, 190, 24));
        } else {    //滑动到banner下面设置普通颜色
            //16进制#F9BE18转换aRGB a为透明度（不断修改透明度） 249,190,24
            rl_layout.setBackgroundColor(Color.argb((int) 255, 249, 190, 24));
        }
    }

}

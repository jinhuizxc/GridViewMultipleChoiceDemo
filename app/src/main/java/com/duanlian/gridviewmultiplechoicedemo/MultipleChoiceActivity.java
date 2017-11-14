package com.duanlian.gridviewmultiplechoicedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceActivity extends AppCompatActivity {
    private GridView mGridView;
    private GridViewAdapter mGridViewAdapter;
    private List<String> mList;
    private String[] channel = {"娱乐", "财经", "军事", "足球", "篮球", "体育", "电影", "房产",
            "电台", "汽车", "手机", "时尚", "论坛", "彩票", "暴雪", "社会", "情感", "教育", "家居", "游戏",
            "科技", "数码", "旅游", "周杰伦", "亲情", "段炼", "Android", "IOS", "移动", "星座", "风水"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice_avtivity);
        initView();
    }

    private void initView() {
        mGridView = (GridView) findViewById(R.id.gv_channel);
        //添加数据
        mList = new ArrayList<>();
        for (int i = 0; i < channel.length; i++) {
            mList.add(channel[i]);
        }
        mGridViewAdapter = new GridViewAdapter(this, mList);
        mGridView.setAdapter(mGridViewAdapter);
        //GridView的item的点击事件
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //将当前点击的position传递过去做相应的状态改变
                mGridViewAdapter.choiceState(position);
            }
        });

    }

    /**
     * button点击事件的监听
     *
     * @param view
     */
    public void addChannel(View view) {
        switch (view.getId()) {
            case R.id.tv_check_all://全选
                mGridViewAdapter.changeState(2);
                break;
            case R.id.tv_invert://反选
                mGridViewAdapter.changeState(1);
                break;
            case R.id.btn_sure://确定按钮
                setResult(999,new Intent());
                finish();
                break;
        }
    }
}

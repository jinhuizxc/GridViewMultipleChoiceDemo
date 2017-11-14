package com.duanlian.gridviewmultiplechoicedemo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.duanlian.gridviewmultiplechoicedemo.database.DataBase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private ListViewAdapter mListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.listview);
        mListViewAdapter = new ListViewAdapter(this, getData());
        mListView.setAdapter(mListViewAdapter);
    }

    /**
     * button的点击监听
     * @param view
     */
    public void buttonClick(View view) {
        //跳转到筛选的activity
        Intent intent = new Intent(MainActivity.this, MultipleChoiceActivity.class);
        //通过带返回值的跳转来的到下一个页面带过来的值
        startActivityForResult(intent,888);
    }
    /**
     * 通过查找数据库,拿到里面的数据
     */
    private List<String> getData() {
        List<String> list = new ArrayList<>();
        Cursor query = DataBase.getInstances(this).query();
        if (query.moveToFirst()) {
            do {
                String channel = query.getString(query.getColumnIndex("channel"));
                list.add(channel);
            } while (query.moveToNext());
        }
        //关闭查询游标
        query.close();
        return list;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 888 && resultCode == 999) {
            mListViewAdapter = new ListViewAdapter(this, getData());
            mListView.setAdapter(mListViewAdapter);
        }
    }
}

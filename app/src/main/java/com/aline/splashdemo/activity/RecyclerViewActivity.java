package com.aline.splashdemo.activity;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aline.splashdemo.R;
import com.aline.splashdemo.adapter.HashMapAdapter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecyclerViewActivity extends BaseActivity {
    private static final String TAG = "RecyclerViewActivity";
    private LinkedHashMap<String, String> dataMaps = new LinkedHashMap<String, String>();
    private List<String> datas = new ArrayList<>();

    @Override
    protected void initData() {
        for (int i = 0; i < 25; i++) {
            dataMaps.put("姓名" + i, i + "岁");
            datas.add("姓名" + i);
        }
        //有序集合
        Set<Map.Entry<String, String>> entrySet = dataMaps.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            Log.e(TAG, "key: " + entry.getKey() + "..value:" + entry.getValue());
        }
    }

    @Override
    protected void initView() {
        RecyclerView recyclerView = findViewById(R.id.rv_data);
        HashMapAdapter adapter = new HashMapAdapter(RecyclerViewActivity.this, datas);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_recycler_view;
    }
}
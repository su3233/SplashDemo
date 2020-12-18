package com.aline.splashdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.aline.splashdemo.adapter.FeedbackDetailAdapter;
import com.aline.splashdemo.entity.LocalFeedbackBean;

import java.util.ArrayList;
import java.util.List;

public class TestParcelableActivity extends AppCompatActivity {
    private static final String TAG = "TestParcelableActivity";
    private static final String PARA = "para";
    private ArrayList<LocalFeedbackBean.DataBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_parcelable);
        list = getIntent().getParcelableArrayListExtra(PARA);
        for (int i = 0; i < list.size(); i++) {
            LocalFeedbackBean.DataBean dataBean = list.get(i);
            Log.e(TAG, dataBean.getContent() + ".... " + dataBean.getTitle());
        }
        initView();
    }

    public static void lunch(Activity activity, ArrayList<LocalFeedbackBean.DataBean> list) {
        Intent intent = new Intent(activity, TestParcelableActivity.class);
        intent.putParcelableArrayListExtra(PARA, list);
        activity.startActivity(intent);
    }

    private void initView() {
//        RecyclerView rvPar = findViewById(R.id.rv_rest_par);
//        adapter = new FeedbackDetailAdapter(mContext, mList);
//        rvFeedbackDetail.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
//        rvFeedbackDetail.setLayoutManager(linearLayoutManager);
//        rvFeedbackDetail.setAdapter(adapter);
    }
}
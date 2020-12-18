package com.aline.splashdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.aline.splashdemo.R;
import com.aline.splashdemo.entity.LocalFeedbackBean;
import com.aline.splashdemo.entity.WorkbenchNewBean;
import com.aline.splashdemo.utils.ListSortUtils;
import com.aline.splashdemo.utils.ReadAssetsJsonUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试工作台数据转换使用Comparetor
 *
 * @author SuTs
 * @create 2020/11/24 11:39
 * @Describe
 */
public class TestWorkBenchActivity extends BaseActivity {
    private static final String TAG = "TestWorkBenchActivity";

    @Override
    protected void initData() {
        List<WorkbenchNewBean.DataBean.WorkbenchesBean> newsList = new ArrayList<>();
        List<WorkbenchNewBean.DataBean.WorkbenchesBean> appList = new ArrayList<>();
        String json = ReadAssetsJsonUtils.readJsonFromAsset(this, "contacts.json");
        if (!TextUtils.isEmpty(json)) {
            WorkbenchNewBean workbenchNewBean = new Gson().fromJson(json, WorkbenchNewBean.class);
            WorkbenchNewBean.DataBean.WorkbenchesBean typeBean = workbenchNewBean.getData().getWorkbenches().get(2);
            try {
//                Log.e(TAG, "initData: " + (ListSortUtils.forceGetFieldValue(typeBean, "FunParent") instanceof String));
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (int i = 0; i < workbenchNewBean.getData().getWorkbenches().size(); i++) {
                WorkbenchNewBean.DataBean.WorkbenchesBean bean = workbenchNewBean.getData().getWorkbenches().get(i);
                if (bean.getFunParent().equals("0") && bean.getFunChild().equals("0")) {
                    newsList.add(bean);
                }
                if (bean.getFunParent().equals("0") && bean.getFunChild().equals("1")) {
                    appList.add(bean);
                }
            }

            for (int i = 0; i < newsList.size(); i++) {
                Log.e(TAG, "newsList前: " + newsList.get(i).getFunName());
            }

            Log.e(TAG, "initData:============================================== ");

            for (int i = 0; i < appList.size(); i++) {
                Log.e(TAG, "appList前: " + appList.get(i).getFunName());
            }

            Log.e(TAG, "initData:============================================== ");

            String[] sortNameArr = {"OrderID", "FunWBS"};
            boolean[] isAscArr = {true, true};
            ListSortUtils.sort(newsList, sortNameArr, isAscArr);
            ListSortUtils.sort(appList, true, "OrderID");

            for (int i = 0; i < newsList.size(); i++) {
                Log.e(TAG, "newsList: " + newsList.get(i).getFunName());
            }

            Log.e(TAG, "initData:============================================== ");

            for (int i = 0; i < appList.size(); i++) {
                Log.e(TAG, "appList: " + appList.get(i).getFunName());
            }
//            Log.e(TAG, "newsList: " + newsList.size() + "---appList:" + appList.size());

//            list.addAll(localFeedbackBean.getData());
//            adapter = new FeedbackAdapter(getActivity(), list);
//            rvFeedback.setHasFixedSize(true);
//            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//            rvFeedback.setLayoutManager(linearLayoutManager);
//            rvFeedback.setAdapter(adapter);
        }

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_test_work_bench;
    }
}
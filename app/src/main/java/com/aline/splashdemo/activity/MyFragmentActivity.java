package com.aline.splashdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aline.splashdemo.R;
import com.aline.splashdemo.fragment.ParaFragment;

public class MyFragmentActivity extends AppCompatActivity {

    private ParaFragment paraFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);
        initView();
    }

    private void initView() {
        final TextView tv_showPara = findViewById(R.id.tv_show_para);
        findViewById(R.id.bt_get_para).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (paraFragment != null) {
                    String para = paraFragment.getFragmentPara();
                    tv_showPara.setText(para);
                }
            }
        });
        FragmentManager manager = getSupportFragmentManager();
        paraFragment = new ParaFragment();
        manager.beginTransaction().replace(R.id.ll_fragment_content, paraFragment).commit();
    }
}
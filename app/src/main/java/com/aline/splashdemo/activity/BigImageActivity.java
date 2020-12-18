package com.aline.splashdemo.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.aline.splashdemo.R;
import com.aline.splashdemo.utils.BigImageviewUtils;
import com.aline.splashdemo.view.MyBigImageview;

public class BigImageActivity extends BaseActivity {

    //    private MyBigImageview iv_big;
    private ImageView iv_big;


    @Override
    protected int initLayout() {
        return R.layout.activity_big_image;
    }

    @Override
    protected void initView() {
//        iv_big = findViewById(R.id.iv_big_iamge);
        iv_big = findViewById(R.id.iv_big_iamge);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.iv_big);
//        iv_big.setImageBitmap(bitmap);
        iv_big.setImageBitmap(BigImageviewUtils.convertBitmapWithImageView(getResources(), R.drawable.iv_big, iv_big));
    }

    @Override
    protected void initData() {

    }
}
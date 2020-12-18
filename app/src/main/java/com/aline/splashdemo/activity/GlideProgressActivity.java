package com.aline.splashdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.aline.splashdemo.R;
import com.aline.splashdemo.glide.ProgressInterceptor;
import com.aline.splashdemo.glide.ProgressListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;

public class GlideProgressActivity extends AppCompatActivity {

    private ImageView image;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_progress);
        initView();
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("加载中");
    }

    private void initView() {
        image = (ImageView) findViewById(R.id.image);
        findViewById(R.id.bt_show_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                final String url = "http://guolin.tech/book.png";//
                final String url = "http://guolin.tech/test.gif";//
                ProgressInterceptor.addListener(url, new ProgressListener() {
                    @Override
                    public void onProgress(int progress) {
                        progressDialog.setProgress(progress);
                    }
                });

                Glide.with(GlideProgressActivity.this)
                        .load(url)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                        .into(new GlideDrawableImageViewTarget(image) {
                            @Override
                            public void onLoadStarted(Drawable placeholder) {
                                super.onLoadStarted(placeholder);
                                progressDialog.show();
                            }

                            @Override
                            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                                super.onResourceReady(resource, animation);
                                progressDialog.dismiss();
                                ProgressInterceptor.removeListener(url);
                            }
                        });
            }
        });

    }

}
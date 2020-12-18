package com.aline.splashdemo.glide;

import android.content.Context;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;

import java.io.InputStream;

import okhttp3.OkHttpClient;

/**
 * @author SuTs
 * @create 2020/11/24 18:41
 * @Describe
 */

//public class MyOkhttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {
//
//    private OkHttpClient mOkHttpClient;
//
//
//
//    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
//        private OkHttpClient mClient;
//
//        public Factory() {
//
//        }
//
//        @Override
//        public ModelLoader<GlideUrl, InputStream> build(Context context, GenericLoaderFactory factories) {
//            return new MyOkhttpGlideUrlLoader(getOkHttpClient());
//        }
//
//        @Override
//        public void teardown() {
//            // Do nothing.
//        }
//
//        private synchronized OkHttpClient getOkHttpClient() {
//            if (null == mClient) {
//                mClient = new OkHttpClient();
//            }
//            return mClient;
//        }
//    }
//
//    public MyOkhttpGlideUrlLoader(OkHttpClient okHttpClient) {
//        this.mOkHttpClient = okHttpClient;
//    }
//    @Override
//    public DataFetcher<InputStream> getResourceFetcher(GlideUrl model, int width, int height) {
//        return new MyOkhttpGlideUrlLoader(model, mOkHttpClient);
//    }
//
//
//}

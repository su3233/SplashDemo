package com.aline.mylibrary;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * @author SuTs
 * @create 2020/11/10 15:23
 * @Describe
 */
public class Test {
    public static void main(String[] args) {
        testLurCache();

    }

    private static void testLurCache() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        LruCache<String, Bitmap> lruCache = new LruCache<>(maxMemory / 8);
        lruCache.put("", null);
        lruCache.get("");
    }
}

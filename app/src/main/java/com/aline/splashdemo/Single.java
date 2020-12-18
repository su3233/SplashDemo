package com.aline.splashdemo;

/**
 * @author SuTs
 * @create 2020/11/6 19:32
 * @Describe
 */
public class Single {
    private static final Single ourInstance = new Single();

    static Single getInstance() {
        return ourInstance;
    }

    private Single() {
    }
}

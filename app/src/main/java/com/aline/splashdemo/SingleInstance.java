package com.aline.splashdemo;

/**
 * @author SuTs
 * @create 2020/11/2 10:22
 * @Describe
 */
class SingleInstance {
    private static final SingleInstance ourInstance = new SingleInstance();

    static SingleInstance getInstance() {
        return ourInstance;
    }

    private SingleInstance() {
    }
}

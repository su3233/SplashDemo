package com.aline.splashdemo.http;

/**
 * @author SuTs
 * @create 2020/12/10 11:14
 * @Describe
 */
class ISingleton {
    private static final ISingleton ourInstance = new ISingleton();

    static ISingleton getInstance() {
        return ourInstance;
    }

    private ISingleton() {
    }
}

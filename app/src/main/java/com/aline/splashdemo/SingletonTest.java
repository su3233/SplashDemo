package com.aline.splashdemo;

/**
 * @author SuTs
 * @create 2020/11/6 19:30
 * @Describe
 */
public class SingletonTest {
    private static final SingletonTest instance = new SingletonTest();

    static SingletonTest getInstance() {
        return instance;
    }

    private SingletonTest() {
    }

    private void callInstance() {
        SingleInstance.getInstance();
    }
}

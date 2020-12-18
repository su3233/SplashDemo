package com.aline.splashdemo.http;

/**
 * @author SuTs
 * @create 2020/12/10 10:55
 * @Describe
 */
public interface IRequestManager {
    void getRequest(String url, String para, ICallback iCallback);

    void postRequest(String url, String para, ICallback iCallback);

    void deleteRequest(String url, String para, ICallback iCallback);
}

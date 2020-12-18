package com.aline.splashdemo.http;

/**
 * @author SuTs
 * @create 2020/12/10 10:57
 * @Describe
 */
public interface ICallback {
      void onSucceed(String response);

      void onFailed(String response);
}

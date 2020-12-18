package com.aline.splashdemo.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SuTs
 * @create 2020/11/2 17:58
 * @Describe
 */
public class LocalFeedbackBean {

    /**
     * channel : 首页功能简介
     * data : [{"title":"1、如何扫一扫","content":"\u201c扫一扫\u201d实现功能： \n功能一：点击App左下角【首页】-- 右上角【扫一扫图标】 进入扫描二维码页面，通过扫码跳转到对应的页面 \n功能二：在web端登录页面，点击App左下角【首页】-- 右上角【扫一扫图标】扫描二维码，可以无需账号登录web端"},{"title":"2、如何查看消息","content":"点击App左下角【首页】-- 右上角【消息图标】进入消息管理界面"},{"title":"3、轮播图的展示Banner","content":"点击App左下角【首页】顶部的滚动Banner由管理员在web端设置，可以展示公司的业务图片，并快捷跳转到定义的页面"},{"title":"4、我的应用展示","content":"点击App左下角【首页】通过我的应用即可快速进入对应的功能模块\n相关配置：点击App右下角【我】\u2014\u2014【首页配置】可以实现个性化定制\u201c我的应用\u201d"},{"title":"5、报表展示","content":"点击App左下角【首页】通过报表即可展示公司相关的报表展示"}]
     */

    private String channel;
    private List<DataBean> data;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        /**
         * title : 1、如何扫一扫
         * content : “扫一扫”实现功能：
         * 功能一：点击App左下角【首页】-- 右上角【扫一扫图标】 进入扫描二维码页面，通过扫码跳转到对应的页面
         * 功能二：在web端登录页面，点击App左下角【首页】-- 右上角【扫一扫图标】扫描二维码，可以无需账号登录web端
         */

        private String title;
        private String content;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.title);
            dest.writeString(this.content);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.title = in.readString();
            this.content = in.readString();
        }

        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }

    public LocalFeedbackBean() {
    }


}

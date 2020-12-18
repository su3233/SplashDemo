package com.aline.lib;

/**
 * @author SuTs
 * @create 2020/10/30 16:59
 * @Describe
 */
public class Test {
    public static void main(String[] args) {
        testBuilder();
    }


    private static void testBuilder() {
        ManBuilder manBuilder = new ManBuilder.Builder()
                .setMarried(false)
                .setName("zhangSan")
                .setAge(14)
                .build();
        System.out.println(manBuilder.toString());
    }


}

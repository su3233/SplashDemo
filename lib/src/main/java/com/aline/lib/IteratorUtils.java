package com.aline.lib;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author SuTs 默认是饿汉式
 * @create 2020/10/29 15:58
 * @Describe
 */
class IteratorUtils {
    public static void main(String[] args) {
//        diedai();
//        listIterator();
        mapIterator();
    }

    private static void mapIterator() {
        Map<String, String> stringMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            stringMap.put("map key:" + i, "map value:" + i);
        }
        Set<Map.Entry<String, String>> entries = stringMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + ".." + entry.getValue());
        }
    }

    private static void listIterator() {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add("list" + i);
        }
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("list iterator:" + next);
        }
    }

    private static final String TAG = "DbUtils";
    private static final IteratorUtils ourInstance = new IteratorUtils();

    static IteratorUtils getInstance() {
        return ourInstance;
    }

    private IteratorUtils() {
    }

    private static void diedai() {
        Hashtable<String, String> stringHashtable = new Hashtable<>();
        for (int i = 0; i < 10; i++) {
            stringHashtable.put("key" + i, "value" + i);
        }
        Enumeration<String> elements = stringHashtable.elements();
        while (elements.hasMoreElements()) {
            String element = elements.nextElement();
            System.out.println("diedai: " + element);
        }
    }
}

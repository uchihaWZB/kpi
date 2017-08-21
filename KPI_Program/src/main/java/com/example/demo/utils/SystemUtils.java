package com.example.demo.utils;

import java.util.*;

/**
 * Created by lenovopc001 on 2017/8/1.
 */
public class SystemUtils {

    /**
     * 将List数组中的值进行去重，并排序
     * @param list
     * @return
     */
    public static void removeDuplicate(List list) {
        HashSet hashSet = new HashSet(list);
        list.clear();
        list.addAll(hashSet);
        Collections.sort(list);
    }

    /**
     * 初始化一维整型数组
     * @param array
     */
    public static void initOneArray(Integer array[]) {

        for (int index = 0, len = array.length; index < len; index++) {
            array[index] = 0;
        }
    }

    public static void initTwoArray(Integer array[][]) {

        for (int x_index = 0, x_len = array.length; x_index < x_len; x_index++) {

            for (int y_index = 0, y_len = array[x_index].length; y_index < y_len; y_index++) {

                array[x_index][y_index] = 0;
            }
        }
    }
}

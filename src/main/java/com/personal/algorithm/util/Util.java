package com.personal.algorithm.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 工具类
 */
public class Util {
    /**
     * 交换数组
     *
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 打乱数组顺序
     *
     * @param arr
     */
    public static void shuffle(int[] arr) {
        for (int i = arr.length; i > 0; i--) {
            swap(arr, i - 1, ThreadLocalRandom.current().nextInt(i));
        }
    }

    /**
     * 判断是否从从小到大，数组中每个元素不会相同
     *
     * @param arr
     * @return
     */
    public static boolean sorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

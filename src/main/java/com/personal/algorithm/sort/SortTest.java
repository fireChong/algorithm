package com.personal.algorithm.sort;

import com.personal.algorithm.util.Util;

/**
 * 排序测试
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Util.shuffle(arr);
//        new InsertionSort().sort(arr);
//        new SelectionSort().sort(arr);
//        new ShellSort().sort(arr);
        new MergeSort().sort(arr);
        System.out.println("是否有序：" + Util.sorted(arr));
    }
}

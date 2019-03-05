package com.personal.algorithm.sort;

import com.personal.algorithm.util.Util;

import java.util.Arrays;

/**
 * 排序测试
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 100; i++) {
            Util.shuffle(arr);
//            new InsertionSort().sort(arr);
//            new SelectionSort().sort(arr);
//            new ShellSort().sort(arr);
//            new MergeSort().sort(arr);
            new CountingSort().sort(arr, 10);
            new QuickSort().sort(arr);
            if (!Util.sorted(arr)) {
                System.out.println("排序失败");
                return;
            }
        }


        System.out.println("排序成功");
        System.out.println(Arrays.toString(arr));
    }
}

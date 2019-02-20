package com.personal.algorithm.sort;

import com.personal.algorithm.util.Util;

/**
 * 选择排序，从剩余元素中选择最小的元素放在已排序的数组后面
 */
public class SelectionSort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            Util.swap(arr, i, min);
        }
    }
}

package com.personal.algorithm.sort;

/**
 * 插入排序，从剩余元素中插入到已排序的数组中
 */
public class InsertionSort {
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 待插入的数
            int temp = arr[i];
            int j;
            for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }

            arr[j + 1] = temp;
        }
    }
}

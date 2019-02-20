package com.personal.algorithm.sort;

/**
 * 希尔排序，将所有步长为gap的元素进行插入排序，缩减gap直至为1，排序完成
 */
public class ShellSort {
    public void sort(int arr[]) {
        for (int gap = arr.length / 2; gap > 0
                ; gap = gap / 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j;
                for (j = i - gap; j >= 0 && temp < arr[j]; j = j - gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
        }
    }
}

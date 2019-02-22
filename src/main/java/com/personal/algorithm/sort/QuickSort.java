package com.personal.algorithm.sort;

import com.personal.algorithm.util.Util;

/**
 * 快速排序
 */
public class QuickSort {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int left, int right) {
        if (left < right) {
            int j = partition(arr, left, right);
            sort(arr, left, j - 1);
            sort(arr, j + 1, right);
        }
    }

    // 切分数组
    private int partition(int[] arr, int left, int right) {
        // 左光标，指向当前判定的元素
        int leftCursor = left + 1;
        // 右光标, 指向当前判定的元素
        int rightCursor = right;
        // 基准元素
        int base = arr[left];

        while (true) {
            // 找到一个比元素大的数
            while (leftCursor <= right && arr[leftCursor] <= base) {
                leftCursor++;
            }

            // 找到一个比元素小的数
            while (rightCursor >= left && arr[rightCursor] > base) {
                rightCursor--;
            }

            if (leftCursor < rightCursor) {
                Util.swap(arr, leftCursor, rightCursor);
            } else {
                break;
            }
        }

        Util.swap(arr, left, leftCursor - 1);
        return leftCursor - 1;
    }
}

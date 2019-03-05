package com.personal.algorithm.sort;

import com.personal.algorithm.util.Util;

/**
 * 计数排序
 */
public class CountingSort {
    /**
     * 对于任意i都有，k >= arr[i]
     *
     * @param arr
     * @param k
     */
    public void sort(int[] arr, int k) {
        int[] b = new int[k];
        for (int i = 0; i < arr.length; i++) {
            b[arr[i]] += 1;
        }

        for (int i = 1; i < b.length; i++) {
            b[i] = b[i - 1] + 1;
        }

        for (int i = 0; i < arr.length; i++) {
            int index = b[arr[i]] - 1;
            if (index < 0) break;
            Util.swap(arr, index, i);
            b[arr[i]] -= 1;
        }
    }
}

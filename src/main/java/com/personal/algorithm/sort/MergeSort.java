package com.personal.algorithm.sort;

/**
 * 归并排序
 */
public class MergeSort {
    public void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private void sort(int[] arr, int left, int right, int[] temp) {
        // 递归终止的条件，此时就一个元素
        if (left < right) {
            int mid = (left + right) / 2;
            // 对左边的数组进行排序
            sort(arr, left, mid, temp);
            // 对右边的数组进行排序
            sort(arr, mid + 1, right, temp);
            // 合并两个数组
            merge(arr, left, mid, right, temp);
        }
    }

    // 合并左右两个数组
    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 将原数据拷贝到临时数组中
        System.arraycopy(arr, left, temp, left, right - left + 1);
        // 左数组的光标
        int leftCursor = left;
        // 右数组的光标
        int rightCursor = mid + 1;
        // 当前数组的光标
        int arrCursor = left;
        // 比较两个数组的最小值，最小的放到结果数组中
        while (leftCursor <= mid && rightCursor <= right) {
            if (temp[leftCursor] < temp[rightCursor]) {
                arr[arrCursor] = temp[leftCursor];
                leftCursor++;
            } else {
                arr[arrCursor] = temp[rightCursor];
                rightCursor++;
            }
            arrCursor++;
        }

        // 还剩余部分未比较元素，全是其中的一个数组的，要么是左数组，要么是右，全部放到结果数组中
        while (leftCursor <= mid) {
            arr[arrCursor] = temp[leftCursor];
            leftCursor++;
            arrCursor++;
        }

        while (rightCursor <= right) {
            arr[arrCursor] = temp[rightCursor];
            rightCursor++;
            arrCursor++;
        }
    }
}

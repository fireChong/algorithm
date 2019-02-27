package com.personal.algorithm.sort;

import com.personal.algorithm.util.Util;

/**
 * 二叉堆
 * 最大堆，目前是固定数组，没有扩容
 * 父节点i，左节点j = 2i + 1，右节点k= 2i + 2；
 */
public class BinaryHeap {
    private int[] data;
    private int size;

    public BinaryHeap(int n) {
        this.data = new int[n];
    }

    public int size() {
        return size;
    }

    public void insert(int a) {
        if (size == data.length) {
            return;
        }
        size++;
        data[size - 1] = a;
        swim(size - 1);
    }

    public int deleteMax() {
        int max = data[0];
        data[0] = Integer.MIN_VALUE;
        sink(0);
        size--;
        return max;
    }


    /**
     * 由下至上的堆有序化（上浮）
     *
     * @param k 数组下标
     */
    private void swim(int k) {
        while (k > 0) {
            int p = (k - 1) / 2;
            if (data[k] > data[p]) {
                Util.swap(data, k, p);
                k = p;
            } else {
                break;
            }
        }
    }

    /**
     * 由上至下的对有序化（下浮）
     *
     * @param k 数组下标
     */
    private void sink(int k) {
        while (true) {
            int l = 2 * k + 1;
            int r = 2 * k + 2;
            if (l < size && data[l] > data[k]) {
                k = l;
                Util.swap(data, k, l);
            } else if (r < size && data[r] > data[k]) {
                k = r;
                Util.swap(data, k, r);
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(1000);
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Util.shuffle(arr);
        for (int i = 0; i < arr.length; i++) {
            heap.insert(arr[i]);
        }

        for (int i = 0; i < arr.length; i++){
            System.out.println(heap.deleteMax());
        }
    }
}

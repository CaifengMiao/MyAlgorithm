package com.leetcode.algorithm.heap;

public class Heap {
    private int[] arr; // 数组，从下标1开始存储数据
    private int capacity;  // 堆可以存储的最大数据个数
    private int size; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        arr = new int[capacity + 1];
        this.capacity = capacity;
        size = 0;
    }

    public void insert(int data) {
        if (size >= capacity) return; // 堆满了
        ++size;
        arr[size] = data;
        int i = size;
        while (i/2 > 0 && arr[i] > arr[i/2]) { // 自下往上堆化
            int tmp = arr[i];
            arr[i] = arr[i/2];
            arr[i/2] = tmp ;
            i = i/2;
        }
    }


    public void removeMax() {
        if (size == 0) return ; // 堆中没有数据
        arr[1] = arr[size];
        --size;
        heapify(arr, size, 1);
    }

    private void heapify(int[] a, int n, int i) { // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i*2 <= n && a[i] < a[i*2]) maxPos = i*2;
            if (i*2+1 <= n && a[maxPos] < a[i*2+1]) maxPos = i*2+1;
            if (maxPos == i) break;
            int tmp = arr[i];
            arr[i] = arr[maxPos];
            arr[maxPos] = tmp ;
            i = maxPos;
        }
    }


}

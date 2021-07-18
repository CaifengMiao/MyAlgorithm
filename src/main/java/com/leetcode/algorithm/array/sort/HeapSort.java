package com.leetcode.algorithm.array.sort;

public class HeapSort {
    public static void HeapSort(int[] arr){
        int size = arr.length-1;
        //build heap
        for (int i = size/2; i >= 0; --i) {
            heapify(arr,size,i);
        }

        while(size>=0){
            swap(arr,size,0);
            --size;
            heapify(arr,size,0);
        }
    }

    /**
     *
     * @param arr
     * @param size 堆大小
     * @param max  堆顶元素
     */
    private static void heapify(int[] arr, int size,int max) {
        while (true) {
            int maxPos = max;
            if (max * 2 + 1 <= size && arr[max] < arr[max * 2 + 1]) {
                maxPos = max * 2 + 1;
            }
            if (max * 2 + 2 <= size && arr[maxPos] < arr[max * 2 + 2]) {
                maxPos = max * 2 + 2;
            }
            //没有发生交换即堆化完成
            if (maxPos == max) break;
            //元素交换
            swap(arr,max,maxPos);
            max = maxPos;
        }
    }

    private static void swap(int[] arr,int i, int j){
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args){
        int[] arr= {1,10,9,23,43,21,4,76,54};
       // int[] arr = {1,8,3,5,7,2,7,6};
        HeapSort(arr);
        for(int num: arr){
            System.out.print(num +" ");
        }
    }
}

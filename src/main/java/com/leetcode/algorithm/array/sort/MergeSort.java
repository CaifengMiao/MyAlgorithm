package com.leetcode.algorithm.array.sort;

public class MergeSort {
    /**
     * 归并排序：递归地将数组分成两半，分别排序，然后合并
     * @param arr 待排序数组
     * @param low 起始索引
     * @param high 结束索引
     */
    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = low + ((high - low) >> 1); // 计算中间点

        // 递归排序左右两半
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        // 合并已排序的两半
        merge(arr, low, mid, high);
    }

    /**
     * 合并两个已排序的子数组
     * @param arr 原始数组
     * @param low 左子数组起始索引
     * @param mid 左子数组结束索引/右子数组起始索引-1
     * @param high 右子数组结束索引
     */
    private static void merge(int[] arr, int low, int mid, int high) {
        // 创建临时数组存放合并结果
        int[] temp = new int[high - low + 1];
        int leftIndex = low;      // 左子数组指针
        int rightIndex = mid + 1; // 右子数组指针
        int tempIndex = 0;        // 临时数组指针

        // 比较两个子数组的元素，将较小的放入临时数组
        //关键点 需要<=因为边界元素也要计算
        while (leftIndex <= mid && rightIndex <= high) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[tempIndex++] = arr[leftIndex++];
            } else {
                temp[tempIndex++] = arr[rightIndex++];
            }
        }

        // 将左子数组剩余元素复制到临时数组
        while (leftIndex <= mid) {
            temp[tempIndex++] = arr[leftIndex++];
        }

        // 将右子数组剩余元素复制到临时数组
        while (rightIndex <= high) {
            temp[tempIndex++] = arr[rightIndex++];
        }

        // 将临时数组中的元素复制回原数组
        // 关键点：循环的长度
        //  如何temp长度计算好的了，就小于️temp length
        //  没有计算可以用tempIndex做限制
        for (int i = 0; i < tempIndex; i++) {
            arr[low + i] = temp[i];
        }
    }

    public static void main(String[] args){
        int[] arr = {1,8,3,5,7,2,7,6};
        mergeSort(arr,0,arr.length-1);
        for(int num: arr){
            System.out.print(num +" ");
        }
    }
}

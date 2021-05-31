package com.leetcode.algorithm.array;

public class QuickSort {
    public static void quickSort(int[] arr,int left,int right) {
        //当左右两边相等时，说面比较已经完成，退出递归;
        if(left >= right) return;
        //递归
        int i = left,j = arr.length-1 ;
        int pivot = arr[i];
        while(i<j){
            while(arr[j]>pivot && i<j){
                j--;
            }
            arr[i] = arr[j];
            while(arr[i]<pivot && i<j){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] =pivot;
        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);
    }
}

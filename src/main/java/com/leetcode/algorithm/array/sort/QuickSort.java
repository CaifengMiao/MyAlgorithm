package com.leetcode.algorithm.array.sort;


public class QuickSort {
    public static void quickSort(int[] arr,int low,int high){
        //递归出口
        if(low>=high)return;

        int pivot = arr[low];
        int i=low,j=high;
        while(i<j){
            while(arr[j]>=pivot && i<j){
                j--;
            }
            arr[i] = arr[j];
            while(arr[i]<pivot && i<j){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;

        //递归调用
        quickSort(arr,low,i-1);
        quickSort(arr,i+1,high);
    }
    public static void main(String[] args){
        int[] arr = {1,8,3,5,7,2,7,6};
        quickSort(arr,0,arr.length-1);
        for(int num: arr){
            System.out.print(num +" ");
        }
    }
}

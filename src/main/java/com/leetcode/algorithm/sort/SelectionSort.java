package com.leetcode.algorithm.sort;

public class SelectionSort {
    public static void sort(int[] arr){
        int min;
        for(int i=0; i<arr.length-1; i++){
            min = i;
            for(int j=i+1; j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    public static void main(String[] args){
        int[] arr = {1,8,3,5,7,2,7,6};
        sort(arr);
        for(int num: arr){
            System.out.print(num +" ");
        }
    }
}

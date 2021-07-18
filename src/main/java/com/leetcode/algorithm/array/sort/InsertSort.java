package com.leetcode.algorithm.array.sort;

public class InsertSort {
    public static void sort(int[] arr){

        for(int i=0 ;i<arr.length-1;i++){
         for(int j=i+1;j>0;j--){
             if(arr[j]<arr[j-1]){
                 int tmp = arr[j-1];
                 arr[j-1] = arr[j];
                 arr[j] = tmp;
             }
         }
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

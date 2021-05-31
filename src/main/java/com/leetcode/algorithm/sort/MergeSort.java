package com.leetcode.algorithm.sort;

public class MergeSort {
    public static void merge(int[] arr,int low,int high){
        if(low>=high)return ;
        //获取中间的结点
        int mid=(low+high)/2;
        //递归排序
        merge(arr,low,mid);
        merge(arr,mid+1,high);

        int[] tmp = new int[arr.length];
        int i =low,j=mid+1,tindex=0;
        while(i<=mid && j<=high){
            if(arr[i]<arr[high]){
                tmp[tindex] = arr[i];
                tindex++;
                i++;
            }else{
                tmp[tindex] = arr[j];
                tindex++;
                j++;
            }

        }
        while(i<=mid){
            tmp[tindex] = arr[i];
            i++;
            tindex++;
        }
        while(j<=high){
            tmp[tindex] = arr[j];
            j++;
            tindex++;
        }
        for(int t=0;t<tindex;t++){
            arr[low+t] = tmp[t];
        }
    }
    public static void main(String[] args){
        int[] arr = {1,8,3,5,7,2,7,6};
        merge(arr,0,arr.length-1);
        for(int num: arr){
            System.out.print(num +" ");
        }
    }
}

package com.leetcode.algorithm.sort;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * 冒泡排序
 * 时间复杂度为O(n^2)
 *
 * 原理：冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。
 * 如果不满足就让它俩互换。一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
 */
public class BoubbleSort {
    public static void sort(int[] arr){
        int tmp ;
        for(int i=0; i< arr.length -1; i++){
            boolean flag = false;
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j]>arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
            }
          if(!flag)break;
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

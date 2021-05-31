package com.leetcode.algorithm.array;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length+nums2.length];
        int i =0,j=0,index=0;
        double mid = 0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                arr[index++]=nums1[i++];
            }else{
                arr[index++]=nums2[j++];
            }
        }

        while(i<nums1.length){
            arr[index++]=nums1[i++];
        }
        while(j<nums2.length){
            arr[index++]=nums2[j++];
        }

        if((arr.length & 1) ==1){
            mid = arr[arr.length/2];
        }else{
            mid = (arr[arr.length/2]+arr[arr.length/2-1])/2.00;
        }
        return mid;
    }
    public static void main(String[] args){
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}

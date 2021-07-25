package com.leetcode.algorithm.array.binarysearch;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target
 * value. If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8 , Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6 , Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * from：LeetCode
 * Link：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class searchRange {
    /**
     * This problem is a deformation of binary search
     * We should paid attention to the termination condition of the loop, the update method of the upper and lower
     * bounds of the interval, and the selection of the return value
     * @param arr
     * @param target
     * @return
     */
    public int[] searchRange(int[] arr, int target) {
        return new int[]{getLeftBound(arr,target),getRightBound(arr,target)};
    }

    private int getLeftBound(int[] arr,int target){
        int left = 0, right = arr.length-1;
        int mid;
        while(left<=right){
            mid = left+ ((right-left)>>1);
            if(arr[mid]== target){
                if(mid>0 && arr[mid-1]==target){
                    right = mid - 1;
                }else{
                    return mid;
                }
            }else if(arr[mid] > target){
                right = mid - 1;
            }else if(arr[mid]<target){
                left = mid + 1;
            }
        }
        return -1;
    }

    private int getRightBound(int[] arr,int target){
        int left = 0, right = arr.length-1;
        int mid;
        while(left<=right){
            mid = left+ ((right-left)>>1);
            if(arr[mid]== target){
                if(mid<arr.length-1 && arr[mid+1]==target){
                    left = mid + 1;
                }else{
                    return mid;
                }
            }else if(arr[mid] > target){
                right = mid - 1;
            }else if(arr[mid]<target){
                left = mid + 1;
            }
        }
        return -1;
    }
}

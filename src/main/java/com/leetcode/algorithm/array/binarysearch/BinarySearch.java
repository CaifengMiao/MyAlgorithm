package com.leetcode.algorithm.array.binarysearch;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search
 * target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9  Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2 Output: -1
 *
 * Explanation: 2 does not exist in nums so return -1
 *
 * from：LeetCode
 * Link：https://leetcode-cn.com/problems/binary-search
 * Difficulty : Easy
 */
public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int index = -1,left=0,right = nums.length-1,mid=0;
        while(right>=left){
            int half = left+((right-left)>>1);
            mid = nums[half];
            if(mid == target){
                index = half;
                break;
            }else if(mid >target){
                right = half-1;
            }else if(mid<target){
                left = half+1;
            }
        }
        return index;
    }

    // recursion
    public static int binarySearch(int[] nums,int target, int left, int right) {
        if (left > right) return -1;
        int result = 0 , mid = left + ((right-left)>>1);
        if(nums[mid] == target) {
            result = mid ;
        }else if(nums[mid] > target){
            result = binarySearch(nums,target,left, mid-1);
        }else if(nums[mid] < target){
            result =  binarySearch(nums,target,mid+1, right);
        }
        return result;
    }

}

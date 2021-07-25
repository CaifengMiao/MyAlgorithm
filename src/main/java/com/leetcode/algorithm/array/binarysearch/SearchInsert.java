package com.leetcode.algorithm.array.binarysearch;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return
 * the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5 , Output: 2
 *
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2 , Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7 , Output: 4
 *
 * Example 4:
 * Input: nums = [1,3,5,6], target = 0 , Output: 0
 *
 * Example 5:
 * Input: nums = [1], target = 0 , Output: 0
 *
 * from：力扣（LeetCode）
 * Link：https://leetcode-cn.com/problems/search-insert-position
 * Difficulty : Easy
 */
public class SearchInsert {
    /**
     * This problem is obviously using binary search
     * The key is how to get insert index of the data which is not found
     * if the target value is not found, the function will exit the loop after left = = right.
     * In the last loop, left = right and they are the index of the maximum value less than the target value in the array
     * so left+1 = right+1 =index of the not found data . we had left=left +1 before jumping out of the loop. so return
     * left can return directly
     *
     * @param arr
     * @param target
     * @return
     */
    public int searchInsert(int[] arr, int target) {
        int left=0,right=arr.length-1;
        int mid;
        while(left<=right){
            mid = left +((right-left)>>1);
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid-1;
            }else if(arr[mid]<target){
                left = mid+1;
            }
        }
        return left;
    }

    //my first answer
    public int searchInsertFirst(int[] arr, int target) {
        int left=0,right=arr.length-1,result=0;

        while(left<=right){
            int mid = left +((right-left)>>1);
            if(arr[mid] == target){
                result=mid;
                break;
            }else if(arr[mid] > target){
                if(mid == 0){
                    return 0;
                }else if(arr[mid-1]<target){
                    return mid;
                }
                right = mid-1;
            }else if(arr[mid]<target){
                if(mid+1 == arr.length){
                    return arr.length;
                }else if(arr[mid+1]>target){
                    return mid+1;
                }
                left = mid+1;
            }
        }

        return result;
    }
}

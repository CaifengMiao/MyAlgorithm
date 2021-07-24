package com.leetcode.algorithm.array.slidingwindow;

/**
 * Given an array of positive integers nums and a positive integer target,return the minimal length of a contiguous
 * subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 *
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3] , Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * Example 2:
 * Input: target = 4, nums = [1,4,4] , Output: 1
 *
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1] , Output: 0
 *
 * from：LeetCode
 * Link：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 */
public class minSubArrayLen {
    /**
     * This is a very classic sliding window algorithm.
     * define left and right tow pointers ，first move the right pointer until the sum of the subarray composed of two
     * pointers is greater than or equal to the target value, and then moves the left pointer to reduce the size of the
     * window, until that the sum of the subarray is less than the target value, and then moves the right pointer...
     * Loop the above operation we can get the minimum array length satisfying the condition
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = 0, subSum = 0, left = 0, right = 0;

        for(;right<nums.length;right++){
            subSum = subSum + nums[right];
            if(subSum >= target) {
                while (subSum >= target) {
                    minLen = minLen == 0 ? right - left + 1 : Math.min(minLen, right - left +1);
                    subSum = subSum - nums[left];
                    left++;
                }
            }
        }

        return minLen;
    }
}

package com.leetcode.algorithm.array;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
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

    public static void main(String[] args){
        int[] nums = new int[]{-1,0,3,5,9,12};
        search(nums,13);
    }
}

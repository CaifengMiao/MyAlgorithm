package com.leetcode.algorithm.array;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 */
public class sortedSquares {
    //暴力破解
    public static int[] sortedSquares1(int[] nums) {
        int i=0;
        while(i<nums.length){
            int val = nums[i]*nums[i];
            int j = i;
            int tmp;
            if(i==0){
                nums[0]=val;
            }else{
                while(j-1>=0){
                    if(val<(nums[j-1])){
                        nums[j] = nums[j-1];
                        nums[j-1] = val;
                        j--;
                    }else{
                        nums[j]=val;
                        break;
                    }
                }
            }
            i++;
        }

        return nums;
    }
    //利用原本有序的特点，排序，类似双指针
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i=0,j=nums.length-1,k= nums.length-1;
        while(k>=0){
            int tmp;
            if((nums[i]*nums[i])> (nums[j]*nums[j])){
                result[k] = nums[i]*nums[i];
                i++;
            }else{
                result[k] = nums[j]*nums[j];
                j--;
            }
            k--;

        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = new int[]{-7,-3,2,3,10};
        sortedSquares(nums);
    }
}

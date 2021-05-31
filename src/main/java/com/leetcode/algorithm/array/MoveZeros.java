package com.leetcode.algorithm.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 要求
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 */
public class MoveZeros {
    /**
     * 双指针，将数组区分未两个空间，一个是非0空间，一个是空间
     * i指针向前遍历，遇见非0的就向非0空间添加一个元素，直到数组末尾退出
     * j指向非0空间尾部，添加一个非0元素就加一，i到末尾后，j之后的都是0元素，补齐即可
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
       int i =0,j=0;
       while(i < nums.length){
           if(nums[i]!=0){
               nums[j]=nums[i];
               i++;
               j++;
           }else{
               i++;
           }
       }
       for(;j<nums.length;j++){
           nums[j]=0;
       }
    }

    public static void main(String[] args){
        //int[] arr = {0,1,0,3,12};

        int[] arr = {0,0,0,3};

        moveZeroes(arr);
        for(int i: arr){
            System.out.print(i+",");
        }

    }
}

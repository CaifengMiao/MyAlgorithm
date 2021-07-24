package com.leetcode.algorithm.array.moveelement;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 */
public class removeElement {
    /**
     * 双指针，将数组区分未两个空间，一个是原数组空间，一个是不含val空间
     * i指针用于遍历原数组空间，j指针则指向不含val空间末尾。
     * i遇见不等于val元素就向的就向不含空间添加一个元素及j++，遇见一个等于val元素就跳过，直到数组末尾退出
     * @param nums
     */
    public int removeElement(int[] nums, int val) {
        int fast=0,slow=0;
        while(fast<nums.length){
            if(nums[fast]==val){
                fast++;
            }else{
                nums[slow]=nums[fast];
                fast++;
                slow++;
            }
        }
        return slow;
    }
}

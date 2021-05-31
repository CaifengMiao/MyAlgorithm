package com.leetcode.algorithm.array;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 */
public class MajorityElement {
    /**
     * 摩尔投票法 ：不同就抵消抵消，剩下的就是众数
     * @param arr
     * @return
     */
    public int majorityElement(int[] arr){
        int majority = arr[0];
        int count = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i] == majority){
                count ++;
            }else{
                count--;
                if(count == 0){
                    majority = arr[i];
                    count = 1;
                }
            }
        }
        return majority;
    }

    public static void main(String[] args){
        int[] arr = {1,2,2,3};
        int[] arr2 ={2,2};
        System.out.println();
    }
}

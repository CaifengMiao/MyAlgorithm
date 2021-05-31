package com.leetcode.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 */
public class Intersect {

    /**
     * 采用HashMap，先将小数组加载到hashMap中，再遍历大数组，相同的取出来放到list中，hashMap值减1
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersectHash(int[] nums1, int[] nums2) {
        //比较大小
        if (nums1.length > nums2.length) {
            return intersectHash(nums2, nums1);
        }

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num : nums2){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else {
                map.put(num, 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int num: nums1){
            if(map.containsKey(num)){
                if(map.get(num)>0) {
                    list.add(num);
                    map.put(num,map.get(num)-1);
                }
            }
        }
        int[] result = new int[list.size()];
        for(int i =0;i<result.length;i++){
            result[i] = list.get(i);
        }

        return result;
    }

    /**
     * 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersectDoublePoint(int[] nums1, int[] nums2) {
        //比较大小
        if (nums1.length > nums2.length) {
            return intersectDoublePoint(nums2, nums1);
        }
        //数组排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i=0 , j =0;
        while(i < nums1.length && j<nums2.length){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                i++;
            }
        }

        int[] result = new int[list.size()];
        for(int n =0;n<result.length;n++){
            result[n] = list.get(n);
        }
        return result;
    }

    public static void main(String[] args){
        int[] arr = {1,2,2,3};
        int[] arr2 ={2,2};
        System.out.println(intersectDoublePoint(arr,arr2).toString());
    }

}

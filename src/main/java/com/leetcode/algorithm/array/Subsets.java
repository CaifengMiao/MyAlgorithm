package com.leetcode.algorithm.array;

import java.util.ArrayList;
import java.util.List;
/**
 *  题目：给你一个整数数组 nums，数组中的元素互不相同。返回该数组所有可能的子集（幂集）
 *  解集 不能包含重复的子集 你可以按 任意顺序 返回解集。
 *
 *  示例 1：
 *      输入：nums = [1,2,3]
 *      输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *  示例 2：
 *      输入：nums = [0]
 *      输出：[[],[0]]
 *  https://leetcode-cn.com/problems/subsets
 */
public class Subsets {

    /**
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //空集为所有数组的子集
        result.add(new ArrayList<Integer>());
        for(int num : nums){
            List<List<Integer>> newResult = new ArrayList<List<Integer>>();
            newResult.addAll(result);
            for(int i =0;i<result.size();i++){
                List<Integer> tmp = new ArrayList<Integer>(result.get(i));
                tmp.add(num);
                newResult.add(tmp);
            }
            result = newResult;
        }

        return result;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        System.out.println(subsets(arr));
    }

}

package com.leetcode.algorithm.array.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented
 * by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
 *
 * You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
 *
 * 1.You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of
 * fruit each basket can hold.
 * 2.Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree)
 * while moving to the right. The picked fruits must fit in one of your baskets.
 * 3.Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
 *
 * Given the integer array fruits, return the maximum number of fruits you can pick.
 *
 * Example 1:
 *
 * Input: fruits = [1,2,1]
 * Output: 3
 * Explanation: We can pick from all 3 trees.
 * Example 2:
 *
 * Input: fruits = [0,1,2,2]
 * Output: 3
 * Explanation: We can pick from trees [1,2,2].
 * If we had started at the first tree, we would only pick from trees [0,1].
 * Example 3:
 *
 * Input: fruits = [1,2,3,2,2]
 * Output: 4
 * Explanation: We can pick from trees [2,3,2,2].
 * If we had started at the first tree, we would only pick from trees [1,2].
 * Example 4:
 *
 * Input: fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can pick from trees [1,2,1,1,2].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fruit-into-baskets

 */
public class totalFruit {
    /**
     *  define left and right tow pointers ，first move the right pointer until the sum of the subarray composed of two
     *      * pointers is greater than or equal to the target value, and then moves the left pointer to reduce the size of the
     *      * window, until that the sum of the subarray is less than the target value, and then moves the right pointer...
     *      * Loop the above operation we can get the minimum array length satisfying the condition
     * @param fruits
     * @return
     */
    public static int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> basketsMap = new HashMap<Integer,Integer>();
        int maxFruitsNum = 0;
        int left=0,right=0,fruitsNum = 0;
        while(right<fruits.length){
            while(basketsMap.size()<=2 && right<fruits.length){
                if(basketsMap.containsKey(fruits[right])){
                    basketsMap.put(fruits[right],basketsMap.get(fruits[right])+1);
                }else{
                    basketsMap.put(fruits[right],1);
                }
                right++;
                if(basketsMap.size()<=2)
                    fruitsNum=right-left;

            }

            while(basketsMap.size()>2 && right>left){
                if(basketsMap.get(fruits[left])>1){
                    basketsMap.put(fruits[left],basketsMap.get(fruits[left])-1);
                }else {
                    basketsMap.remove(fruits[left]);
                }
                left++;
            }
            maxFruitsNum = Math.max(fruitsNum,maxFruitsNum);
        }

        return maxFruitsNum;
    }

    public static void main(String[] args){
        int[] a = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        totalFruit(a);
    }
}

package com.leetcode.algorithm.simulation;

import java.util.HashMap;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof

 */
public class Fibonacci {
    HashMap<Integer,Integer> map = new HashMap();
    int result = 0;

    /**
     * 递归，超时
     * @param n
     * @return
     */
    public int fib1(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(map.containsKey(n)){
            return map.get(n);
        }else{
            result = fib1(n-1)+fib1(n-2);
            map.put(n,result);
            return result;
        }

    }

    /**
     * 循环解出答案
     * @param n
     * @return
     */
    public int fib2(int n) {
        int temp = 0 , temp1 = 0, temp2 = 1;
        if(n == 0){
            return temp1;
        }
        if(n == 1){
            return temp2;
        }
        for(int i = 1;i < n;i++){
            temp = (temp1 + temp2)%1000000007;
            temp1 = temp2;
            temp2 = temp;
        }

        return temp;
    }
}

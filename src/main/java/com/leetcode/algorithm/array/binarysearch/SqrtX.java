package com.leetcode.algorithm.array.binarysearch;

/**
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 * Example 1:
 *
 * Input: x = 4
 * Output: 2
 * Example 2:
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 *
 * from：LeetCode
 * Link：https://leetcode-cn.com/problems/sqrtx
 * Difficulty : Easy
 */
public class SqrtX {

    public int mySqrt(int x) {
        int high = x, low =1, mid=0, result=0;
        while(high>=low){
            mid= low + ((high-low)>>1);
            //Use division instead o f multiplication to avoid  int overflow
            if(mid <= x/mid && (mid+1)>x/(mid+1)){
                result = mid;
                break;
            }else if(mid< x / mid ){
                low = mid+1;
            }else if(mid > x / mid){
                high=mid-1;
            }
        }
        return result;
    }

    //get n digits after the decimal point
    public double mySqrt(double x,int n) {
        return 0;
    }
}

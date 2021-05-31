package com.leetcode.algorithm.String;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 */
public class LongestPalindrome {
    /**
     * 解法1：中心扩展法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        String result = "";
        if (s == null || s.length() < 1) {
            return result;
        }
        for(int index = 0 ;index < s.length();index++){
            //奇数
            String len1 = getLogestPal(s,index,index);
            //偶数
            String len2 = getLogestPal(s,index,index+1);
            if(len1.length()>len2.length()){
                if(result.length()<len1.length()){
                    result = len1;
                }
            }else{
                if(result.length()<len2.length()){
                    result = len2;
                }
            }
        }
        return result;
    }

    private String getLogestPal(String s, int left,int right){
        while(left>0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
}

package com.leetcode.algorithm.String;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 */
public class Palindrome {
    /**
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        char[] sarray = s.replace(" ","").toCharArray();
        int i=0,j=sarray.length-1;
        boolean isPalindrome = true;
        while(i<j){
            if(!Character.isLetterOrDigit(sarray[i])){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(sarray[j])){
                j--;
                continue;
            }
            if(Character.toUpperCase(sarray[i])!=Character.toUpperCase(sarray[j])){
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        return isPalindrome;
    }

    /**
     * 回文串简单判断
     * @param s
     * @return
     */
    public static boolean isSimplePalindrome(String s) {
        boolean isPalindrome = true;
        int left = 0,right = s.length()-1;
        s = s.replace(" ","");
        while(left < right){
            if(Character.toUpperCase(s.charAt(left))!=Character.toUpperCase(s.charAt(right))){
                isPalindrome =false;
                break;
            }
            left++;
            right--;
        }
        return isPalindrome;
    }
    public static void main(String[] args){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("A man a plan a canal Panama"));
    }
}

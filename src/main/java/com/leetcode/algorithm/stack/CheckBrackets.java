package com.leetcode.algorithm.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：左括号必须用相同类型的右括号闭合；左括号必须以正确的顺序闭合。
 *  
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 * 输入：s = "(]"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses

 */
public class CheckBrackets {
    public static boolean isValid(String s) {
        char[] brackets = s.toCharArray();
        if (brackets.length % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack();
        HashMap <Character,Character>  map = new HashMap();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');

        for(Character bracket : brackets){

            if (bracket.equals('{')||bracket.equals('[')||bracket.equals('(')){
                stack.push(bracket);
            }else{
                if(!stack.empty()){
                    char left= stack.pop();
                    if(!map.get(left).equals(bracket)){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }

        return stack.empty()?true:false;
    }
    public static void main(String[] args){
        String a = "}";
        System.out.println(isValid(a));
    }
}

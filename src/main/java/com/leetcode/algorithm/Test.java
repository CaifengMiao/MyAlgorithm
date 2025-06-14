package com.leetcode.algorithm;

import com.leetcode.algorithm.stack.DailyTemperatures;
import com.leetcode.algorithm.stack.MyArrayStack;

import java.util.HashMap;

public class Test {
    public static void main(String[] args){
        MyArrayStack<String> myArrayStack = new MyArrayStack(8);
        myArrayStack.push("1");
        System.out.println(myArrayStack.pop());
        DailyTemperatures.dailyTemperatures(new int[]{58,47,47,46,76,100,70});
    }
}

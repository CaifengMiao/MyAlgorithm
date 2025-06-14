package com.leetcode.algorithm.stack;

import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        int i=0,j = 0;
        while(i < temperatures.length - 1){
            if(stack.empty()){
                stack.push(i);
                result[i] = 0;
                j = i+1;
            }else{
                while(j<temperatures.length){
                    if(temperatures[j] < temperatures[stack.peek()]){
                        j++;
                        if(j==temperatures.length){
                            i++;
                            break;
                        }
                    }else{
                        result[i] = j-stack.pop();
                        i++;
                        break;
                    }
                }
            }
        }
        return result;
    }
}

package com.leetcode.algorithm.stack;

import java.util.Stack;

public class MyArrayStack<T> {
    private T[] data;
    private int stackSize;
    private int count;

    public MyArrayStack(int stackSize){
        this.data = (T[]) new Object[stackSize];
        this.stackSize = stackSize;
        this.count = 0;
    }

    public boolean push(T element){
        if(count>=stackSize) return false;
        data[count] = element;
        count++;
        return true;
    }

    public T pop(){
        if(count<=0) return null;
        T element = data[count-1];
        count--;
        return element;
    }
}

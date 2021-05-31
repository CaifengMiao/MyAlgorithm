package com.leetcode.algorithm.array;

/**
 * 获取二维数组中最大的值
 */
public class GetTwoDimensionalArrayMax {
    public static void getMax(int[][] arr){
        int max = arr[0][0];
        int index1=0,index2=0;
        int outLength = arr.length;
        int inLength = arr[0].length;
        for(int i = 0 ;i<outLength;i++){
            for(int j = 0 ;j<inLength;j++){
                if(arr[i][j]>max){
                    max = arr[i][j];
                    index1=i;
                    index2=j;
                }
            }
        }
        System.out.println("max="+max+",taget:"+index1+","+index2);
    }

    public static void main(String[] args){
        int[][] twoDimeArray = new int[][]{{1,2,5},{7,8,6},{0,2,3},{4,5,9}};
        getMax(twoDimeArray);
    }
}

package com.leetcode.algorithm.array;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 * [
 *   [ 1,  4,  7, 11, 15],
 *   [ 2,  5,  8, 12, 19],
 *   [ 3,  6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 */
public class FindNumberIn2DArray {
    /**
     * 思路分析：由于该二维数组存在从中到右递增，从上到下递增的特点，所以右上角的数
     * 同一行左边的数比他下，下面的数比他大，所以可以从右上角的数触发查找。
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int outSize = matrix.length;
        int inSize  = matrix[0].length;
        boolean result = false;
        int i =outSize-1 ,j=0;
        while(i>=0 && j<inSize){
            if(target == matrix[i][j]){
                result = true;
                break;
            }
            if (target > matrix[i][j]){
                j++;
            }else{
                i--;
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[][] arr = new int[][]{{1,4,7,11,15},
                                  {2,5,8,12,19},
                                  {3,6,9,16,22},
                                  {10,13,14,17,24},
                                  {18,21,23,26,30}};

    }
}

package com.leetcode.algorithm.array.sort;

/**
 * 冒泡排序算法实现
 * 时间复杂度：最好情况O(n)，最坏情况O(n^2)，平均情况O(n^2)
 * 空间复杂度：O(1)，原地排序算法
 * 稳定性：稳定排序算法
 *
 * 算法原理：
 * 冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，
 * 看是否满足大小关系要求。如果不满足就让它俩互换。一次冒泡会让至少一个元素移动
 * 到它应该在的位置，重复n次，就完成了n个数据的排序工作。
 */
public class BubbleSort {

    /**
     * 冒泡排序方法
     * @param arr 待排序的数组
     */
    public static void sort(int[] arr) {
        // 边界条件检查
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;
        // 外层循环控制排序趟数
        for (int i = 0; i < n - 1; i++) {
            // 标记本轮是否发生交换，用于优化
            boolean swapped = false;

            // 内层循环进行相邻元素比较和交换
            // 每轮结束后，最大的元素会"冒泡"到末尾
            for (int j = 0; j < n - 1 - i; j++) {
                // 如果前一个元素大于后一个元素，则交换它们
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            // 如果本轮没有发生交换，说明数组已经有序，提前结束排序
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 交换数组中两个元素的位置
     * @param arr 数组
     * @param i 第一个元素的索引
     * @param j 第二个元素的索引
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 测试方法
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 5, 7, 2, 7, 6};

        System.out.print("排序前: ");
        printArray(arr);

        sort(arr);

        System.out.print("排序后: ");
        printArray(arr);
    }

    /**
     * 打印数组元素
     * @param arr 要打印的数组
     */
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
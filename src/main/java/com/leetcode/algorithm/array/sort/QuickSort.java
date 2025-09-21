package com.leetcode.algorithm.array.sort;

public class QuickSort {
    /**
     * 快速排序方法
     * @param arr 待排序数组
     * @param low 排序起始索引
     * @param high 排序结束索引
     */
    public static void quickSort(int[] arr, int low, int high) {
        // 递归终止条件：子数组长度为0或1
        if (low >= high) return;

        // 分区操作，获取基准点位置
        int pivotIndex = partition(arr, low, high);

        // 递归排序基准点左侧子数组
        quickSort(arr, low, pivotIndex - 1);
        // 递归排序基准点右侧子数组
        quickSort(arr, pivotIndex + 1, high);
    }

    /**
     * 分区操作：将数组分为两部分，左边小于基准值，右边大于等于基准值
     * @param arr 待分区数组
     * @param low 分区起始索引
     * @param high 分区结束索引
     * @return 基准值最终位置索引
     */
    private static int partition(int[] arr, int low, int high) {
        // 选择第一个元素作为基准值
        int pivot = arr[low];
        int left = low;
        int right = high;

        while (left < right) {
            // 从右向左找第一个小于基准值的元素
            // 注意>=两个while 有一个要包含等号
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            // 将小于基准值的元素放到左边
            if (left < right) {
                arr[left] = arr[right];
            }

            // 从左向右找第一个大于等于基准值的元素
            while (left < right && arr[left] < pivot) {
                left++;
            }
            // 将大于等于基准值的元素放到右边
            if (left < right) {
                arr[right] = arr[left];
            }
        }

        // 将基准值放到正确位置
        arr[left] = pivot;
        // 返回基准值位置
        return left;
    }

    /**
     * 测试方法
     */
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 5, 7, 2, 7, 6};
        System.out.print("排序前: ");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.print("排序后: ");
        printArray(arr);
    }

    /**
     * 打印数组
     * @param arr 待打印数组
     */
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

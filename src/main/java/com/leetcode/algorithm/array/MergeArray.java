package com.leetcode.algorithm.array;

/**
 *给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 示例 1：
 * 256 000
 * 123
 * 2 3 5  6
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j=n-1;
        int len = n+m-1;
        while(i>=0 && j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[len]  = nums1[i];
                i--;
            }else{
                nums1[len]  = nums2[j];
                j--;
            }
            len--;
        }
        while(j>=0) {
            nums1[len] = nums2[j];
            j--;
            len--;
        }
    }

    public static void main(String[] args){

        merge(new int[]{4,5,6,0,0,0}, 3,new int[]{1,2,3}, 3);
    }
}

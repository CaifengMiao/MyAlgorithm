package com.leetcode.algorithm.array;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates {
    /**
     * 原地算法直接想到双指针，将数组区分未两个空间，一个是不重复空间，一个是普通空间
     * i指针向普通区间头部，如果i和i-1不相等，就是碰见了一个新的对象，假如不重复空间，直到数组末尾退出
     * j指向不重复空间尾部，添加一个不重复元素就加一，i到末尾后，j就是非重复元素的个数
     * @param nums
     */
    public int removeDuplicates(int[] nums) {
        int i=1,j=1;
        while(i<nums.length){
            if(nums[i]!=nums[i-1]){
                nums[j]=nums[i+1];
                j++;
                i++;
            }else{
                i++;
            }
        }

        return j;
    }
}

package com.leetcode.algorithm.Linked;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 */
public class MergeLinked {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null,head =null;
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        while(l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                if (result == null) {
                    result = l1;
                    head = result;
                    l1 = l1.next;
                } else {
                    result.next = l1;
                    l1 = l1.next;
                    result = result.next;
                }
            } else {
                if (result == null) {
                    result = l2;
                    head = result;
                    l2 = l2.next;
                } else {
                    result.next = l2;
                    l2 = l2.next;
                    result = result.next;
                }
            }
        }
        while(l1!=null){
            result.next = l1;
            l1=l1.next;
            result=result.next;
        }
        while(l2!=null){
            result.next = l2;
            l2=l2.next;
            result=result.next;
        }
        return head;

    }

}


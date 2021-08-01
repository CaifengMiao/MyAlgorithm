package com.leetcode.algorithm.linked;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val,
 * and return the new head.
 *
 * Example 1:
 * Input: head = [1,2,6,3,4,5,6], val = 6 , Output: [1,2,3,4,5
 * Example 2:
 * Input: head = [], val = 1 , Output: []
 *
 * Example 3:
 * Input: head = [7,7,7,7], val = 7 , Output: []
 *
 * from：LeetCode
 * Link：https://leetcode-cn.com/problems/remove-linked-list-elements
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }
}

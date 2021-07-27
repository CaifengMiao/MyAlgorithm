package com.leetcode.algorithm.linked.basicoperation;

import com.leetcode.algorithm.linked.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *2 1  3 2 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 */
public class ReverseLinkedList {
    /**
     * Define two variables pre and cur , pre is the head of reverse linked header node , and cur is the head of current
     * linked. Save the next node of cur with NXT, update the next node of cur node to pre, and then set cur node to pre
     * and cur node to nxt
     * Repeat the operation until there is no next node in the linked list
     *
     *
     * ｜ head ｜ --> ｜      ｜ --> ｜      ｜ --> ｜      ｜ --> ｜      ｜
     *    ｜
     *    ｜----->
     *
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode reverseHead = null, currentHead = head;
        while(currentHead != null){
            ListNode currentNext = currentHead.next;
            currentHead.next = reverseHead;
            reverseHead = currentHead;
            currentHead = currentNext;
        }
        return reverseHead;
    }
}

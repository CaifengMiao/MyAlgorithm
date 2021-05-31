package com.leetcode.algorithm.Linked;

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
     * 思路：
     *      定义两个变量，一个是反转链表头节点pre ，一个是当前节点cur，
     *      将cur的后继节点设为next节点，将cur节点的后继结点改为pre节点，即将当前节点插入反转链表头；
     *      之后将反转链表头节点设置为cur节点，cur节点移动到下一节点重复操作直到链表没有后继节点为止。
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}

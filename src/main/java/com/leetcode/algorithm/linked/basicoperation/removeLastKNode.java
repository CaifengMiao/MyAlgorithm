package com.leetcode.algorithm.linked.basicoperation;

import com.leetcode.algorithm.linked.ListNode;

public class removeLastKNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode fast = head;
        ListNode slow = dummy;
        while(--n > 0){
            fast = fast.next;
        }
        while (fast != null && fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next!=null)
            slow.next = slow.next.next;
        return dummy.next;
    }

}

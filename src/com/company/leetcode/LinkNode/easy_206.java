package com.company.leetcode.LinkNode;

//反转链表
public class easy_206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null)
        {
            ListNode tmp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=tmp;
        }
        return prev;
    }
}

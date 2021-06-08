
package com.company.leetcode.others;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


/*
* 从链表头部开始访问
* */
//public class med_2 {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode result;
//        if (l1!=null && l2!=null)
//        {
//            int tmp=l1.val+l2.val;
//            if (tmp>=10)
//            {
//                result.next.val=tmp-10;
//            }
//        }
//    }

//}

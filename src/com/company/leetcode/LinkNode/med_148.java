package com.company.leetcode.LinkNode;

import java.util.ArrayList;
import java.util.Arrays;

public class med_148 {
    //取出链表中的值排序+重新构造链表
    public ListNode sortList(ListNode head) {
        ListNode p=head;
        ArrayList<Integer> nums=new ArrayList<>();
        while(p!=null)
        {
            nums.add(p.val);
            p=p.next;
        }
        //list转换为数组，使用有参函数toArray()
        Integer[] arr=nums.toArray(new Integer[nums.size()]);
        Arrays.sort(arr);
        //构造新的链表,使用哑节点更好点，因为要追加后继节点
        ListNode prevhead=new ListNode(-1);
        ListNode prev=prevhead;
        for (Integer integer : arr) {
            prev.next = new ListNode(integer);
            prev = prev.next;
        }
        return prevhead.next;
    }
}
